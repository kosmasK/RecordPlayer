package es.uc3m.recordplayer;

public class Record {
	
	private Side sides[];
	private Performer recordPerformer;
	private String title;
	private int editionYear;
	private SpeedType recordSpeed;
	
	//default constructor
	public Record(){}
	
	//parameterized constructor
	public Record(Side[] s, Performer p, String t, int e, SpeedType r){
		this.sides=new Side[2];
		this.sides=s;
		this.recordPerformer=p;
		this.title=t;
		this.editionYear=e;
		this.recordSpeed=r;		
	}
	
	//set methods
	public void setSides(Side[] s){
		this.sides=s;
	}
		
	public void setRecordPerformer(Performer p){
		this.recordPerformer=p;
	}
		
	public void setTitle(String t){
		this.title=t;
	}
		
	public void setEditionYear(int e){
		this.editionYear=e;
	}
		
	public void setRecordSpeed(SpeedType r){
		this.recordSpeed=r;
	}	
	
	//get methods
	public Side[] getSides(){
		return this.sides;
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
	
	public SpeedType getRecordSpeed(){
		return this.recordSpeed;
	}

}