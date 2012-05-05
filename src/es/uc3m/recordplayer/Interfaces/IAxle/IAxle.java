package es.uc3m.recordplayer.Interfaces.IAxle;

import es.uc3m.recordplayer.Interfaces.ITurntable.ITurntable;
import es.uc3m.recordplayer.logic.Side;


public interface IAxle {
	void pinOnTurntable(ITurntable turntable);
	void unpinFromTurntable();
	void putRecord(Side side);
	void dropRecord();
	boolean isPinned();
	boolean isFull();
	boolean isEmpty();
}
