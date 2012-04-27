package es.uc3m.recordplayer;

import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.list.arraylist.AList;
import es.uc3m.eda.list.arraylist.AListIterator;

public class RecordCollection extends SList<Record> {
	
	
	//default constructor
	public RecordCollection(){}
	
	//parameterized constructor
	/*
	public RecordCollection(SList<Record> r){
		this.recordList=r;
	}
	
	//set method
	public void setRecordList(SList<Record> r){
		this.recordList=r;
	}
	
	//get method
	public SList<Record> getRecordList(){
		return this.recordList;
	}
	*/
	
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
		int i=0;
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			if (iterator.getCurrentElem().getRecordPerformer().equals(p)){
				performerRecords.insertAt(i,iterator.getCurrentElem());
				i++;
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
	public AList<Song> getTracksByGenre(GenreType g){
		AList<Song> tracksByGenre = new AList<Song>();
		int i=0;
		//Side[] side=new Side[2];
		
		//record iteration
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			//side=iterator.getCurrentElem().getSides();
			//side loop
			for (int j=0; i<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSides()[j].getSide().createIterator(); iterator2.isValid();
						iterator2.moveNext()){
					// Check for the genre
					if (iterator2.getCurrentElem().getGenre().equals(g)){
						tracksByGenre.insertAt(i,iterator2.getCurrentElem());
						i++;
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
		int i=0;
		//Side[] side=new Side[2];
		
		//record iteration
		for (SListIterator<Record> iterator = createIterator(); iterator.isValid(); iterator.moveNext()) {			
			//side=iterator.getCurrentElem().getSides();
			//side loop
			for (int j=0; i<2; j++){
				//track iteration
				for (AListIterator<Song> iterator2= iterator.getCurrentElem().getSides()[j].getSide().createIterator(); iterator2.isValid();
						iterator2.moveNext()){
					// Check for the title
					if (iterator2.getCurrentElem().getTitle().equals(t)){
						recordsBySongTitle.insertAt(i,iterator.getCurrentElem());
						i++;
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
	
}
	
	

