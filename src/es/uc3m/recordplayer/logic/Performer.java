package es.uc3m.recordplayer.logic;

public class Performer {
	
	private String name;
	private PerformerType type;
	
	//default constructor
	public Performer(){};
	
	//parameterized constructor
	public Performer(String n,PerformerType t){
		this.name=n;
		this.type=t;
		}
	
	//set methods
	public void setName(String n){
		this.name=n;
	}
	
	public void setType(PerformerType t){
		this.type=t;
	}
	
	//get methods
	public String getName(){
		return this.name;
	}
	
	public PerformerType getType(){
		return this.type;
	}
	
}
