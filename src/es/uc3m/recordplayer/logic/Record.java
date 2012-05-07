package es.uc3m.recordplayer.logic;

public class Record {
	
	private Side sides[];
	private Performer recordPerformer;
	private String title;
	private int editionYear;
	private Rpm recordSpeed;
	
	//default constructor
	public Record(){}
	
	//parameterized constructor
	public Record(Performer p, String t, int e, Rpm r){
		this.sides=new Side[2];
		this.sides[0]=new Side(this,0);
		this.sides[1]=new Side(this,1);
		this.recordPerformer=p;
		this.title=t;
		this.editionYear=e;
		this.recordSpeed=r;		
	}
	
	//set methods
		
	public void setRecordPerformer(Performer p){
		this.recordPerformer=p;
	}
		
	public void setTitle(String t){
		this.title=t;
	}
		
	public void setEditionYear(int e){
		this.editionYear=e;
	}
		
	public void setRpm(Rpm r){
		this.recordSpeed=r;
	}	
	
	//get methods
	public Side getSide(int sideIndex){
		return this.sides[sideIndex];
	}
	
	public Performer getRecordPerformer(){
		return this.recordPerformer;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getEditionYear(){
		return this.editionYear;
	}
	
	public Rpm getRpm(){
		return this.recordSpeed;
	}
	
	@Override
	public String toString() {
		return " "+recordPerformer.getName() + " from the album: " + this.title;
	}
	
	//add track with the same performer as the record
	public void addTrack(int side, String title, Genre genre, int year, float duration, boolean composed, boolean recorded, boolean studio){
		this.sides[side].getSideTracklist().addLast(new Song(title, genre, this.recordPerformer, year, duration, composed, recorded, studio));
	}
	
	//add track with a different performer than the record
	public void addTrack(int side, String title, Genre genre,Performer trackPerf, int year, float duration, boolean composed, boolean recorded, boolean studio){
		this.sides[side].getSideTracklist().addLast(new Song(title, genre, trackPerf, year, duration, composed, recorded, studio));
	}
	
}
