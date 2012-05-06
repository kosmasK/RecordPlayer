package es.uc3m.recordplayer.interfaces.axle;

import es.uc3m.recordplayer.interfaces.turntable.ITurntable;
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
