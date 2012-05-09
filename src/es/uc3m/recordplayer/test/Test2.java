package es.uc3m.recordplayer.test;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;
import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.recordplayer.interfaces.player.IPlayer;
import es.uc3m.recordplayer.interfaces.recordshelf.IRecordShelf;
import es.uc3m.recordplayer.interfaces.recordstack.IRecordStack;
import es.uc3m.recordplayer.logic.*;

public class Test2 {
	
	RecordCollection recordCollection;
	
	IRecordStack stackOne=new RecordStack();
	IRecordStack stackTwo=new RecordStack();
	IRecordShelf recordShelf=new RecordShelf(16);
	
	IPlayer player = new Player();
	
	
	public void initializeStacks(){
		for(SListIterator<Record> iterator=this.recordCollection.createIterator();
				iterator.isValid(); iterator.moveNext()){
			this.stackOne.push(iterator.getCurrentElem());
		}
	}
	
	
	// Find a record by title in the stack <=============== WRONG ... CORRECT ... NO TENGO IDEA TIO!
	public boolean isFoundStack(String title){

		boolean found=true;
		
		while (!this.stackOne.isEmpty() && !this.stackOne.top().getTitle().equals(title)){
			this.stackTwo.push(this.stackOne.pop());
			found=false;
		}
		
		if (found){	
			return found;
		}
		else{
			
			while (!this.stackTwo.isEmpty() && !this.stackTwo.top().getTitle().equals(title)){
				this.stackOne.push(this.stackTwo.pop());
				found=false;
			}
			if (found){	
				this.stackOne.push(this.stackTwo.pop());
			}
			return found;
		}
	}
	
	// Fill Record Shelf from the stacks ( first from stack one and then from stack two)
	public void fillRecordShelf(){
		int i=0;
		while(!this.stackOne.isEmpty() && i<this.recordShelf.getSize()){	
				this.recordShelf.putRecordOnSlot(this.stackOne.pop() , i);
				i++;
		}
		
		while(!this.stackTwo.isEmpty() && i<this.recordShelf.getSize()){	
			this.recordShelf.putRecordOnSlot(this.stackTwo.pop() , i);
			i++;
		}
	}
	
	
	//Initializes the Shelf labels according to the record
	public void initializeLabelByRecord(){
		for(int i=0; i<this.recordShelf.getSize(); i++){
			this.recordShelf.setLabelOfSlot(this.recordShelf.getRecordFromSlot(i), i);
		}
	}
	
	
	
	/*
	public void sortLabels(){
		
	}
	
	
	public void sortRecordByLabel(){
		for(int i=0; i< this.recordShelf.getSize(); i++){
			
		}
	}
	*/
	
	
	//PART3
	
	// Search for a record first in the shelf and then in the stacks
	public Record findRecord(Record record){
		Record target=new Record();
		target=null;
		for (int i=0; i< this.recordShelf.getSize(); i++){
			if(!this.recordShelf.isEmptySlot(i)){
				target=this.recordShelf.getRecordFromSlot(i);
				if(target.equals(record)){
					return target;
				}
				else{
					this.recordShelf.putRecordOnSlot(record, i);
					}
			}
		}
		
		if(isFoundStack(record.getTitle())){
			target=this.stackOne.pop();
		}
		
		return target;
	}
	
	
	// place a record in the right slot if not on top of stackOne
	public void placeRecordInSlot(Record record){
		for (int i=0; i< this.recordShelf.getSize(); i++){
			if(!this.recordShelf.isEmptySlot(i) && (this.recordShelf.getLabelOfSlot(i)!=null)){
				if(this.recordShelf.getLabelOfSlot(i).equals(record)){
					this.recordShelf.putRecordOnSlot(record, i);
					return;
				}
			}
		}	
		this.stackOne.push(record);
	}
	
	
	//Remove all records from player and place them in the right position 
	public void removeRecordsFromPlayer(){
		if (this.player.isAxlePinned()){
			this.player.parkStylus();
			this.player.stopTurntable();
			while(!this.player.isAxleEmpty()){		
				this.player.dropRecordFromAxle();
			}
			this.player.unpinAxle();
			IList<Record> removedRecords;
			removedRecords=this.player.removeAllRecordsFromTurntable();
			for (IListIterator<Record> iterator=removedRecords.createIterator();iterator.isValid()
					;iterator.moveNext()){
				placeRecordInSlot(iterator.getCurrentElem());
			}
		}
	}
}
	
	