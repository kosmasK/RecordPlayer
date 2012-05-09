package es.uc3m.recordplayer.logic;

import es.uc3m.recordplayer.interfaces.recordshelf.IRecordShelf;

public class RecordShelf implements IRecordShelf {
	
	private Record[] slots;
	private Record[] labels;
	
	//default constructor
	public RecordShelf(){};
	
	//parameterized constructor
	public RecordShelf(int n){
		this.slots= new Record[n];
		this.labels= new Record[n];
	}
	
	
	@Override
	public boolean isEmptySlot(int s) {
		return (this.slots[s].equals(null));
	}

	@Override
	public void putRecordOnSlot(Record r, int s) {
		if(isEmptySlot(s)){
			this.slots[s]=r;
		}
		else{
			System.out.println("There is another record in the slot!");
		}
	}

	@Override
	public Record getRecordFromSlot(int s) {
		if(isEmptySlot(s)){
			return null;
		}
		else{
			return this.slots[s];
		}		
	}

	@Override
	public void setLabelOfSlot(Record l, int s) {
		this.labels[s]=l;		
	}

	@Override
	public Record getLabelOfSlot(int s) {
		return this.labels[s];
	}

	public int getSize(){
		return this.slots.length;
	}
}
