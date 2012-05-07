package es.uc3m.recordplayer.logic;

import es.uc3m.recordplayer.interfaces.stylus.IStylus;

public class Stylus implements IStylus {
	private float position;
	private boolean isDropped;
	private boolean isParked;
	
	public Stylus(){
		this.isParked=true;
		this.position=-1.0f;
		this.isDropped=true;
	}
	
	
	@Override
	public boolean isParked() {
		return this.isParked;
	}

	@Override
	public void park() {
		this.isParked=true;
		this.position=-1.0f;
		this.isDropped=true;
	}

	@Override
	public void unpark() {
		if (isParked()){
			lift();
			setPosition(0.0f);
		}
	}

	@Override
	public boolean isDropped() {
		return this.isDropped;
	}

	@Override
	public void lift() {
		this.isDropped=false;
	}

	@Override
	public void drop() {
		this.isDropped=true;
	}

	@Override
	public void setPosition(float position) {
		if (!this.isDropped){
			this.position=position;	
		}
	}

	@Override
	public float getPosition() {
		return this.position;
	}

}
