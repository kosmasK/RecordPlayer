package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.arraylist.AListIterator;
import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.list.singlelink.SListIterator;

public class TrackCollection extends SList<Song>{
	
	//default constructor
	public TrackCollection(){}
	
	//constructor hat creates the list from a record collection
	public TrackCollection(RecordCollection recordcollection){
		for (Genre g : Genre.values()){
			for (AListIterator<Song> iterator= recordcollection.getTracksByGenre(g).createIterator(); iterator.isValid();
					iterator.moveNext()){
				addLast(iterator.getCurrentElem());
			}
		
		}
	}
	
	//method that returns another track collection containing the tracks performed by a performer
	public TrackCollection getTrackCollectionByPerformer(Performer p){
		TrackCollection performerTrackCollection= new TrackCollection();
		for (SListIterator<Song> iterator= createIterator(); iterator.isValid();iterator.moveNext()){
			if (iterator.getCurrentElem().getArtist().equals(p)){
				performerTrackCollection.addLast(iterator.getCurrentElem());
			}
		}		
		return performerTrackCollection;
	}

	//TODO a method that shows the collection

}
