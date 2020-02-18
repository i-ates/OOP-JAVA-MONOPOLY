import java.util.ArrayList;

public class player {
	private String playerName;
	private int playerLocation=1;
	private int playerDice=0;
	private int playerMoney=15000;
	private int playerWaitTime=0;
	private boolean getMoneyBanker=false;
	
	
	public void updatePlayerLocation(player player,int dice){
		setPlayerDice(dice);
		int currentLocation=player.getPlayerLocation();
		int updatedLocation=currentLocation+dice;
		if(player.getPlayerWaitTime()!=0){
			
		}
			
		else{
			if(updatedLocation>40){
				
				if((playerLocation+dice)%40==11 || (playerLocation+dice)%40==31  ){
					
					if((currentLocation+dice)%40==0){
						player.setPlayerLocation((40));
						
					}
					else{
						player.setPlayerLocation((currentLocation+dice)%40);
					}
					
				}
				else{
					
					setGetMoneyBanker(true);
					if((currentLocation+dice)%40==0){
						player.setPlayerLocation((40));
						
					}
					else{
						player.setPlayerLocation((currentLocation+dice)%40);
					}
					
				}
				
			}
			else{
				if((currentLocation+dice)%40==0){
					player.setPlayerLocation((40));
					
				}
				else{
					player.setPlayerLocation((currentLocation+dice)%40);
				}
				
				
			}
				
			
		}
		
	}
	public String moveAndBuy(player player1,player player2, int dice,ArrayList<properties> properties,player banker,ArrayList<communityChestList> communityChestList,ArrayList<chanceList> chanceList,ArrayList<String> player1Items,ArrayList<String> player2Items){
		String result="";
		int resultChance=chanceList.get(0).getCardAbility(chanceList);
		updatePlayerLocation(player1,dice);
		if(player1.getPlayerLocation()==8 || player1.getPlayerLocation()==23 || player1.getPlayerLocation()==37){
			if(chanceList.get(0).getCardName().equals("Advance to Go (Collect $200)")){
				result="\t"+player1.getPlayerName()+" draw Advance to Go (Collect $200)";
			}
			if(chanceList.get(0).getCardName().equals("Advance to Leicester Square")){
				result="\t"+player1.getPlayerName()+" draw Advance to Leicester Square ";
			}
			if(chanceList.get(0).getCardName().equals("Go back 3 spaces")){
				result="\t"+player1.getPlayerName()+" draw Go back 3 spaces";
			}
			if(chanceList.get(0).getCardName().equals("Pay poor tax of $15")){
				
				if(player1.getPlayerMoney()<0){
					result="\t"+player1.getPlayerName()+" goes bankrupt";
				}else{
					result="\t"+player1.getPlayerName()+" draw Pay poor tax of $15";
				}
			}
			if(chanceList.get(0).getCardName().equals("Your building loan matures - collect $150")){
				result="\t"+player1.getPlayerName()+" draw Your building loan mature - collect $150";
			}
			if(chanceList.get(0).getCardName().equals("You have won a crossword competition - collect $100 ")){
				result="\t"+player1.getPlayerName()+" draw You have won a crossword competition - collect $100";
			}
			
		}
		if(player1.getPlayerLocation()==3 || player1.getPlayerLocation()==18 || player1.getPlayerLocation()==34){
			if(communityChestList.get(0).getCardName().equals("Advance to Go (Collect $200)")){
				result="\t"+player1.getPlayerName()+" draw Advance to Go (Collect $200)";
				
			}else{
				if(communityChestList.get(0).getCardName().equals("Bank error in your favor - collect $75")){
					result="\t"+player1.getPlayerName()+" draw Bank error in your favor - collect $75";
					
				}
				if(communityChestList.get(0).getCardName().equals("Doctor's fees - Pay $50")){
					
					if(player1.getPlayerMoney()<0){
						result="\t"+player1.getPlayerName()+" goes bankrupt";
					}else{
						result="\t"+player1.getPlayerName()+" draw Doctor's fees - Pay $50";
					}

					
				}
				if(communityChestList.get(0).getCardName().equals("It is your birthday Collect $10 from each player")){
					result="\t"+player1.getPlayerName()+" draw It is your birthday Collect $10 from each player";
					
				}
				if(communityChestList.get(0).getCardName().equals("Grand Opera Night - collect $50 from every player for opening night seats")){
					result="\t"+player1.getPlayerName()+" draw Grand Opera Night - collect $50 from every player for opening night seats";
					
				}
				if(communityChestList.get(0).getCardName().equals("Income Tax refund - collect $20")){
					result="\t"+player1.getPlayerName()+" draw Income Tax refund - collect $20";
					
				}
				if(communityChestList.get(0).getCardName().equals("Life Insurance Matures - collect $100")){
					result="\t"+player1.getPlayerName()+" draw Life Insurance Matures - collect $100";
					
				}
				if(communityChestList.get(0).getCardName().equals("Pay Hospital Fees of $100")){
					
					if(player1.getPlayerMoney()<0){
						result="\t"+player1.getPlayerName()+" goes bankrupt";
					}else{
						result="\t"+player1.getPlayerName()+" draw Pay Hospital Fees of $100";
					}
					
				}
				if(communityChestList.get(0).getCardName().equals("Pay School Fees of $50")){
					
					if(player1.getPlayerMoney()<0){
						result="\t"+player1.getPlayerName()+" goes bankrupt";
					}else{
						result="\t"+player1.getPlayerName()+" draw Pay School Fees of $50";
					}
					
				}
				if(communityChestList.get(0).getCardName().equals("You inherit $100")){
					result="\t"+player1.getPlayerName()+" draw You inherit $100";
					
				}
				if(communityChestList.get(0).getCardName().equals("From sale of stock you get $50")){
					result="\t"+player1.getPlayerName()+" draw From sale of stock you get $50";
					
				}
			}
		}
		
		if(player1.getPlayerWaitTime()>0){
			int x=player1.getPlayerWaitTime();
			player1.setPlayerWaitTime(x-1);
			int y=4-x;
			result="\t"+player1.getPlayerName()+" in jail (count="+y+")";
		}
		else{
			
			if(getMoneyBanker){
				int x=player1.getPlayerMoney();
				player1.setPlayerMoney(x+200);
				x=banker.getPlayerMoney();
				banker.setPlayerMoney(x-200);
				player1.setGetMoneyBanker(false);
				
				
			}
			
				int i=0;
				for(i=0;i<properties.size();i++){
					if(properties.get(i).getId()==player1.getPlayerLocation()){
						String x=properties.get(i).getKindOfPropertie();
						if(x.equals("Go")){
							player1.setGetMoneyBanker(true);
							result="\t"+player1.getPlayerName()+" is in GO square";
							
						}
						else if(x.equals("Tax")){
							int y=player1.getPlayerMoney();
							player1.setPlayerMoney(y-100);
							y=banker.getPlayerMoney();
							banker.setPlayerMoney(y+100);
							if(player1.getPlayerMoney()<0){
								result="\t"+player1.getPlayerName()+" goes bankrupt";
							}else{
								result="\t"+player1.getPlayerName()+" paid Tax";
							}
							
							
							
							
						}
						else if(x.equals("Jail")){
							player1.setPlayerWaitTime(3);
							result="\t"+player1.getPlayerName()+" went to Jail";
							
							
						}
						else if(x.equals("Free Parking")){
							player1.setPlayerWaitTime(1);
							result="\t"+player1.getPlayerName()+" in in Free Parking";
							
							
						}
						else if(x.equals("Go To Jail")){
							player1.setPlayerLocation(11);
							player1.setPlayerWaitTime(3);
							result="\t"+player1.getPlayerName()+" went to Jail";
						}
						else if(x.equals("Community Chest")){
							communityChestList.get(0).realizeCard(player1, communityChestList,banker);
							
						}
						else if(x.equals("Chance")){
							chanceList.get(0).realizeCard(player1,player2,banker,properties,communityChestList,chanceList);
							
						}
						else{
							
							if(properties.get(i).getPlayerName().equals(player1.getPlayerName())){
								if(resultChance==27){
									result=result+"\t"+player1.getPlayerName()+" has "+properties.get(i).getName();
									
								}
								else if(resultChance==-3){
									result=result+"\t"+player1.getPlayerName()+" has "+properties.get(i).getName();
									
								}else{
									result="\t"+player1.getPlayerName()+" has "+properties.get(i).getName();
								}
								
							}
							else{
								
								if(properties.get(i).getPlayerName().equals("NULL")){
									if(player1.getPlayerMoney()>=properties.get(i).getCost()){
										properties.get(i).setPlayerName(player1.getPlayerName());
										if(player1.getPlayerName().equals("Player 1")){
											player1Items.add(properties.get(i).getName());
										}
										else{
											player2Items.add(properties.get(i).getName());
										}
										int y=player1.getPlayerMoney();
										y=y-properties.get(i).getCost();
										player1.setPlayerMoney(y);
										int z=banker.getPlayerMoney();
										z=z+properties.get(i).getCost();
										banker.setPlayerMoney(z);
										if(resultChance==27){
											result=result+"\t"+player1.getPlayerName()+" bought "+properties.get(i).getName();
											
										}
										else if(resultChance==-3){
											result=result+"\t"+player1.getPlayerName()+" bought "+properties.get(i).getName();
											
										}else{
											result="\t"+player1.getPlayerName()+" bought "+properties.get(i).getName();
										}
									}
									else{
										result="\t"+player1.getPlayerName()+" goes bankrupt";
									}
									
									
								}
								else{
									
										int y=player1.getPlayerMoney();
										int z=player2.getPlayerMoney();
										int rent=properties.get(i).rent(player1, properties);
										y=y-rent;
										z=z+rent;
										player1.setPlayerMoney(y);
										player2.setPlayerMoney(z); 
										
										if(resultChance==27){
											result=result+player1.getPlayerName()+" paid rent for "+properties.get(i).getName();
											
										}
										else if(resultChance==-3){
											result=result+"\t"+player1.getPlayerName()+" paid rent for "+properties.get(i).getName();
											
										}else{
											result="\t"+player1.getPlayerName()+" paid rent for "+properties.get(i).getName();
										}
										
									
									
									
									
								}
								
							}
							
						}
						
					}
				}
				
				
			
			
		}
		return result;
		
		
		
	}

	
	
	
	
	
	
	//constructor
	public player(String playerName) {
		
		this.playerName = playerName;
		
	}
	//constructor for banker
	public player(String playerName, int playerMoney){
		this.playerName=playerName;
		this.playerMoney=playerMoney;
	}
	
	
	
	
	//getter-setter
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerLocation() {
		return playerLocation;
	}
	public void setPlayerLocation(int playerLocation) {
		this.playerLocation = playerLocation;
	}
	public int getPlayerDice() {
		return playerDice;
	}
	public void setPlayerDice(int playerDice) {
		this.playerDice = playerDice;
	}
	public int getPlayerMoney() {
		return playerMoney;
	}
	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}
	public int getPlayerWaitTime() {
		return playerWaitTime;
	}

	public void setPlayerWaitTime(int playerWaitTime) {
		this.playerWaitTime = playerWaitTime;
	}

	public boolean isGetMoneyBanker() {
		return getMoneyBanker;
	}
	public void setGetMoneyBanker(boolean getMoneyBanker) {
		this.getMoneyBanker = getMoneyBanker;
	}
	
}
