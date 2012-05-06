package es.uc3m.recordplayer.Interfaces.IPlayer;

import es.uc3m.eda.list.IList;
import es.uc3m.recordplayer.Interfaces.IAxle.Axle;
import es.uc3m.recordplayer.Interfaces.IAxle.IAxle;
import es.uc3m.recordplayer.Interfaces.IStylus.IStylus;
import es.uc3m.recordplayer.Interfaces.IStylus.Stylus;
import es.uc3m.recordplayer.Interfaces.ITurntable.ITurntable;
import es.uc3m.recordplayer.Interfaces.ITurntable.Turntable;
import es.uc3m.recordplayer.logic.Record;
import es.uc3m.recordplayer.logic.Rpm;
import es.uc3m.recordplayer.logic.Side;
import es.uc3m.recordplayer.logic.Song;

public class Player implements IPlayer {
	
	private ITurntable turntable;
	private IAxle axle;
	private IStylus stylus;
	
	public Player(){
		this.turntable=new Turntable();
		this.axle=new Axle();
		this.stylus=new Stylus(); 
	}
	
	@Override
	public boolean isAxlePinned() {
		return this.axle.isPinned();
	}

	@Override
	public void pinAxle() {
		this.axle.pinOnTurntable(turntable);
	}

	@Override
	public boolean isAxleEmpty() {
		return this.axle.isEmpty();
	}

	@Override
	public boolean isAxleFull() {
		return this.axle.isFull();
	}

	@Override
	public boolean isTurntableStarted() {
		return this.turntable.isStarted();
	}

	@Override
	public void startTurntable() {
		this.turntable.start();
	}

	@Override
	public void stopTurntable() {
		if (isStylusDropped()==false){
			this.turntable.stop();
		}
	}

	@Override
	public void setTurntableRpm() {
		if (isStylusDropped()==false){
			this.turntable.setRpm();
		}
	}

	@Override
	public Rpm getTurntableRpm() {
		return this.turntable.getRpm();
	}

	@Override
	public void putRecordInAxle(Side side) {
		this.axle.putRecord(side);
	}

	@Override
	public void dropRecordFromAxle() {
		if(this.stylus.isParked()){
			this.axle.dropRecord();
		}
	}

	@Override
	public IList<Record> removeAllRecordsFromTurntable() {
		this.stylus.park();
		this.turntable.stop();
		return this.turntable.removeRecords();
	}

	@Override
	public boolean isStylusParked() {
		return this.stylus.isParked();
	}

	@Override
	public void parkStylus() {
		this.stylus.park();
	}

	@Override
	public void unparkStylus() {
		this.stylus.unpark();
	}

	@Override
	public boolean isStylusDropped() {
		return this.stylus.isDropped();
	}

	@Override
	public void liftStylus() {
		this.stylus.lift();
	}

	@Override
	public void dropStylus() {
		if (this.turntable.isStarted() && (this.turntable.isEmpty()==false)){
			this.stylus.drop();
		}
	}

	@Override
	public void setStylusPosition(float position) {
		this.stylus.setPosition(position);
	}

	@Override
	public Record getTopRecord() {
		return this.turntable.getTopRecord();
	}

	@Override
	public int getTopSideIndex() {
		return this.turntable.getTopSideIndex();
	}

	@Override
	public Song getPlayingTrack() {
		if(this.turntable.isStarted()==false 
				|| this.stylus.isParked() 
				|| this.stylus.isDropped()==false 
				|| (this.turntable.getRpm().equals(this.turntable.getTopRecord().getRpm()))==false){
			return null;
		}
		else{
			return getTopRecord().getSide(getTopSideIndex()).getTrackByStylusPosition(this.stylus.getPosition());
	
		}
	}
}
