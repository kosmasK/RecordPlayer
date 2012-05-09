package es.uc3m.recordplayer.test;

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
		  Performer metallica = new Performer("Metallica", PerformerType.GROUP); //Proposed by the amazing Thór
		  
		  //Creating the records for proposed performers
		  Record mozartCollection = new Record(mozart,"Mozart Collection",1783, Rpm.SPEED33);
		  Record letItBe = new Record(theBeatles, "Let it Be", 1970, Rpm.SPEED33);
		  Record bicycleRace = new Record(queen, "Bicycle Race / Fat Bottomed Girls", 1978, Rpm.SPEED45);
		  Record perdidoMiHabi = new Record(mecano, "Perdido en mi habitación", 1981, Rpm.SPEED45);
		  Record mecanoMecano = new Record(mecano, "Mecano", 1982, Rpm.SPEED33);
		  Record underTheMistleToe = new Record(bieber, "Under the MistleToe", 2011, Rpm.SPEED33); //Proposed by Kosmas
		  Record blackAlbum = new Record(metallica, "Metallica(Black Album)", 1991, Rpm.SPEED33); //Proposed by the amazing Thór

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
		  //Perdido mi habitación
		  perdidoMiHabi.addTrack(0, "Perdido En Mi Habitación", Genre.POP, 1981, 234, true, true, true);
		  perdidoMiHabi.addTrack(1, "No se", Genre.POP, 1981, 187, true, true, true);
		  //Mecano
		  mecanoMecano.addTrack(0, "Mecano", Genre.POP, 1982, 342, true, true, true);
		  mecanoMecano.addTrack(1, "Mecano (Skrillex Drop the Bass Remix)", Genre.DANCE, 2011, 438, false, false, true);
		  //Under the Mistle Toe *Especíal por Kosmas Kritsis
		  underTheMistleToe.addTrack(0, "Only thing I ever get for Christmas", Genre.POP, 2011, 72, false, true, true);
		  underTheMistleToe.addTrack(0, "Mistletoe", Genre.POP, 2011, 145, false, true, true);
		  underTheMistleToe.addTrack(1, "Kosmas love", Genre.POP, 2011, 897, true, true, true);
		  underTheMistleToe.addTrack(1, "Kosmas is coming to town", Genre.POP, 2011, 1287, true, true, true);
		  underTheMistleToe.addTrack(1, "Kosmas at christmas", Genre.OTHERS, 2011, 34, true, true, true);
		  //Metallica(Black Album) *Especíal por Thór porque él es el dios del metal
		  blackAlbum.addTrack(0, "Enter Sandman", Genre.ROCK, 1991, 331, true, true, true);
		  blackAlbum.addTrack(0, "Sad But True", Genre.ROCK, 1991, 324, true, true, true);
		  blackAlbum.addTrack(1, "Wherever Thór may Roam", Genre.ROCK, 1991, 404, true, true, true);
		  blackAlbum.addTrack(1, "The God that didn't fail(Thór)", Genre.ROCK, 1991, 307, true, true, true);

		  //Adding records to collection
		  recordCollection.addLast(mozartCollection);
		  recordCollection.addLast(letItBe);
		  recordCollection.addLast(bicycleRace);
		  recordCollection.addLast(perdidoMiHabi);
		  recordCollection.addLast(mecanoMecano);
		  recordCollection.addLast(underTheMistleToe);
		  recordCollection.addLast(blackAlbum);
		  
	};
	public void testQueries() {
		//For loop to iterate easily through collection
		for (int i = 0 ; i < recordCollection.getSize() ; i++) {
			System.out.println("Album number " + (i+1) + " in collection is " + recordCollection.getAt(i));
		}
	}
	public void test1() {
	    initializeRecords();
	    testQueries();
	};
	public static void main(String[] args) {
	    Test test=new Test();
	    test.test1();
	  }
	
}