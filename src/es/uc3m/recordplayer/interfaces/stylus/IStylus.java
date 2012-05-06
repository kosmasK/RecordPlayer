package es.uc3m.recordplayer.interfaces.stylus;

public interface IStylus {
	public boolean isParked();
	public void park();
	public void unpark();
	public boolean isDropped();
	public void lift();
	public void drop();
	public void setPosition(float position);
	public float getPosition();
}
