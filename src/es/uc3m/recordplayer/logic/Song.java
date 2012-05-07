package es.uc3m.recordplayer.logic;

public class Song {
	private String title;
	private Genre genre;
	private Performer artist;
	private int year;
	private float duration;		// duration in seconds
	private float startPoint;	// starting point for the stylus in seconds
	private boolean isComposed;	// TRUE = composed by the performer, FALSE=performed by the performer
	private boolean isRecorded;	// TRUE = recorded at this year, FALSE=composed at this year
	private boolean isStudio;		// TRUE = studio recording, FALSE=live recording
	
	//default constructor
	public Song(){}
	
	//parameterized constructor
	public Song(String t, Genre g, Performer a, int y, float d, boolean c, boolean r, boolean s){
		this.title=t;
		this.genre=g;
		this.artist=a;
		this.year=y;
		this.duration=d;
		this.isComposed=c;
		this.isRecorded=r;
		this.isStudio=s;
	}
	
	//set methods
	public void setTitle(String t){
		this.title=t;
	}
	
	public void setGenre(Genre g){
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
	
	public void setStartPoint(float s){
		this.startPoint=s;
	}
	
	public void setIsComposed(boolean c){
		this.isComposed=c;
	}
	
	public void setIsRecorded(boolean r){
		this.isRecorded=r;
	}
	
	public void setIsStudio(boolean s){
		this.isStudio=s;
	}
	
	//get methods
	public String getTitle(){
		return this.title;
	}
	
	public Genre getGenre(){
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
	
	public Float getStartPoint(){
		return this.startPoint;
	}
	
	public boolean isComposed(){
		return this.isComposed;
	}
	
	public boolean isRecorded(){
		return this.isRecorded;
	}
	
	public boolean isStudio(){
		return this.isStudio;
	}
	
	@Override
	public String toString(){
		String genre;
		
		//Transform genre type to a readable text
		if (this.genre.equals(Genre.ROCK))
			genre = "ROCK";
		else if (this.genre.equals(Genre.CLASSICAL))
			genre = "CLASSICAL";
		else if (this.genre.equals(Genre.DANCE))
			genre = "DANCE";
		else if (this.genre.equals(Genre.JAZZ))
			genre = "JAZZ";
		else if (this.genre.equals(Genre.POP))
			genre = "POP";
		else
			genre = "OTHER";		
		
		return "Title: "+this.title 
				+", Artist: "+this.artist
				+", Genre: "+genre 				 
				+", Year: "+this.year 
				+", Duration: "+this.duration
				+", Composed:"+this.isComposed
				+", Performed by:"+this.isRecorded
				+", Studio Recording"+this.isStudio
				+"\n";	
	}
}
