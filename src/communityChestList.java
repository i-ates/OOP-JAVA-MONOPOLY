import java.util.ArrayList;


public class communityChestList extends cards {
	

	public communityChestList(String cardName) {
		super(cardName);
		// TODO Auto-generated constructor stub
	}
	
	public int getCardAbility(ArrayList<communityChestList> communityChestList){
		int result=0;
		if(communityChestList.get(0).getCardName().equals("Advance to Go (Collect $200)")){
			result=1;
			
		}else{
			if(communityChestList.get(0).getCardName().equals("Bank error in your favor - collect $75")){
				result=75;
				
			}
			if(communityChestList.get(0).getCardName().equals("Doctor's fees - Pay $50")){
				result=-50;
				
			}
			if(communityChestList.get(0).getCardName().equals("It is your birthday Collect $10 from each player")){
				result=10;
				
			}
			if(communityChestList.get(0).getCardName().equals("Grand Opera Night - collect $50 from every player for opening night seats")){
				result=50;
				
			}
			if(communityChestList.get(0).getCardName().equals("Income Tax refund - collect $20")){
				result=20;
				
			}
			if(communityChestList.get(0).getCardName().equals("Life Insurance Matures - collect $100")){
				result=100;
				
			}
			if(communityChestList.get(0).getCardName().equals("Pay Hospital Fees of $100")){
				result=-100;
				
			}
			if(communityChestList.get(0).getCardName().equals("Pay School Fees of $50")){
				result=-50;
				
			}
			if(communityChestList.get(0).getCardName().equals("You inherit $100")){
				result=100;
				
			}
			if(communityChestList.get(0).getCardName().equals("From sale of stock you get $50")){
				result=50;
				
			}
			
			
		}
		return result;
	}
	
	
	
	public void realizeCard( player player, ArrayList<communityChestList> communityChestList,player banker){
		int result= getCardAbility(communityChestList);
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
		else{
			x=player.getPlayerMoney();
			x=x+result;
			player.setPlayerMoney(x);
			y=banker.getPlayerMoney();
			y=y-result;
			banker.setPlayerMoney(y);
		}
		//Send to card under the desk
		communityChestList.add(new communityChestList(communityChestList.get(0).getCardName()));
		communityChestList.remove(0);
		
		
		
		
	}
	
	

	
}
