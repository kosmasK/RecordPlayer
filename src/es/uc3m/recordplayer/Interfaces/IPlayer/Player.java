package es.uc3m.recordplayer.Interfaces.IPlayer;

import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;
import es.uc3m.recordplayer.logic.Song;

public class Player implements IPlayer {

	@Override
	public boolean isAxlePinned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pinAxle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAxleEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAxleFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTurntableStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startTurntable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopTurntable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTurntableRpm(Rpm rpm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rpm getTurntableRpm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putRecordInAxle(Record record, char sideIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropRecordFromAxle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IList<Record> removeAllRecordsFromTurntable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStylusParked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void parkStylus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unparkStylus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStylusDropped() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void liftStylus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropStylus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStylusPosition(float position) {
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

	@Override
	public Song getPlayingTrack() {
		// TODO Auto-generated method stub
		return null;
	}

}
