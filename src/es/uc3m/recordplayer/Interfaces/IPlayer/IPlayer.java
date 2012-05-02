package es.uc3m.recordplayer.Interfaces.IPlayer;

import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;
import es.uc3m.recordplayer.logic.Song;

public interface IPlayer {
	public boolean isAxlePinned();
	public void pinAxle();
	public boolean isAxleEmpty();
	public boolean isAxleFull();
	public boolean isTurntableStarted();
	public void startTurntable();
	public void stopTurntable();
	public void setTurntableRpm(Rpm rpm);
	public Rpm getTurntableRpm();
	public void putRecordInAxle(Record record, char sideIndex);
	public void dropRecordFromAxle();
	public IList<Record> removeAllRecordsFromTurntable();
	public boolean isStylusParked();
	public void parkStylus();
	public void unparkStylus();
	public boolean isStylusDropped();
	public void liftStylus(); 
	public void dropStylus();
	public void setStylusPosition(float position);
	public Record getTopRecord();
	public char getTopSideIndex();
	public Song getPlayingTrack();
}
