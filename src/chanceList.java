import java.util.ArrayList;
public class chanceList extends cards {
	
	
	public chanceList(String cardName) {
		super(cardName);
		// TODO Auto-generated constructor stub
	}
	public int getCardAbility(ArrayList<chanceList> chanceList){
		int result=0;
		if(chanceList.get(0).getCardName().equals("Advance to Go (Collect $200)")){
			result=1;
		}
		if(chanceList.get(0).getCardName().equals("Advance to Leicester Square")){
			result=27;
		}
		if(chanceList.get(0).getCardName().equals("Go back 3 spaces")){
			result=-3;
		}
		if(chanceList.get(0).getCardName().equals("Pay poor tax of $15")){
			result=-15;
		}
		if(chanceList.get(0).getCardName().equals("Your building loan matures - collect $150")){
			result=150;
		}
		if(chanceList.get(0).getCardName().equals("You have won a crossword competition - collect $100 ")){
			result=100;
		}
		return result;
	}
	
	public void realizeCard(player player,player player2,player banker,ArrayList<properties> properties,ArrayList<communityChestList> communityChestList,ArrayList<chanceList> chanceList){
		int result=getCardAbility(chanceList);
		int x,y;
		
		if(result==1){
			player.setPlayerLocation(1);
			x=player.getPlayerMoney();
			x=x+200;
			player.setPlayerMoney(x);
			y=banker.getPlayerMoney();
			y=y-200;
			banker.setPlayerMoney(y);
		}
		
		else if(result==27){
			player.setPlayerLocation(27);
			
			
		}
		else if(result==-3){
			x=player.getPlayerLocation();
			x=x-3;
			player.setPlayerLocation(x);
			
			
		}
		else{
			x=player.getPlayerMoney();
			x=x+result;
			player.setPlayerMoney(x);
			y=banker.getPlayerMoney();
			y=y-result;
			banker.setPlayerMoney(y);
			
		}
		//Send to card under the desk
		chanceList.add(new chanceList(chanceList.get(0).getCardName()));
		chanceList.remove(0);
	
	}
	
	
}
