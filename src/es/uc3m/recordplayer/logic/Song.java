package es.uc3m.recordplayer.logic;

public class Song {
	private String title;
	private GenreType genre;
	private Performer artist;
	private int year;
	private float duration;		
	private boolean composed;	// TRUE = composed by the performer, FALSE=performed by the performer
	private boolean recorded;	// TRUE = recorded at this year, FALSE=composed at this year
	private boolean studio;		// TRUE = studio recording, FALSE=live recording
	
	//default constructor
	public Song(){}
	
	//parameterized constructor
	public Song(String t, GenreType g, Performer a, int y, float d, boolean c, boolean r, boolean s){
		this.title=t;
		this.genre=g;
		this.artist=a;
		this.year=y;
		this.duration=d;
		this.composed=c;
		this.recorded=r;
		this.studio=s;
	}
	
	//set methods
	public void setTitle(String t){
		this.title=t;
	}
	
	public void setGenre(GenreType g){
		this.genre=g;
	}
	
	public void setArtist(Performer a){
		this.artist=a;
	}
	
	public void setYear(int y){
		this.year=y;
	}
	
	public void setDuration(float d){
		this.duration=d;
	}
	
	public void setComposed(boolean c){
		this.composed=c;
	}
	
	public void setRecorded(boolean r){
		this.recorded=r;
	}
	
	public void setStudio(boolean s){
		this.studio=s;
	}
	
	//get methods
	public String getTitle(){
		return this.title;
	}
	
	public GenreType getGenre(){
		return this.genre;
	}
	
	public Performer getArtist(){
		return this.artist;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public float getDuration(){
		return this.duration;
	}
	
	public boolean getComposed(){
		return this.composed;
	}
	
	public boolean getRecorded(){
		return this.recorded;
	}
	
	public boolean getStudio(){
		return this.studio;
	}
}
