package es.uc3m.recordplayer.Interfaces.IRecordShelf;

import es.uc3m.recordplayer.logic.Record;

public interface IRecordShelf {
	public boolean isEmptySlot(int s);
	
	public void putRecordOnSlot(Record r, int s);
	
	public Record getRecordFromSlot(int s);
	
	public void setLabelOfSlot(Record l, int s);
	
	public Record getLabelOfSlot(int s);
}
