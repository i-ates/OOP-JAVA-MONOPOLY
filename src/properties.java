import java.util.ArrayList;

public class properties {
	int id;
	String name;
	int cost;
	String playerName="NULL";
	String kindOfPropertie;
	
	public int rent(player player, ArrayList<properties> properties){
		int result=0;
		if(0<cost && cost<=2000){
			result=(cost*4)/10;
			
		}
		if(2000<cost && cost<=3000){
			result=(cost*3)/10;
		}
		if(3000<cost && cost<=4000){
			result=(cost*35)/100;
		}
			
		
		return result;
	}
	
	
	
	
	//constructor 
	public properties(int id, String name, int cost,String kindOfPropertie) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.kindOfPropertie= kindOfPropertie;
	}
	
	
	
	
	//getter-setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getKindOfPropertie() {
		return kindOfPropertie;
	}
	public void setKindOfPropertie(String kindOfPropertie) {
		this.kindOfPropertie = kindOfPropertie;
	}
	
	
	


}
