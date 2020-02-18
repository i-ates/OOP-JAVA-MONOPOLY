import java.util.ArrayList;

public class companies extends properties {

	public companies(int id, String name, int cost, String kindOfPropertie) {
		super(id, name, cost, kindOfPropertie);
		// TODO Auto-generated constructor stub
	}
	public int rent(player player, ArrayList<properties> properties){
		int result=4* player.getPlayerDice();
		return result;
	}
	
}
