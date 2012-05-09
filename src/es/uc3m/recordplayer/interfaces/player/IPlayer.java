package es.uc3m.recordplayer.interfaces.player;

import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;
import es.uc3m.recordplayer.logic.Side;
import es.uc3m.recordplayer.logic.Song;

public interface IPlayer {
	public boolean isAxlePinned();
	public void pinAxle();
	public void unpinAxle();
	public boolean isAxleEmpty();
	public boolean isAxleFull();
	public boolean isTurntableStarted();
	public void startTurntable();
	public void stopTurntable();
	public void setTurntableRpm();
	public Rpm getTurntableRpm();
	public void putRecordInAxle(Side side);
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
	public int getTopSideIndex();
	public Song getPlayingTrack();
}
