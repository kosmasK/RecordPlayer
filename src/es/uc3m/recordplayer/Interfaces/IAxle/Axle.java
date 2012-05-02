package es.uc3m.recordplayer.Interfaces.IAxle;

import es.uc3m.recordplayer.Interfaces.ITurntable.ITurntable;
import es.uc3m.recordplayer.logic.Record;

public class Axle implements IAxle{

	@Override
	public void pinOnTurntable(ITurntable turntable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unpinFromTurntable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putRecord(Record record, char sideIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPinned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
