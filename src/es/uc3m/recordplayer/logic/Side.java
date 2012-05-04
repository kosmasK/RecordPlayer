package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.arraylist.AList;
import es.uc3m.eda.list.arraylist.AListIterator;

public class Side {
	
	private AList<Song> songs;
	private float totalDuration;
	
	//default constructor
	public Side(){
		this.songs=new AList<Song>();
		this.totalDuration=-1.0f; // initial value for uncalculated total duration 
	}
	
	//get method
	public AList<Song> getSideTracklist(){
		return this.songs;
	}
	
	//set method
	public void setSide(AList<Song> s){
		this.songs=s;
	}
	
	//get total side duration
	public float getTotalSideDuration(){
		if (this.totalDuration==-1.0f){
			return calculateTotalSideDuration();
		}
		else{
			return this.totalDuration;
		}
	}
	
	//calculate total side duration
	private float calculateTotalSideDuration(){
		this.totalDuration=0.0f;
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			//calculate the duration in seconds
			iterator.getCurrentElem().setStartPoint(this.totalDuration);
			this.totalDuration=this.totalDuration+iterator.getCurrentElem().getDuration();
		}
		return this.totalDuration/60; //result in minutes
	}

	//get track with the specific title
	public Song getSongByTitle(String t){
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			if (iterator.getCurrentElem().getTitle().equals(t))
				return iterator.getCurrentElem();
		}
		return null;
	}
	
	//method that returns the starting stylus position (0 to 100) for a given track contained in the side
	public float getStylusPositionByTrack(String t){
		
		//check if total duration has been calculated before
		if (this.totalDuration==-1.0f){
			calculateTotalSideDuration();
		}
		
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			//check for the title
			if (iterator.getCurrentElem().getTitle().equals(t)){
				return (iterator.getCurrentElem().getStartPoint()*100)/this.totalDuration;				
			}			
		}		
		return -1; //error case
	}
	
	//method that returns the track that is playing when the stylus is placed at a given position (0 to 100) on that side
	public Song getTrackByStylusPosition(float stylusPos){
		
		//check if total duration has been calculated before
		if (this.totalDuration==-1.0f){
			calculateTotalSideDuration();
		}
		
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 				
				if(stylusPos>=((iterator.getCurrentElem().getStartPoint()*100)/this.totalDuration) && 
						stylusPos<(((iterator.getCurrentElem().getStartPoint()+iterator.getCurrentElem().getDuration())*100)/this.totalDuration)){
					return iterator.getCurrentElem();
				}												
		}		
		return null; //error case
	}
}//end of class
