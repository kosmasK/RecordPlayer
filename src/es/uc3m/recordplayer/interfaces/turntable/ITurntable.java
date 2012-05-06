package es.uc3m.recordplayer.interfaces.turntable;


import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.interfaces.axle.*;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;
import es.uc3m.recordplayer.logic.Side;

public interface ITurntable {
	public void start();
	public void stop();
	public boolean isStarted();
	public void setRpm();
	public Rpm getRpm();
	public void putRecord(Side side);
	public IList<Record> removeRecords();
	public boolean isEmpty();
	public boolean hasAxle();
	public void pinAxle(IAxle axle); 
	public void unpinAxle();
	public Record getTopRecord();
	public int getTopSideIndex();
}
