package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.arraylist.AListIterator;
import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.list.singlelink.SListIterator;

public class TrackCollection extends SList<Song>{
	
	//default constructor
	public TrackCollection(){}
	
	//constructor hat creates the list from a record collection
	public TrackCollection(RecordCollection recordcollection){
		for (SListIterator<Record> iterator = recordcollection.createIterator(); iterator.isValid(); 
				iterator.moveNext()) {						
			//side loop
			for (int j=0; j<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSide(j).getSideTracklist().createIterator(); iterator2.isValid();
						iterator2.moveNext()){
					
						addLast(iterator2.getCurrentElem());
					
				}//end of track iteration
			}//end of side loop
		}//end of record iteration
	}
	
	//method that returns another track collection containing the tracks performed by a performer
	public TrackCollection getTrackCollectionByPerformer(String artist){
		TrackCollection performerTrackCollection= new TrackCollection();
		for (SListIterator<Song> iterator= createIterator(); iterator.isValid();iterator.moveNext()){
			if (iterator.getCurrentElem().getArtist().getName().equals(artist)){
				performerTrackCollection.addLast(iterator.getCurrentElem());
			}
		}		
		return performerTrackCollection;
	}

	//method that shows the collection	
	public void showTrackCollection(){
		for (SListIterator<Song> iterator= createIterator(); iterator.isValid();iterator.moveNext()){
			System.out.println(iterator.getCurrentElem());
		}
	}
		
}
