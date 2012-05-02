package es.uc3m.recordplayer.Interfaces.ITurntable;

import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.Interfaces.IAxle.IAxle;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;

public class Turntable implements ITurntable {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRpm(Rpm rpm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rpm getRpm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putRecord(Record record, char sideIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IList<Record> removeRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAxle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pinAxle(IAxle axle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unpinAxle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Record getTopRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getTopSideIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}
