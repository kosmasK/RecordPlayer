package es.uc3m.recordplayer.test;

import es.uc3m.recordplayer.logic.*;
//import es.uc3m.recordplayer.logic.RecordCollection;

public class Test {
	  RecordCollection recordCollection = new RecordCollection ();
	  public void initializeRecords() {
	    // create performers, records, songs
		  Performer performer = new Performer("Mozart",PerformerType.SOLOIST_MALE);
		  
	  
		  Record record = new Record(performer,"Mozart Collection",1783,Rpm.SPEED33);

		  record.addTrack(0, "The magic flute (act 1)",Genre.CLASSICAL, 1783, 9, true, true, true);
		  record.addTrack(1, "The magic flute (act 2)",Genre.CLASSICAL, 1783, 9, true, true, true);
		  
		  recordCollection.addLast(record);
		  
	};
	public void testQueries() {
		System.out.println("Record collection contains" + recordCollection.getFirst());
	};
	public void test1() {
	    initializeRecords();
	    testQueries();
	};
	public static void main(String[] args) {
	    Test test=new Test();
	    test.test1();
	  }
	
}