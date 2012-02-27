
public class Performer {
	
	private String name;
	private pType type;
	
	//default constructor
	public Performer(){};
	
	//parameterized constructor
	public Performer(String n,pType t){
		this.name=n;
		this.type=t;
		}
	
	//set methods
	public void setName(String n){
		this.name=n;
	}
	
	public void setType(pType t){
		this.type=t;
	}
	
	//get methods
	public String getName(){
		return this.name;
	}
	
	public pType getType(){
		return this.type;
	}
	
}
