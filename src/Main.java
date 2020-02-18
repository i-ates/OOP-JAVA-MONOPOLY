import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {
	public static void main(String[] args){
	
		ArrayList<communityChestList> communityChestList = new ArrayList<communityChestList>();
		ArrayList<chanceList> chanceList= new ArrayList<chanceList>();
		ArrayList<properties> properties= new ArrayList<properties>();
		ArrayList<String> player1Items=new ArrayList<String>();
		ArrayList<String> player2Items= new ArrayList<String>();
		player player1=new player("Player 1");
		player player2=new player("Player 2");
		player banker=new player("Banker",100000);
		properties.add(new properties(1,"Go",0,"Go"));
		properties.add(new properties(5,"Income Tax",0,"Tax"));
		properties.add(new properties(11,"Jail",0,"Jail"));
		properties.add(new properties(21,"Free Parking",0,"Free Parking"));
		properties.add(new properties(31,"Go To Jail",0,"Go To Jail"));
		properties.add(new properties(39,"Super Tax",0,"Tax"));
		properties.add(new properties(3,"Community Chest",0,"Community Chest"));
		properties.add(new properties(18,"Community Chest",0,"Community Chest"));
		properties.add(new properties(34,"Community Chest",0,"Community Chest"));
		properties.add(new properties(8,"Chance",0,"Chance"));
		properties.add(new properties(23,"Chance",0,"Chance"));
		properties.add(new properties(37,"Chance",0,"Chance"));
		
		
		 try 
	        {
			 JSONParser parser = new JSONParser();
			 
		     Object obj = parser.parse(new FileReader("list.json"));
		  
		     JSONObject jsonObject = (JSONObject) obj;
		  
		     JSONArray jsonArray = (JSONArray) jsonObject.get("chanceList");
		     for(Object o: jsonArray){
		    	 String card;
			     card=o.toString().split(":")[1].replace("}", "").replace("\"", "");
			     chanceList.add(new chanceList(card));
		     }
		     Object obj1 = parser.parse(new FileReader("list.json"));
			  
		     JSONObject jsonObject1 = (JSONObject) obj1;
		  
		     JSONArray jsonArray1 = (JSONArray) jsonObject1.get("communityChestList");
		     for(Object o: jsonArray1){
		    	 String card;
			     card=o.toString().split(":")[1].replace("}", "").replace("\"", "");
			     communityChestList.add(new communityChestList(card));
		     }
		     
		     
		     
		     Object obj2 = parser.parse(new FileReader("property.json"));
		 
			  
		     JSONObject jsonObject2 = (JSONObject) obj2;
		  
		     JSONArray jsonArray2 = (JSONArray) jsonObject2.get("1");
		     
		     for(Object o: jsonArray2){
		    	 String id, name,cost;
		    	 String[] str = o.toString().replace("}", "").replace("\"", "").split(":");
		    	 id=str[3].split(",")[0];
		    	 name=str[2].split(",")[0];
		    	 cost=str[1].split(",")[0];
		    	 properties.add(new properties(Integer.parseInt(id),name,Integer.parseInt(cost),"Land"));
			     
			     
		     }
		     Object obj3 = parser.parse(new FileReader("property.json"));
			  
		     JSONObject jsonObject3 = (JSONObject) obj3;
		  
		     JSONArray jsonArray3 = (JSONArray) jsonObject3.get("2");
		     
		     for(Object o: jsonArray3){
		    	 String id, name,cost;
		    	 String[] str = o.toString().replace("}", "").replace("\"", "").split(":");
		    	 id=str[3].split(",")[0];
		    	 name=str[2].split(",")[0];
		    	 cost=str[1].split(",")[0];
		    	 properties.add(new railroads(Integer.parseInt(id),name,Integer.parseInt(cost),"Rail Road"));
			     
			     
			     
		     }
		     Object obj4 = parser.parse(new FileReader("property.json"));
			  
		     JSONObject jsonObject4 = (JSONObject) obj4;
		  
		     JSONArray jsonArray4 = (JSONArray) jsonObject4.get("3");
		     
		     for(Object o: jsonArray4){
		    	 String id, name,cost;
		    	 String[] str = o.toString().replace("}", "").replace("\"", "").split(":");
		    	 id=str[3].split(",")[0];
		    	 name=str[2].split(",")[0];
		    	 cost=str[1].split(",")[0];
		    	 properties.add(new companies(Integer.parseInt(id),name,Integer.parseInt(cost),"Company"));
			     
		     }
	          
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 
		 BufferedReader in=null;
		  try{
			  in = new BufferedReader(new FileReader(args[0]));
			  String read = null;
			  PrintWriter outFile=new PrintWriter("output.txt");
			  while ((read = in.readLine()) != null) {
			      String playerName;
			      String result;
			      int dice;
				  if(read.equals("show()")){
					  show(player1,player2,banker,player1Items,player2Items,outFile);
			    	   
			       }
			       else{
			    	   playerName=read.split(";")[0];
			    	   dice=Integer.parseInt(read.split(";")[1]);
			    	   if(playerName.equals("Player 1")){
			    		   result=player1.moveAndBuy(player1, player2, dice, properties, banker, communityChestList, chanceList,player1Items,player2Items);
			    		   outFile.println("Player 1\t"+dice+"\t"+player1.getPlayerLocation()+"\t"+player1.getPlayerMoney()+"\t"+player2.getPlayerMoney()+result);
			    		   if(result.equals("	Player 1 goes bankrupt")|| result.equals("	Player 2 goes bankrupt")){
			    			   break;
			    			   
			    		   }
			    	   }
			    	   else{
			    		   result=player2.moveAndBuy(player2, player1, dice, properties, banker, communityChestList, chanceList,player1Items,player2Items);
			    		   outFile.println("Player 2\t"+dice+"\t"+player2.getPlayerLocation()+"\t"+player1.getPlayerMoney()+"\t"+player2.getPlayerMoney()+ result);
			    		   if(result.equals("	Player 1 goes bankrupt")|| result.equals("	Player 2 goes bankrupt")){
			    			   
			    			   break;
			    			   
			    		   }
			    	   }
			    	  
			    	   
			       }
				 
			    }
			  show(player1,player2,banker,player1Items,player2Items,outFile);
			  outFile.close();
			  
		  }
		  catch(IOException e) {
			    System.out.println("There was a problem: " + e);
			    e.printStackTrace();
			} finally {
			    try {
			        in.close();
			    } catch (Exception e) {
			    }
			}
		  
		  
	}
	public static void show(player player1,player player2,player banker, ArrayList<String> player1Items,ArrayList<String> player2Items,PrintWriter outFile){
		String player1str="have: ", player2str="have: ",winner;
		try{
			player1str=player1str+player1Items.get(0);
			player2str=player2str+player2Items.get(0);
			
		}
		catch(Exception e){
			
		}
		int x,y;
		for(x=1;x<player1Items.size();x++){
			player1str=player1str+","+player1Items.get(x);
			
		}
		for(y=1;y<player2Items.size();y++){
			player2str=player2str+","+player2Items.get(y);
		}
		if(player1.getPlayerMoney()>player2.getPlayerMoney()){
			winner="Player 1";
			
		}else if(player1.getPlayerMoney()==player2.getPlayerMoney()){
			winner="scoreless";
		}
		else{
			winner="Player 2";
		}
		outFile.println("-----------------------------------------------------------------------------------------------------------");
		outFile.println("Player 1\t"+player1.getPlayerMoney()+"\t"+player1str);
		outFile.println("Player 2\t"+player2.getPlayerMoney()+"\t"+player2str);
		outFile.println("Banker\t"+banker.getPlayerMoney());
		outFile.println("Winner "+winner);
		outFile.println("-----------------------------------------------------------------------------------------------------------");
	}

}
