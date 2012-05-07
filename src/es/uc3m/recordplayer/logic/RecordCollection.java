package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.list.arraylist.AList;
import es.uc3m.eda.list.arraylist.AListIterator;

public class RecordCollection extends SList<Record> {
	
	
	//default constructor
	public RecordCollection(){}

	
	//get record with the specific title
	public Record getRecordByTitle(String t){
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()){ 
			if (iterator.getCurrentElem().getTitle().equals(t))
				return iterator.getCurrentElem();
		}
		return null;
	}
	
	//get records by the specific performer
	public AList<Record> getRecordsByPerfomer(Performer p){
		AList<Record> performerRecords = new AList<Record>();
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			if (iterator.getCurrentElem().getRecordPerformer().equals(p)){
				addLast(iterator.getCurrentElem());
			}
		}//end of loop
		if (performerRecords.isEmpty()){
			return null;
		}
		else{
			return performerRecords;
		}
	}
	
	//get tracks by the specific genre
	public AList<Song> getTracksByGenre(Genre g){
		AList<Song> tracksByGenre = new AList<Song>();
		
		//record iteration
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			//side loop
			for (int j=0; j<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSide(j).getSideTracklist().createIterator(); 
						iterator2.isValid();iterator2.moveNext()){
					
					// Check for the genre
					if (iterator2.getCurrentElem().getGenre().equals(g)){
						tracksByGenre.addLast(iterator2.getCurrentElem());
					}//end of genre check
				
				}//end of track iteration
			}//end of side loop
		}//end of record iteration
		
		if (tracksByGenre.isEmpty()){
			return null;
		}
		else{
			return tracksByGenre;
		}
	}
	
	//get records by the specific track title
	public AList<Record> getRecordsByTrackTitle(String t){
		AList<Record> recordsBySongTitle = new AList<Record>();
		
		//record iteration
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			//side loop
			for (int j=0; j<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSide(j).getSideTracklist().createIterator(); 
						iterator2.isValid();iterator2.moveNext()){
					// Check for the title
					if (iterator2.getCurrentElem().getTitle().equals(t)){
						recordsBySongTitle.addLast(iterator.getCurrentElem());
					}//end of title check
				}//end of track iteration
			}//end of side loop
		}//end of record iteration
		
		if (recordsBySongTitle.isEmpty()){
			return null;
		}
		else{
			return recordsBySongTitle;
		}
	}
	
	//get side with the specific track title (record is notified in the side structure)
	
	public Side getSideByTrackTitle(String t){

		//record iteration
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			//side loop
			for (int j=0; j<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSide(j).getSideTracklist().createIterator(); 
						iterator2.isValid();iterator2.moveNext()){
					// Check for the title
					if (iterator2.getCurrentElem().getTitle().equals(t)){
						return iterator.getCurrentElem().getSide(j);
						
					}//end of title check
				}//end of track iteration
			}//end of side loop
		}//end of record iteration
		return null;
	}
	
}
	
	

