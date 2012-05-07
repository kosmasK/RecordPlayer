package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.IQueue;
import es.uc3m.eda.list.singlelink.SQueue;
import es.uc3m.recordplayer.interfaces.axle.IAxle;
import es.uc3m.recordplayer.interfaces.turntable.ITurntable;

public class Axle implements IAxle{
	private IQueue<Side> waitingRecords;
	private boolean pinned;
	private ITurntable turntable;
	private int size; 
	
	//default constructor
	public Axle(){
		this.turntable=null;
		this.waitingRecords= new SQueue<Side>();
		this.size=0;
	}
	
	@Override
	public void pinOnTurntable(ITurntable turntable) {
		this.turntable=turntable;
		this.pinned=true;
		
	}

	@Override
	public void unpinFromTurntable() {
		if (isEmpty()){
			this.turntable=null;
			this.pinned=false;
		}
	}

	@Override
	public void putRecord(Side side) {
		if(isPinned() && (!isFull())){
			this.waitingRecords.enqueue(side);
			this.size++;
		}
		
	}

	@Override
	public void dropRecord() {
		if(size>0){
			this.turntable.putRecord(this.waitingRecords.dequeue());
			size--;
		}
	}

	@Override
	public boolean isPinned() {
		return this.pinned;
	}

	@Override
	public boolean isFull() {		
		return (this.size==5);
	}

	@Override
	public boolean isEmpty() {
		return this.waitingRecords.isEmpty();
	}

}
