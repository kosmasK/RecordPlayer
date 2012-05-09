package es.uc3m.recordplayer.test;

import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.recordplayer.interfaces.recordshelf.IRecordShelf;
import es.uc3m.recordplayer.interfaces.recordstack.IRecordStack;
import es.uc3m.recordplayer.logic.*;

public class Test2 {
	
	RecordCollection recordCollection;
	
	
	
	
	IRecordStack stackOne=new RecordStack();
	IRecordStack stackTwo=new RecordStack();
	IRecordShelf recordShelf=new RecordShelf(16);
	
	
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
	

	
	
}
