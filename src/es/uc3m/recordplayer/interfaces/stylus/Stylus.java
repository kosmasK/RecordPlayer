package es.uc3m.recordplayer.interfaces.stylus;

public class Stylus implements IStylus {
	private float position;
	private boolean dropped;
	private boolean parked;
	
	public Stylus(){
		this.parked=true;
		this.position=-1.0f;
		this.dropped=true;
	}
	
	
	@Override
	public boolean isParked() {
		return this.parked;
	}

	@Override
	public void park() {
		this.parked=true;
		this.position=-1.0f;
		this.dropped=true;
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
		return this.dropped;
	}

	@Override
	public void lift() {
		this.dropped=false;
	}

	@Override
	public void drop() {
		this.dropped=true;
	}

	@Override
	public void setPosition(float position) {
		if (this.dropped==false){
			this.position=position;	
		}
	}

	@Override
	public float getPosition() {
		return this.position;
	}

}
