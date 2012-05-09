package es.uc3m.recordplayer.test;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;
import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.recordplayer.interfaces.player.IPlayer;
import es.uc3m.recordplayer.interfaces.recordshelf.IRecordShelf;
import es.uc3m.recordplayer.interfaces.recordstack.IRecordStack;
import es.uc3m.recordplayer.logic.*;


public class Test {
	  RecordCollection recordCollection = new RecordCollection ();
	  public void initializeRecords() {
		  // Start by creating all the performers from proposed excel file + adding a few well chosen ones
		  Performer mozart = new Performer("Mozart",PerformerType.SOLOIST_MALE);
		  Performer theBeatles = new Performer("The Beatles", PerformerType.GROUP);
		  Performer queen = new Performer("Queen", PerformerType.GROUP);
		  Performer mecano = new Performer("Mecano", PerformerType.GROUP);
		  Performer bieber = new Performer("Justin Bieber", PerformerType.SOLOIST_MALE); //Proposed by Kosmas
		  Performer metallica = new Performer("Metallica", PerformerType.GROUP); //Proposed by the amazing Th�r
		  
		  //Creating the records for proposed performers
		  Record mozartCollection = new Record(mozart,"Mozart Collection",1783, Rpm.SPEED33);
		  Record letItBe = new Record(theBeatles, "Let it Be", 1970, Rpm.SPEED33);
		  Record bicycleRace = new Record(queen, "Bicycle Race / Fat Bottomed Girls", 1978, Rpm.SPEED45);
		  Record perdidoMiHabi = new Record(mecano, "Perdido en mi habitaci�n", 1981, Rpm.SPEED45);
		  Record mecanoMecano = new Record(mecano, "Mecano", 1982, Rpm.SPEED33);
		  Record underTheMistleToe = new Record(bieber, "Under the MistleToe", 2011, Rpm.SPEED33); //Proposed by Kosmas
		  Record blackAlbum = new Record(metallica, "Metallica(Black Album)", 1991, Rpm.SPEED33); //Proposed by the amazing Th�r

		  //Adding tracks to records
		  //Mozart Collection
		  mozartCollection.addTrack(0, "The magic flute (act 1)",Genre.CLASSICAL, 1783, 540, true, true, true);
		  mozartCollection.addTrack(1, "The magic flute (act 2)",Genre.CLASSICAL, 1783, 540, true, true, true);
		  //Let it Be
		  letItBe.addTrack(0, "The one after 909",Genre.ROCK, 1970, 212, true, true, true);
		  letItBe.addTrack(0, "Rocker (Improvisation", Genre.ROCK, 1970, 234, true, true, true);
		  letItBe.addTrack(1, "For you Blue", Genre.ROCK, 1970, 199, true, true, true);
		  letItBe.addTrack(1, "Teddy Boy", Genre.ROCK, 1970, 204, true, true, true);
		  //Bicycle Race
		  bicycleRace.addTrack(0, "Bicycle Race", Genre.ROCK, 1978, 325, true, true, true);
		  bicycleRace.addTrack(1, "Fat bottomed girls", Genre.ROCK, 1978, 285, true, true, true);
		  //Perdido mi habitaci�n
		  perdidoMiHabi.addTrack(0, "Perdido En Mi Habitaci�n", Genre.POP, 1981, 234, true, true, true);
		  perdidoMiHabi.addTrack(1, "No se", Genre.POP, 1981, 187, true, true, true);
		  //Mecano
		  mecanoMecano.addTrack(0, "Mecano", Genre.POP, 1982, 342, true, true, true);
		  mecanoMecano.addTrack(1, "Mecano (Skrillex Drop the Bass Remix)", Genre.DANCE, 2011, 438, false, false, true);
		  //Under the Mistle Toe *Espec�al por Kosmas Kritsis
		  underTheMistleToe.addTrack(0, "Only thing I ever get for Christmas", Genre.POP, 2011, 72, false, true, true);
		  underTheMistleToe.addTrack(0, "Mistletoe", Genre.POP, 2011, 145, false, true, true);
		  underTheMistleToe.addTrack(1, "Kosmas love", Genre.POP, 2011, 897, true, true, true);
		  underTheMistleToe.addTrack(1,"Kosmas is coming to town", Genre.POP, 2011, 1287, true, true, true);
		  underTheMistleToe.addTrack(1, "Kosmas at christmas", Genre.OTHERS, 2011, 34, true, true, true);
		  //Metallica(Black Album) *Espec�al por Th�r porque �l es el dios del metal
		  blackAlbum.addTrack(0, "Enter Sandman", Genre.ROCK, 1991, 331, true, true, true);
		  blackAlbum.addTrack(0, "Sad But True", Genre.ROCK, 1991, 324, true, true, true);
		  blackAlbum.addTrack(1, "Wherever Th�r may Roam", Genre.ROCK, 1991, 404, true, true, true);
		  blackAlbum.addTrack(1, "The God that didn't fail(Th�r)", Genre.ROCK, 1991, 307, true, true, true);

		  //Adding records to collection
		  recordCollection.addLast(mozartCollection);
		  recordCollection.addLast(letItBe);
		  recordCollection.addLast(bicycleRace);
		  recordCollection.addLast(perdidoMiHabi);
		  recordCollection.addLast(mecanoMecano);
		  recordCollection.addLast(underTheMistleToe);
		  recordCollection.addLast(blackAlbum);
		  
		  //Begin test part 2
		  
		  
	}
	
	//PART 2
	
	
	IRecordStack stackOne=new RecordStack();
	IRecordStack stackTwo=new RecordStack();
	IRecordShelf recordShelf=new RecordShelf(16);
	
	IPlayer player = new Player();
	
	
	public void initializeStacks(){
		for(SListIterator<Record> iterator=this.recordCollection.createIterator();
				iterator.isValid(); iterator.moveNext()){
			this.stackOne.push(iterator.getCurrentElem());
		}
	}
	
	
	// Find a record by title in the stack <=============== WRONG ... CORRECT ... NO TENGO IDEA!
	public boolean isFoundStack(String title){

        boolean found=true;
        
        while (!this.stackOne.isEmpty()){
                
            if(!(this.stackOne.top().getTitle()==null)){
                    this.stackTwo.push(this.stackOne.pop());
                    found=false;
            }
        }
        
        if (found){        
                return found;
        }
        else{
                
	        while (!this.stackTwo.isEmpty()){
	                if(!(this.stackTwo.top().getTitle()==null)){
	                        this.stackOne.push(this.stackTwo.pop());
	                        found=false;
	                }
	        }
	        if (found){        
	                this.stackOne.push(this.stackTwo.pop());
	        }
	        return found;
        }
	}
	
	// Fill Record Shelf from the stacks ( first from stack one and then from stack two)
	public void fillRecordShelf(){
		int i=0;
		while(!this.stackOne.isEmpty() && i<this.recordShelf.getSize()){	
				this.recordShelf.putRecordOnSlot(this.stackOne.pop() , i);
				
				i++;
		}
		
		while(!this.stackTwo.isEmpty() && i<this.recordShelf.getSize()){	
			this.recordShelf.putRecordOnSlot(this.stackTwo.pop() , i);
			i++;
		}
	}
	
	
	//Initializes the Shelf labels according to the record
	public void initializeLabelByRecord(){
		for(int i=0; i<this.recordShelf.getSize(); i++){
			this.recordShelf.setLabelOfSlot(this.recordShelf.getRecordFromSlot(i), i);
		}
	}
	
	
	
	//Sorts the labels first by performer and if same title by year
	public void sortLabels(){
		Record temp=new Record();
		
		for(int i=1;i<10;i++){
			for(int j=0;j<10-j;j++){
				if (this.recordShelf.getLabelOfSlot(j)==null){
					temp=this.recordShelf.getLabelOfSlot(j);
					this.recordShelf.setLabelOfSlot(this.recordShelf.getLabelOfSlot(j+1), j);
					this.recordShelf.setLabelOfSlot(temp, j+1);
				}
				else if(this.recordShelf.getLabelOfSlot(j).getRecordPerformer().getName().compareTo(this.recordShelf.getLabelOfSlot(j+1).getRecordPerformer().getName())>0)
				{
					temp=this.recordShelf.getLabelOfSlot(j);
					this.recordShelf.setLabelOfSlot(this.recordShelf.getLabelOfSlot(j+1), j);
					this.recordShelf.setLabelOfSlot(temp, j+1);
				
				}
				else if(this.recordShelf.getLabelOfSlot(j).getRecordPerformer().getName().compareTo(this.recordShelf.getLabelOfSlot(j+1).getRecordPerformer().getName())==0)
				{
					if(this.recordShelf.getLabelOfSlot(j).getEditionYear()>this.recordShelf.getLabelOfSlot(j+1).getEditionYear()){
						temp=this.recordShelf.getLabelOfSlot(j);
						this.recordShelf.setLabelOfSlot(this.recordShelf.getLabelOfSlot(j+1), j);
						this.recordShelf.setLabelOfSlot(temp, j+1);
					}
				}
			}
		}
	}
	
	//Sorts the records of the shelf according to the labels
	public void sortRecordByLabel(){
		int i;
		
		for(i=0; i< this.recordShelf.getSize(); i++){
			if(!this.recordShelf.isEmptySlot(i)){
				this.stackOne.push(this.recordShelf.getRecordFromSlot(i));
		
			}
		}
		
		while(!this.stackOne.isEmpty() && !(this.stackOne.top()==null)){
			for(i=0; i< this.recordShelf.getSize(); i++){
				if(this.stackOne.top().equals(this.recordShelf.getLabelOfSlot(i))){
					this.recordShelf.putRecordOnSlot(this.stackOne.pop(), i);
					i=-1;
					break;
				}
			}
			if(i!=1){
				this.stackTwo.push(this.stackOne.pop());
			}
		}
	}
	
	
	
	//PART 3
	
	// Search for a record first in the shelf and then in the stacks
	public Record findRecord(Record record){
		Record target=new Record();
		target=null;
		for (int i=0; i< this.recordShelf.getSize(); i++){
			if(!this.recordShelf.isEmptySlot(i)){
				target=this.recordShelf.getRecordFromSlot(i);
				if(target.equals(record)){
					return target;
				}
				else{
					this.recordShelf.putRecordOnSlot(record, i);
					}
			}
		}
		
/*
 *
 * This part of the method craetes a nullPointerException. Is eplained in report
		if(isFoundStack(record.getTitle())){
			target=this.stackOne.pop();
		}
*/
		return target;
	}
	
	
	// place a record in the right slot if not on top of stackOne
	public void placeRecordInSlot(Record record){
		for (int i=0; i< this.recordShelf.getSize(); i++){
			if(!this.recordShelf.isEmptySlot(i) && (this.recordShelf.getLabelOfSlot(i)!=null)){
				if(this.recordShelf.getLabelOfSlot(i).equals(record)){
					this.recordShelf.putRecordOnSlot(record, i);
					System.out.println("Record : " + record.getTitle() + "added to shelf");
					return;
				}
			}
		}	
		this.stackOne.push(record);
		System.out.println("Record : " + record.getTitle() + "added to stack");
	}
	
	
	//Remove all records from player and place them in the right position 
	public void removeRecordsFromPlayer(){
		if (this.player.isAxlePinned()){
			this.player.parkStylus();
			this.player.stopTurntable();
			while(!this.player.isAxleEmpty()){		
				this.player.dropRecordFromAxle();
			}
			this.player.unpinAxle();
			IList<Record> removedRecords;
			removedRecords=this.player.removeAllRecordsFromTurntable();
			for (IListIterator<Record> iterator=removedRecords.createIterator();iterator.isValid()
					;iterator.moveNext()){
				placeRecordInSlot(iterator.getCurrentElem());
			}
		}
	}
	
	//And Last but not least 'THE PLAY TRACK METHOD'!!! AWESOME! Nice music right?
	public void playTrack(String title){
		removeRecordsFromPlayer();
		Side target=this.recordCollection.getSideByTrackTitle(title);
		if(!(target==null)){
			if (!(findRecord(this.recordCollection.getSideByTrackTitle(title).getRecord())==null)){		
				this.player.pinAxle();
				this.player.putRecordInAxle(target);
				while(!this.player.isAxleEmpty()){
					this.player.dropRecordFromAxle();
				}
				this.player.setTurntableRpm();
				this.player.unparkStylus();
				this.player.setStylusPosition(target.getStylusPositionByTrack(title));
				this.player.dropStylus();
				this.player.startTurntable();
				System.out.println("Track "+this.player.getPlayingTrack().getTitle()+" is currently playing! Sweet!");
			}
			else{
				System.out.println("go here?");
			}
		}
		else{
			System.out.println("Some ERROR occurred!!!");
		}
	}
	
	//PART 4
	
	
	public void trackCollectionTest(){
		//Track collection test
		TrackCollection collection=new TrackCollection(this.recordCollection);
		System.out.println("Let see our tree: \n");
		collection.showTrackCollection();
		TrackCollection artistCollection=collection.getTrackCollectionByPerformer("Mecano");
		System.out.println("Let see our artist tree: \n");
		artistCollection.showTrackCollection();
		
		
		//Track tree by title test
		TrackTreeByTitle treeTitle=new TrackTreeByTitle(collection);
		System.out.println("Let see our tree by title: \n");
		treeTitle.showTrackTreeByTitleInOrder();
		if(treeTitle.containsTrackByTitle("For you Blue")){
			System.out.println("\nThe tree contains the track 'For you Blue'!!\n");
		}
		else{
			System.out.println("Sorry... ERROR!!\n");
		}
		
		System.out.println("Recorded Between 1980 -1991");
		TrackCollection bettwenYears=treeTitle.tracksByYearsRange(1980, 1991);
		bettwenYears.showTrackCollection();
		
		
		
		//Track tree by test
		TrackTreeByYear  treeYear=new TrackTreeByYear(collection);
		System.out.println("Let see our tree by year: \n");
		treeYear.showTrackTreeByYearInOrder();
		if(treeYear.containsTrackByTitle("For you Blue")){
			System.out.println("\nThe tree contains the track 'For you Blue'!!\n");
		}
		else{
			System.out.println("Sorry... ERROR!!\n");
		}
		
		System.out.println("Recorded Between 1980 -1991");
		bettwenYears=treeYear.tracksByYearsRange(1980, 1991);
		bettwenYears.showTrackCollection();
		
	}	
	// Test Queries
	
	public void testQueries() {
		System.out.println("Begin of tests for part 1");
		//For loop to iterate easily through collection
		for (int i = 0 ; i < recordCollection.getSize() ; i++) {
			System.out.println("Album number " + (i+1) + " in collection is " + recordCollection.getAt(i));
		}
		System.out.println("**********End of test queries for part 1.***********");
		
		
	}
	public void test1() {
	    initializeRecords();
	    testQueries();
	}
	
	//End of part 1 test
	
	public void testStacks() {
		initializeStacks();
		if ( isFoundStack("Metallica(Black Album)") ){
			System.out.println("Rock on, Metallica(Black Album) is available on stack");
		}
		else{
			System.out.println("Black album was not found on stack (something is wrong)");
		}
	}
	 
	public void testShelf() {
		fillRecordShelf();
		initializeLabelByRecord();
		sortLabels();
		sortRecordByLabel(); //Something unexepected happens to fillRecordShelf
	}
	  
	public void test2() {
	    //Searches for album : Metallica(Black Album)
		testStacks();
	    //Various tests for shelf
	    testShelf();
	}
	
	public void test3(){
		System.out.println("********Begin of test 3*******");
		findRecord(recordShelf.getRecordFromSlot(4)); //This creates nullPointerException
		//Adding to shelf
		placeRecordInSlot(recordCollection.getAt(6));
		
		findRecord(recordShelf.getRecordFromSlot(6)); //This creates nullPointerException
		playTrack("Sad But True"); //Track is not found because of isFoundStack() method problem
		
	}
	
	
	public void test4(){
		trackCollectionTest();
	}
	
	
	public static void main(String[] args) {
	    Test test=new Test();
	    test.test1();
	    test.test2();
	    test.test3();
	    test.test4();
	  }
	
}