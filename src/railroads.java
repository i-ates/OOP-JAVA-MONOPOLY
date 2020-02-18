import java.util.ArrayList;

public class railroads extends properties {

	public railroads(int id, String name, int cost, String kindOfPropertie) {
		super(id, name, cost,kindOfPropertie);
		// TODO Auto-generated constructor stub
	}
	
	
	public int rent(player player, ArrayList<properties> properties){
		int result=0;
		int numberOfRailRoad=0;
		String otherPlayerName;
		if(player.getPlayerName().equals("Player 1")){
			otherPlayerName="Player 2";
		}
		else{
			otherPlayerName="Player 1";
		}
		
		
		for(properties key: properties){
			if(key.getKindOfPropertie().equals("Rail Road")){
				if(key.getPlayerName().equals(otherPlayerName)){
					numberOfRailRoad=numberOfRailRoad+1;
					
				}
			}
		}
		result=25*numberOfRailRoad;
		
		return result;
	}
	

}
