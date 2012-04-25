package es.uc3m.recordplayer;

import es.uc3m.eda.list.arraylist.AList;

public class Side {
	private AList<Song> songs;
	
	//default constructor
	public Side(){}
	
	//parameterized constructor
	public Side(AList<Song> s){
		this.songs=s;
	}
	
	//get method
	public AList<Song> getSide(){
		return this.songs;
	}
	
	//set method
	public void setSide(AList<Song> s){
		this.songs=s;
	}

}
