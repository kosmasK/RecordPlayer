package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.arraylist.AList;
import es.uc3m.eda.list.arraylist.AListIterator;

public class Side {
	
	private AList<Song> songs;
	private float totalDuration;
	float[] tracksDurationFromZeroSec;
	
	//default constructor
	public Side(){
		this.songs=new AList<Song>();
	}
	
	
	//get method
	public AList<Song> getSide(){
		return this.songs;
	}
	
	//set method
	public void setSide(AList<Song> s){
		this.songs=s;
	}
	
	//get total side duration
	public float getTotalSideDuration(){
		return calculateTotalSideDuration();
	}
	
	//calculate total side duration
	private float calculateTotalSideDuration(){
		this.totalDuration=0.0f;
		this.tracksDurationFromZeroSec=new float[this.songs.getSize()];
		int i=0;
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			//calculate the duration in seconds
			int decimalTrackDuration=(int)((iterator.getCurrentElem().getDuration()-(int)iterator.getCurrentElem().getDuration())*100);
			this.totalDuration=this.totalDuration+(60*(int)iterator.getCurrentElem().getDuration())+decimalTrackDuration;
			
			this.tracksDurationFromZeroSec[i]=this.totalDuration;
			i++;
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
		if (this.tracksDurationFromZeroSec.length==0){
			calculateTotalSideDuration();
		}
		
		int i=0;
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			//check for the title
			if (iterator.getCurrentElem().getTitle().equals(t)){
				int decimalTrackDuration=(int)((iterator.getCurrentElem().getDuration()-(int)iterator.getCurrentElem().getDuration())*100);
				return ((this.tracksDurationFromZeroSec[i]-(60*(int)iterator.getCurrentElem().getDuration())+decimalTrackDuration)*100)/this.totalDuration;
			}			
			i++;
		}
		
		return -1; //error case
	}
	
	//method that returns the track that is playing when the stylus is placed at a given position (0 to 100) on that side
	public Song getTrackByStylusPosition(float stylusPos){
		
		//check if total duration has been calculated before
		if (this.tracksDurationFromZeroSec.length==0){
			calculateTotalSideDuration();
		}

		int i=0;
		for (AListIterator<Song> iterator = this.songs.createIterator(); iterator.isValid(); iterator.moveNext()){ 
			
			if (i==0){
				if(stylusPos>=0.00f && stylusPos<(this.tracksDurationFromZeroSec[i]/this.totalDuration)*100){
					return iterator.getCurrentElem();
				}
			}
			else{
				if(stylusPos>=(this.tracksDurationFromZeroSec[i-1]/this.totalDuration)*100 && stylusPos<(this.tracksDurationFromZeroSec[i]/this.totalDuration)*100){
					return iterator.getCurrentElem();
				}
			}		
			
			i++;
		}
		
		return null; //error case
	}
}//end of class
