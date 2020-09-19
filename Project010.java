import java.io.*;
import java.util.*;

public class Project010{
   /*
   Title: Man vs Boar
   
   Testing Correction: Battle Code currently gives 400 Gold and 100 EXP instead of normal amount dependent on enemy, change before player testing
   
   Problem: shoud change Defense Values for armor to be proportional to percent damage reduction
   Solution: divide total defense value from player by 100, multiply by enemy attackdamage, and subtract from enemy attackdamage in Battle method
   
   Problem: minimum damage taken from an enemy attack should be 1
   Solution: deal max(calculatedAttackDamage, 1) to the player
   
   Problem: need to generalize learning moves from books
   Solution: make an extra string variable in the Equipment class in order to store the move's name to check against
   
   Problem(MAYBE): As maps expand, they will take up a lot of the main file
   Solution: Create mapBuilder class, that can build each of the maps depending on input, reducing the size of the main file
   
   Problem: can't see item details in inventory(descriptions, use, damage, level, equippedStatus)
   Solution: create mini-page for each item on click containing a proper description with branch to equip, unequip, and to go back

   Problem: Ring's stat bonuses after it's been equipped
   Solution: initialize each index in the Ring[] array in player and include Ring[] in player.getTotalDefense() method
   
   Problem: need Save() and Load() functions to continue where you left off 
   Solution: make save file format to make loading easier
   */
   public static Scanner input = new Scanner(System.in);//static scanner for reading in all user input
   
   public static void openMenu(Player player, int currentMap, int previousMap){
      String menuLine = "";
               while(!menuLine.equals("exit")){//type exit to return to normal game view
                  //print basic menu options(number-based)
                  System.out.println("Menu Index");
                  System.out.println("    1 -> Locations");
                  System.out.println("    2 -> Player_Stats");
                  System.out.println("    3 -> Inventory");
                  System.out.println("    4 -> Move_List");
                  System.out.println("Enter 'exit' to exit.");
                  menuLine = input.nextLine();//select menu option
                  
                  while(!menuLine.equals("1") && !menuLine.equals("2") && !menuLine.equals("3") && !menuLine.equals("4") && !menuLine.equals("exit")){
                     System.out.println("Improper input, please enter proper index or enter 'exit' to exit.");
                     menuLine = input.nextLine();
                  }
                  //conditinally display each menu option, use whiles for options with additional commands and use unique exit Strings, but not "exit" within each
                  //conditionals should be written if->elseif->elseif->elseif
                  if(menuLine.equals("1")){//locations
                     String menuLine0 = "";
                     while(!menuLine0.equals("back") && !menuLine0.equals("exit")){
                        System.out.println("Locations");
                        System.out.println("    Current Map:  Map "+currentMap);
                        System.out.println("    Previous Map: Map "+previousMap);
                        System.out.println("    Name: "+player.getName());
                        System.out.println("    Current Health = "+player.getHealth());
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        menuLine0 = input.nextLine();
                        
                        if(menuLine0.equals("exit")){
                           menuLine = "exit";
                        }
                     }
                  }
                  else if(menuLine.equals("2")){//player stats
                     String menuLine1 = "";
                     while(!menuLine1.equals("back") && !menuLine1.equals("exit")){
                        System.out.println("Player Stats");
                        System.out.println("    Tag: "+player.getName());
                        System.out.println("    HP: "+player.getMaxHealth());
                        System.out.println("    1 -> "+player.getStrength()+" Strength");
                        System.out.println("    2 -> "+player.getSkill()+" Magic Skill");
                        System.out.println("    3 -> "+player.getDefense()+" Defense");
                        System.out.println("    4 -> "+player.getMaxStamina()+" Stamina");
                        System.out.println("    5 -> "+player.getMaxMagic()+" Magic");
                        System.out.println("    6 -> "+player.getSpeed()+" Speed");
                        System.out.println("You have "+player.getStatPoints()+" available stat points.");
                        System.out.println("You have "+player.getSkillPoints()+" available skill points.");
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        menuLine1 = input.nextLine();
                        
                        while(!menuLine1.equals("1") && !menuLine1.equals("2") && !menuLine1.equals("3") && !menuLine1.equals("4") && !menuLine1.equals("5") && !menuLine1.equals("6") && !menuLine1.equals("back") && !menuLine1.equals("exit")){
                           System.out.println("Improper input, please enter proper index, enter 'back' to go back, or enter 'exit' to exit.");
                           menuLine1 = input.nextLine();
                        
                        }
                        
                        if(menuLine1.equals("exit")){
                           menuLine = "exit";
                        }
                        
                        if(menuLine1.equals("1")){
                           if(player.getStatPoints()>0){
                              player.setStrength(player.getStrength()+1);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getStrength()+" Strength.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        if(menuLine1.equals("2")){
                           if(player.getStatPoints()>0){
                              player.setSkill(player.getSkill()+1);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getSkill()+" Skill.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        if(menuLine1.equals("3")){
                           if(player.getStatPoints()>0){
                              player.setDefense(player.getDefense()+1);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getDefense()+" Defense.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        if(menuLine1.equals("4")){
                           if(player.getStatPoints()>0){
                              player.setMaxStamina(player.getMaxStamina()+5);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getMaxStamina()+" Stamina.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        if(menuLine1.equals("5")){
                           if(player.getStatPoints()>0){
                              player.setMaxMagic(player.getMaxMagic()+5);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getMaxMagic()+" Magic.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        if(menuLine1.equals("6")){
                           if(player.getStatPoints()>0){
                              player.setSpeed(player.getSpeed()+1);
                              player.setStatPoints(player.getStatPoints()-1);
                              System.out.println(player.getName()+" now has "+player.getSpeed()+" Speed.");
                              String bullshit = input.nextLine();
                           }
                           else{
                              System.out.println("Not enough stat points.");
                              String bullshit = input.nextLine();
                           }
                        }
                        
                     }//end while(!menuLine1.equals("back")
                     
                  }
                  else if(menuLine.equals("3")){//inventory
                     String menuLine2 = "";
                     while(!menuLine2.equals("back") && !menuLine2.equals("exit")){
                        System.out.println("Inventory");
                        for(int i=0;i<player.getInventory().size();i++){
                           System.out.println("    "+(i+1)+" -> "+player.getInventory().get(i).getName()+"(Level: "+player.getInventory().get(i).getLevel()+", SellPrice: "+player.getInventory().get(i).getSellPrice()+")");
                        }
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        menuLine2 = input.nextLine();
                        int check = 0;
                        for(int i=0;i<player.getInventory().size();i++){
                           if(menuLine2.equals(""+(i+1))){
                              check = 1;
                           }
                        }
                        
                        while(check==0 && !menuLine2.equals("back") && !menuLine2.equals("exit")){
                           System.out.println("Improper input, please use a proper index, enter 'back' to go back, or enter 'exit' to exit.");
                           menuLine2 = input.nextLine();
                           for(int i=0;i<player.getInventory().size();i++){
                              if(menuLine2.equals(""+(i+1))){
                                 check = 1;
                              }
                           }
                           
                        }
                        
                        if(menuLine2.equals("exit")){
                           menuLine = "exit";
                        }
                        int selectInventory = -1;
                        if(!menuLine2.equals("back") && !menuLine2.equals("exit")){
                           selectInventory = Integer.parseInt(menuLine2)-1;
                        }
                        
                        if(check == 1 && selectInventory!=-1 && !menuLine2.equals("back") && !menuLine2.equals("exit")){
                           if(player.getInventory().get(selectInventory).getType().equals("Potion")){
                              player.setHealth(Math.min(player.getMaxHealth(), player.getHealth()+player.getInventory().get(selectInventory).getHealValue()));
                              player.removeInventory(selectInventory);
                              System.out.println("He drank the health potion.");
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Weapon")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Helmet")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Torso")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Gloves")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Pants")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Shoes")){
                              player.equip(player.getInventory().get(selectInventory));
                              System.out.println("He equipped the "+player.getInventory().get(selectInventory).getName()+", Level "+player.getInventory().get(selectInventory).getLevel());
                           }
                           else if(player.getInventory().get(selectInventory).getType().equals("Magic")){
                                 /*
                                 0 -> Base damage
                                 1 -> Strength multiple
                                 2 -> Skill multiple
                                 3 -> Weapon.getAttackValue() multiple
                                 4 -> Weapon.getSkillValue() multiple
                                 */
                              if(player.getInventory().get(selectInventory).getName().equals("Fire Book: Volume 1")){
                                 boolean checkMove = false;
                                 for(int i=0;i<player.getMoveList().size();i++){
                                    if(player.getMoveList().get(i).getName().equals("Fire Shot")){
                                       checkMove=true;
                                    }
                                 }
                                 if(checkMove){
                                    System.out.println("You already know Fire Shot.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    double[] damage = {0, 0, 2, 0, 2};
                                    Move move = new Move(player, "Fire Shot", damage, 10, true);
                                    player.addMove(move);
                                    player.removeInventory(selectInventory);
                                    System.out.println("You have learned a new move called '"+move.getName()+"'.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(player.getInventory().get(selectInventory).getName().equals("Earth Book: Volume 1")){
                                 boolean checkMove = false;
                                 for(int i=0;i<player.getMoveList().size();i++){
                                    if(player.getMoveList().get(i).getName().equals("Stone Shot")){
                                       checkMove=true;
                                    }
                                 }
                                 if(checkMove){
                                    System.out.println("You already know Stone Shot.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    double[] damage = {0, 0, 2, 0, 2};
                                    Move move = new Move(player, "Stone Shot", damage, 10, true);
                                    player.addMove(move);
                                    player.removeInventory(selectInventory);
                                    System.out.println("You have learned a new move called '"+move.getName()+"'.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(player.getInventory().get(selectInventory).getName().equals("Air Book: Volume 1")){
                                 boolean checkMove = false;
                                 for(int i=0;i<player.getMoveList().size();i++){
                                    if(player.getMoveList().get(i).getName().equals("Air Shot")){
                                       checkMove=true;
                                    }
                                 }
                                 if(checkMove){
                                    System.out.println("You already know Air Shot.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    double[] damage = {0, 0, 2, 0, 2};
                                    Move move = new Move(player, "Air Shot", damage, 10, true);
                                    player.addMove(move);
                                    player.removeInventory(selectInventory);
                                    System.out.println("You have learned a new move called '"+move.getName()+"'.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(player.getInventory().get(selectInventory).getName().equals("Water Book: Volume 1")){
                                 boolean checkMove = false;
                                 for(int i=0;i<player.getMoveList().size();i++){
                                    if(player.getMoveList().get(i).getName().equals("Water Shot")){
                                       checkMove=true;
                                    }
                                 }
                                 if(checkMove){
                                    System.out.println("You already know Water Shot.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    double[] damage = {0, 0, 2, 0, 2};
                                    Move move = new Move(player, "Water Shot", damage, 10, true);
                                    player.addMove(move);
                                    player.removeInventory(selectInventory);
                                    System.out.println("You have learned a new move called '"+move.getName()+"'.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              
                           }//end else if
                        }//end if check ==1
                     }//end while(!menuLine2.equals("back"))
                  }//end else if(menuLine.equals("2"))
                  else if(menuLine.equals("4")){
                     String menuLine3 = "";
                     while(!menuLine3.equals("back") && !menuLine3.equals("exit")){
                        System.out.println("Move_List");
                        for(int i=0;i<player.getMoveList().size();i++){
                           Move temp = player.getMoveList().get(i);
                           double[] formula = temp.getDamage();
                           System.out.println("    "+(i+1)+" -> "+temp.getName()+",  Current Damage: "+player.getMoveDamage(i)+",  Damage Formula: {"+formula[0]+", "+formula[1]+", "+formula[2]+", "+formula[3]+", "+formula[4]+"}");
                        }
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        menuLine3 = input.nextLine();
                        
                        int check = 0;
                        
                        for(int i=0;i<player.getMoveList().size();i++){
                           if(menuLine3.equals(""+i)){
                              check = 1;
                           }
                        }
                        
                        while(check==0 && !menuLine3.equals("back") && !menuLine3.equals("exit")){
                           System.out.println("Improper input, please enter a proper index or enter 'back' to exit.");
                           menuLine3 = input.nextLine();
                           
                           for(int i=0;i<player.getMoveList().size();i++){
                              if(menuLine3.equals(""+i)){
                                 check = 1;
                              }
                           }
                        }
                        if(menuLine3.equals("exit")){
                           menuLine = "exit";
                        }
                        //Clicking on things does nothing for now
                        
                        
                     }//end while(!menuLine3.equals("back"))
                  }//end if(menuLine.equals("3"))
               }//end while
   }
   
   public static void openShop(Player player, int currentMap){//saved about 900 lines
               String shop = "";
               while(!shop.equals("exit")){
                  System.out.println("Shop Menu");
                  System.out.println("    1 -> Buy");
                  System.out.println("    2 -> Sell");
                  System.out.println("You have "+player.getCurrency()+" GOLD.");
                  System.out.println("Enter 'exit' to exit.");
                  shop = input.nextLine();
               
                  while(!shop.equals("1") && !shop.equals("2") && !shop.equals("exit")){
                     System.out.println("Improper input. Enter '1' to Buy, '2' to Sell, and 'exit' to exit.");
                     shop = input.nextLine();
                  }
                  if(shop.equals("1")){
                     String buy = "";
                     while(!buy.equals("back") && !buy.equals("exit")){
                        System.out.println("Storefront");
                        System.out.println("    1 -> Armor");
                        System.out.println("    2 -> Weapons");
                        System.out.println("    3 -> Magic Books");
                        System.out.println("    4 -> Accessories");
                        System.out.println("    5 -> Potions");
                        System.out.println("You have "+player.getCurrency()+" GOLD.");
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        buy = input.nextLine();
                     
                        while(!buy.equals("1") && !buy.equals("2") && !buy.equals("3") && !buy.equals("4") && !buy.equals("5") && !buy.equals("back") && !buy.equals("exit")){
                           System.out.println("Improper input. Enter a listed index, 'back' to go back, or 'exit' to exit.");
                           buy = input.nextLine();
                        }
                        if(buy.equals("exit")){
                           shop = "exit";
                        }
                        
                         /*
   0 HP
   1 Stamina
   2 Magic
   3 attackValue
   4 skillValue
   5 strength
   6 skill
   7 defense
   8 speed
   9 healValue
   10 sellPrice
   */
                        if(buy.equals("1")){//start buy comment
                           String shop0 = "";
                              while(!shop0.equals("back") && !shop0.equals("exit")){
                                 System.out.println("Armor");
                                 double[] h0 = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2};
                                 Equipment helmet0 = new Equipment("Wooden_Helmet", "Helmet", 10, 1, h0);
                                 double[] t0 = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2};
                                 Equipment torso0 = new Equipment("Wooden_Torso", "Torso", 10, 1, t0);
                                 double[] g0 = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2};
                                 Equipment gloves0 = new Equipment("Wooden_Gloves", "Gloves", 10, 1, g0);
                                 double[] p0 = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2};
                                 Equipment pants0 = new Equipment("Wooden_Pants", "Pants", 10, 1, p0);
                                 double[] s0 = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2};
                                 Equipment shoes0 = new Equipment("Wooden_Shoes", "Shoes", 10, 1, s0);
                                 System.out.println("    1 -> "+helmet0.getName()+"(Level: "+helmet0.getLevel()+") for 20 Gold.");
                                 System.out.println("    2 -> "+torso0.getName()+"(Level: "+torso0.getLevel()+") for 20 Gold.");
                                 System.out.println("    3 -> "+gloves0.getName()+"(Level: "+gloves0.getLevel()+") for 20 Gold.");
                                 System.out.println("    4 -> "+pants0.getName()+"(Level: "+pants0.getLevel()+") for 20 Gold.");
                                 System.out.println("    5 -> "+shoes0.getName()+"(Level: "+shoes0.getLevel()+") for 20 Gold.");
                                 System.out.println("You have "+player.getCurrency()+" GOLD.");
                                 System.out.println("Enter 'back' to go back and 'exit' to exit.");
                                 shop0 = input.nextLine();
                                 
                                 while(!shop0.equals("1") && !shop0.equals("2") && !shop0.equals("3") && !shop0.equals("4") && !shop0.equals("5") && !shop0.equals("back") && !shop0.equals("exit")){
                                    System.out.println("Improper input, please enter a valid index, 'back' to go back, or 'exit' to exit.");
                                    shop0 = input.nextLine();
                                 }
                                 if(shop0.equals("exit")){
                                    shop = "exit";
                                    buy = "exit";
                                 }
                                 if(shop0.equals("1")){
                                    if(player.getCurrency()-(2*helmet0.getSellPrice())>=0){
                                       player.addInventory(helmet0);
                                       player.setCurrency(player.getCurrency()-(2*helmet0.getSellPrice()));
                                       System.out.println("You just bought "+helmet0.getName()+" for "+(2*helmet0.getSellPrice())+".");
                                       String bullshit = input.nextLine();
                                    }
                                    else{
                                       System.out.println("Not enough Gold.");
                                       String bullshit = input.nextLine();
                                    }
                                 }
                                 else if(shop0.equals("2")){
                                    if(player.getCurrency()-(2*torso0.getSellPrice())>=0){
                                       player.addInventory(torso0);
                                       player.setCurrency(player.getCurrency()-(2*torso0.getSellPrice()));
                                       System.out.println("You just bought "+torso0.getName()+" for "+(2*torso0.getSellPrice())+".");
                                       String bullshit = input.nextLine();
                                    }
                                    else{
                                       System.out.println("Not enough Gold.");
                                       String bullshit = input.nextLine();
                                    }
                                 }
                                 else if(shop0.equals("3")){
                                    if(player.getCurrency()-(2*gloves0.getSellPrice())>=0){
                                       player.addInventory(gloves0);
                                       player.setCurrency(player.getCurrency()-(2*gloves0.getSellPrice()));
                                       System.out.println("You just bought "+gloves0.getName()+" for "+(2*gloves0.getSellPrice())+".");
                                       String bullshit = input.nextLine();
                                    }
                                    else{
                                       System.out.println("Not enough Gold.");
                                       String bullshit = input.nextLine();
                                    }
                                 }
                                 else if(shop0.equals("4")){
                                    if(player.getCurrency()-(2*pants0.getSellPrice())>=0){
                                       player.addInventory(pants0);
                                       player.setCurrency(player.getCurrency()-(2*pants0.getSellPrice()));
                                       System.out.println("You just bought "+pants0.getName()+" for "+(2*pants0.getSellPrice())+".");
                                       String bullshit = input.nextLine();
                                    }
                                    else{
                                       System.out.println("Not enough Gold.");
                                       String bullshit = input.nextLine();
                                    }
                                 }
                                 else if(shop0.equals("5")){
                                    if(player.getCurrency()-(2*shoes0.getSellPrice())>=0){
                                       player.addInventory(shoes0);
                                       player.setCurrency(player.getCurrency()-(2*shoes0.getSellPrice()));
                                       System.out.println("You just bought "+shoes0.getName()+" for "+(2*shoes0.getSellPrice())+".");
                                       String bullshit = input.nextLine();
                                    }
                                    else{
                                       System.out.println("Not enough Gold.");
                                       String bullshit = input.nextLine();
                                    }
                                 }
                                 
                              }//end while(!shop0.equals("back"))
                        }//end if(shop.equals("0"))
                        else if(buy.equals("2")){
                           String shop1 = "";
                           while(!shop1.equals("back") && !shop1.equals("exit")){
                              System.out.println("Weapons");
                              double[] s0 = {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2};
                              Equipment sword0 = new Equipment("Wooden_Sword", "Weapon", 10, 1, s0);
                              sword0.setAttackValue(1);
                              double[] s1 = {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2};
                              Equipment sword1 = new Equipment("Bronze_Sword", "Weapon", 40, 2, s1);
                              sword1.setAttackValue(2);
                              double[] st0 = {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2};
                              Equipment staff0 = new Equipment("Wooden_Staff", "Weapon", 20, 1, st0);
                              staff0.setFocusValue(1);
                              double[] st1 = {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2};
                              Equipment staff1 = new Equipment("Blessed Staff", "Weapon", 50, 2, st1);
                              staff1.setFocusValue(2);
                              System.out.println("    1 -> "+sword0.getName()+"(Level: "+sword0.getLevel()+") for 20 Gold.");
                              System.out.println("    2 -> "+sword1.getName()+"(Level: "+sword1.getLevel()+") for 80 Gold.");
                              System.out.println("    3 -> "+staff0.getName()+"(Level: "+staff0.getLevel()+") for 40 Gold.");
                              System.out.println("    4 -> "+staff1.getName()+"(Level: "+staff1.getLevel()+") for 100 Gold.");
                              System.out.println("You have "+player.getCurrency()+" GOLD.");
                              System.out.println("Enter 'back' to go back and 'exit' to exit.");
                              shop1 = input.nextLine();
                              
                              while(!shop1.equals("1") && !shop1.equals("2") && !shop1.equals("3") && !shop1.equals("4") && !shop1.equals("back") && !shop1.equals("exit")){
                                 System.out.println("Improper input, please enter a valid index, 'back' to go back, or 'exit' to exit.");
                                 shop1 = input.nextLine();
                              }
                              if(shop1.equals("exit")){
                                 shop = "exit";
                                 buy = "exit";
                              }
                              if(shop1.equals("1")){
                                 if(player.getCurrency()-(2*sword0.getSellPrice())>=0){
                                    player.addInventory(sword0);
                                    player.setCurrency(player.getCurrency()-(2*sword0.getSellPrice()));
                                    System.out.println("You just bought "+sword0.getName()+" for "+(2*sword0.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop1.equals("2")){
                                 if(player.getCurrency()-(2*sword1.getSellPrice())>=0){
                                    player.addInventory(sword1);
                                    player.setCurrency(player.getCurrency()-(2*sword1.getSellPrice()));
                                    System.out.println("You just bought "+sword1.getName()+" for "+(2*sword1.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop1.equals("3")){
                                 if(player.getCurrency()-(2*staff0.getSellPrice())>=0){
                                    player.addInventory(staff0);
                                    player.setCurrency(player.getCurrency()-(2*staff0.getSellPrice()));
                                    System.out.println("You just bought "+staff0.getName()+" for "+(2*staff0.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop1.equals("4")){
                                 if(player.getCurrency()-(2*staff1.getSellPrice())>=0){
                                    player.addInventory(staff1);
                                    player.setCurrency(player.getCurrency()-(2*staff1.getSellPrice()));
                                    System.out.println("You just bought "+staff1.getName()+" for "+(2*staff1.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                           }
                        }
                        else if(buy.equals("3")){
                           String shop2 = "";
                           while(!shop2.equals("back") && !shop2.equals("exit")){
                              System.out.println("Magic Books");
                              double[] mb0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
                              Equipment magicBook0 = new Equipment("Fire Book: Volume 1", "Magic", 100, 1, mb0);//
                              Equipment magicBook1 = new Equipment("Earth Book: Volume 1", "Magic", 100, 1, mb0);//
                              Equipment magicBook2 = new Equipment("Air Book: Volume 1", "Magic", 100, 1, mb0);//
                              Equipment magicBook3 = new Equipment("Water Book: Volume 1", "Magic", 100, 1, mb0);//
                              System.out.println("    1 -> "+magicBook0.getName()+"(Level: "+magicBook0.getLevel()+") for 200 Gold.");
                              System.out.println("    2 -> "+magicBook1.getName()+"(Level: "+magicBook1.getLevel()+") for 200 Gold.");
                              System.out.println("    3 -> "+magicBook2.getName()+"(Level: "+magicBook2.getLevel()+") for 200 Gold.");
                              System.out.println("    4 -> "+magicBook3.getName()+"(Level: "+magicBook3.getLevel()+") for 200 Gold.");
                              System.out.println("You have "+player.getCurrency()+" GOLD.");
                              System.out.println("Enter 'back' to go back and 'exit' to exit.");
                              shop2 = input.nextLine();
                              
                              while(!shop2.equals("1") && !shop2.equals("2") && !shop2.equals("3") && !shop2.equals("4") && !shop2.equals("back") && !shop2.equals("exit")){
                                 System.out.println("Improper input, please enter a valid index, 'back' to go back, or 'exit' to exit.");
                                 shop2 = input.nextLine();
                              }
                              if(shop2.equals("exit")){
                                 shop = "exit";
                                 buy = "exit";
                              }
                              if(shop2.equals("1")){
                                 if(player.getCurrency()-(2*magicBook0.getSellPrice())>=0){
                                    player.addInventory(magicBook0);
                                    player.setCurrency(player.getCurrency()-(2*magicBook0.getSellPrice()));
                                    System.out.println("You just bought "+magicBook0.getName()+" for "+(2*magicBook0.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop2.equals("2")){
                                 if(player.getCurrency()-(2*magicBook1.getSellPrice())>=0){
                                    player.addInventory(magicBook1);
                                    player.setCurrency(player.getCurrency()-(2*magicBook1.getSellPrice()));
                                    System.out.println("You just bought "+magicBook1.getName()+" for "+(2*magicBook1.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop2.equals("3")){
                                 if(player.getCurrency()-(2*magicBook2.getSellPrice())>=0){
                                    player.addInventory(magicBook2);
                                    player.setCurrency(player.getCurrency()-(2*magicBook2.getSellPrice()));
                                    System.out.println("You just bought "+magicBook2.getName()+" for "+(2*magicBook2.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop2.equals("4")){
                                 if(player.getCurrency()-(2*magicBook3.getSellPrice())>=0){
                                    player.addInventory(magicBook3);
                                    player.setCurrency(player.getCurrency()-(2*magicBook3.getSellPrice()));
                                    System.out.println("You just bought "+magicBook3.getName()+" for "+(2*magicBook3.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                           }
                        }
                        else if(buy.equals("4")){
                           String shop3 = "";
                           while(!shop3.equals("back") && !shop3.equals("exit")){
                              System.out.println("Accessories");
                              double[] r0 = {2, 2, 2, 0, 0, 2, 2, 2, 2, 0, 2};
                              Equipment ring0 = new Equipment("Strength Ring", "Ring", 100, 1, r0);//
                              Equipment ring1 = new Equipment("Skill Ring", "Ring", 100, 1, r0);//
                              Equipment ring2 = new Equipment("Stamina Ring", "Ring", 100, 1, r0);//
                              Equipment ring3 = new Equipment("Magic Ring", "Ring", 100, 1, r0);//
                              System.out.println("    1 -> "+ring0.getName()+"(Level: "+ring0.getLevel()+") for 200 Gold.");
                              System.out.println("    2 -> "+ring1.getName()+"(Level: "+ring1.getLevel()+") for 200 Gold.");
                              System.out.println("    3 -> "+ring2.getName()+"(Level: "+ring2.getLevel()+") for 200 Gold.");
                              System.out.println("    4 -> "+ring3.getName()+"(Level: "+ring3.getLevel()+") for 200 Gold.");
                              System.out.println("You have "+player.getCurrency()+" GOLD.");
                              System.out.println("Enter 'back' to go back and 'exit' to exit.");
                              shop3 = input.nextLine();
                              
                              while(!shop3.equals("1") && !shop3.equals("2") && !shop3.equals("3") && !shop3.equals("4") && !shop3.equals("back") && !shop3.equals("exit")){
                                 System.out.println("Improper input, please enter a valid index, 'back' to go back, or 'exit' to exit.");
                                 shop3 = input.nextLine();
                              }
                              if(shop3.equals("exit")){
                                 shop = "exit";
                                 buy = "exit";
                              }
                              if(shop3.equals("1")){
                                 if(player.getCurrency()-(2*ring0.getSellPrice())>=0){
                                    player.addInventory(ring0);
                                    player.setCurrency(player.getCurrency()-(2*ring0.getSellPrice()));
                                    System.out.println("You just bought "+ring0.getName()+" for "+(2*ring0.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop3.equals("2")){
                                 if(player.getCurrency()-(2*ring1.getSellPrice())>=0){
                                    player.addInventory(ring1);
                                    player.setCurrency(player.getCurrency()-(2*ring1.getSellPrice()));
                                    System.out.println("You just bought "+ring1.getName()+" for "+(2*ring1.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop3.equals("3")){
                                 if(player.getCurrency()-(2*ring2.getSellPrice())>=0){
                                    player.addInventory(ring2);
                                    player.setCurrency(player.getCurrency()-(2*ring2.getSellPrice()));
                                    System.out.println("You just bought "+ring2.getName()+" for "+(2*ring2.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop3.equals("4")){
                                 if(player.getCurrency()-(2*ring3.getSellPrice())>=0){
                                    player.addInventory(ring3);
                                    player.setCurrency(player.getCurrency()-(2*ring3.getSellPrice()));
                                    System.out.println("You just bought "+ring3.getName()+" for "+(2*ring3.getSellPrice())+".");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                           }//end while(!shop3.equals("back"))
                        }//end if(buy.equals("3"))
                        else if(buy.equals("5")){
                           String shop4 = "";
                           while(!shop4.equals("back") && !shop4.equals("exit")){
                              System.out.println("Potions");
                              double[] p0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2};
                              Equipment potion0 = new Equipment("Health_Potion 1", "Potion", 5, 1, p0);
                              potion0.setHealValue(5);
                              Equipment potion1 = new Equipment("Health_Potion 2", "Potion", 10, 2, p0);
                              potion1.setHealValue(10);
                              Equipment potion2 = new Equipment("Health_Potion 3", "Potion", 20, 3, p0);
                              potion2.setHealValue(20);
                              System.out.println("    1 -> "+potion0.getName()+"(Level: "+(potion0.getLevel())+") for 10 Gold.");
                              System.out.println("    2 -> "+potion1.getName()+"(Level: "+(potion1.getLevel())+") for 20 Gold.");
                              System.out.println("    3 -> "+potion2.getName()+"(Level: "+(potion2.getLevel())+") for 40 Gold.");
                              System.out.println("You have "+player.getCurrency()+" GOLD.");
                              System.out.println("Enter 'back' to go back and 'exit' to exit.");
                              shop4 = input.nextLine();
                              
                              while(!shop4.equals("1") && !shop4.equals("2") && !shop4.equals("3") && !shop4.equals("back") && !shop4.equals("exit")){
                                 System.out.println("Improper input, please enter a valid index, 'back' to go back, or 'exit' to exit.");
                                 shop4 = input.nextLine();
                              }
                              if(shop4.equals("exit")){
                                 shop = "exit";
                                 buy = "exit";
                              }
                              if(shop4.equals("1")){
                                 if(player.getCurrency()-(2*potion0.getSellPrice())>=0){
                                    player.addInventory(potion0);
                                    player.setCurrency(player.getCurrency()-(2*potion0.getSellPrice()));
                                    System.out.println("You bought "+potion0.getName()+" for "+(2*potion0.getSellPrice())+" Gold.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop4.equals("2")){
                                 if(player.getCurrency()-(2*potion1.getSellPrice())>=0){
                                    player.addInventory(potion1);
                                    player.setCurrency(player.getCurrency()-(2*potion1.getSellPrice()));
                                    System.out.println("You bought "+potion1.getName()+" for "+(2*potion1.getSellPrice())+" Gold.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                              else if(shop4.equals("3")){
                                 if(player.getCurrency()-(2*potion2.getSellPrice())>=0){
                                    player.addInventory(potion2);
                                    player.setCurrency(player.getCurrency()-(2*potion2.getSellPrice()));
                                    System.out.println("You bought "+potion2.getName()+" for "+(2*potion2.getSellPrice())+" Gold.");
                                    String bullshit = input.nextLine();
                                 }
                                 else{
                                    System.out.println("Not enough Gold.");
                                    String bullshit = input.nextLine();
                                 }
                              }
                           }//end while(!shop4.equals("back"))
                        }//end if(buy.equals("4")
                        
                        //end buy comment
                        //display all minishops with options to buy, remember to check player gold value
                     }//end while(!buy.equals("back"))
                  }//end if(shop.equals("2")
                 
             
                  else if(shop.equals("2")){//-3
                     String sell = "";
                     while(!sell.equals("back") && !sell.equals("exit")){//-4
                        System.out.println("The Back");
                        for(int i=0;i<player.getInventory().size();i++){//-5
                           Equipment item = player.getInventory().get(i);
                           System.out.println("    "+(i+1)+" -> "+item.getName()+" for "+item.getSellPrice()+" Gold");
                        }//-4
                        System.out.println("Enter 'back' to go back and 'exit' to exit.");
                        sell = input.nextLine();
                        
                        int check = 0;
                        
                     //improper input handler, only covers from 0 to 4
                        
                        for(int i=0;i<player.getInventory().size();i++){//-5
                           if(sell.equals(""+i)){//-6
                              check = 1;
                           }//-5
                        }//-4
                        while(check==0 && !sell.equals("back") && !sell.equals("exit")){  
                           System.out.println("Improper input, enter a listed index, 'back' to go back, or 'exit' to exit.");
                           sell = input.nextLine();
                           for(int i=0;i<player.getInventory().size();i++){
                              if(sell.equals(""+i)){
                                 check = 1;
                              }
                           }
                           //possibly use for loop from 0 to inventory.size() and compare buy to (""+i) each iteration in an if
                           //changing a boolean flag if a match is found
                        }
                        if(sell.equals("exit")){
                           shop = "exit";
                        }
                        if(!sell.equals("back") && !sell.equals("exit")){
                           int money = player.getInventory().get(Integer.parseInt(sell)).getSellPrice();
                           player.setCurrency(player.getCurrency() + money);
                           System.out.println(player.getName()+" sold "+player.getInventory().get(Integer.parseInt(sell)).getName()+" for "+money+" Gold.");
                           if(player.getInventory().get(Integer.parseInt(sell)).isEquipped()){
                              player.unEquip(player.getInventory().get(Integer.parseInt(sell)).getType());
                           }
                           player.removeInventory(Integer.parseInt(sell));
                        }//end if(!sell.equals("back"))
                     }//end while(!sell.equals("back"))
                  
                  }//end if(shop.equals("1"))
                }//end if(!shop.equals("exit"))
   }//end openShop() method
      
   public static void openHealing(Player player){
      player.setHealth(player.getMaxHealth());
      player.setStamina(player.getMaxStamina());
      player.setMagic(player.getMaxMagic());
   }
   
   public static void openForge(Player player){
      String forge = "";
      while(!forge.equals("exit")){
         System.out.println("Forge");
         System.out.println("    1 -> Fusion");
         System.out.println("    2 -> Crafting");
         System.out.println("Enter 'exit' to exit.");
         forge = input.nextLine();
         
         if(!forge.equals("1") && !forge.equals("2") && !forge.equals("exit")){
            System.out.println("Improper input. Enter a listed index or 'exit' to exit.");
            forge = input.nextLine();
         }
         
         
         if(forge.equals("1")){//maybe fusion should be for Equipment only
            String forge0 = "";
            while(!forge0.equals("back") && !forge0.equals("exit")){
               System.out.println("Fusion");
               for(int i=0;i<player.getInventory().size();i++){//-5
                  Equipment item = player.getInventory().get(i);
                  System.out.println("    "+(i+1)+" -> "+item.getType()+": "+item.getName());
               }
               System.out.println("Select an item as a base, enter 'back' to go back, or 'exit' to exit.");
               forge0 = input.nextLine();
               
               int check = 0;
               for(int i=0;i<player.getInventory().size();i++){//-5
                  if(forge0.equals(""+(i+1))){//-6
                     check = 1;
                  }//-5
               }//-4
               while(check==0 && !forge0.equals("back") && !forge0.equals("exit")){  
                  System.out.println("Improper input. Enter a listed index, 'back' to go back, or 'exit' to exit.");
                  forge0 = input.nextLine();
                  for(int i=0;i<player.getInventory().size();i++){
                     if(forge0.equals(""+(i+1))){
                        check = 1;
                     }
                  }
               }
               if(forge0.equals("exit")){
                  forge = "exit";
               }
               if(!forge0.equals("back") && !forge0.equals("exit")){
                  int forgeSelect = Integer.parseInt(forge0)-1;
                  ArrayList<Integer> fuelList = new ArrayList<Integer>();
                  String forge00 = "";
                  int count = 0;
                  for(int i=0;i<player.getInventory().size();i++){//-5
                     Equipment fuseItem = player.getInventory().get(i);
                     Equipment temp = player.getInventory().get(forgeSelect);
                     if(fuseItem.getType().equals(temp.getType()) && i!=forgeSelect){
                        count++;
                        System.out.println("    "+count+" -> "+fuseItem.getName()+"(Level: "+fuseItem.getLevel()+")");
                        fuelList.add(i);
                     }
                  }
                  if(count>0){
                     System.out.println("Enter the index of the item you want to use as fuel for the fusion, enter 'back' to go back, or 'exit' to exit");
                     forge00 = input.nextLine();
                  }
                  else{
                     System.out.println("There is nothing to use as fuel for this type of item in your inventory.");
                     String shit = input.nextLine();
                     forge00 = "back";
                  }
                  //use forge0 as a base and exit checker use forge00 as fuel and exit checker
                  //forge0.getLevel()
               
                  int check0 = 0;
                  for(int i=0;i<fuelList.size();i++){//-5
                     if(forge00.equals(""+(i+1))){//-6
                        check0 = 1;
                     }//-5
                  }//-4
                  while(check0==0 && !forge00.equals("back") && !forge00.equals("exit") && count!=0){  
                     System.out.println("Improper input. Enter a listed index or 'back' to exit.");
                     forge00 = input.nextLine();
                     for(int i=0;i<fuelList.size();i++){
                        if(forge00.equals(""+(i+1))){
                           check0 = 1;
                        }
                     }
                  }
               
                  if(forge00.equals("exit")){
                     //IMPORTANT
                     forge = "exit";
                     forge0 = "exit";
                  }
               
                  //picked 2 items/equipment of the same type, now need to fuse them into the item @ forge0 and remove item @forge00 from list
                  if(!forge00.equals("back") && !forge00.equals("exit")){
                     //fuse
                     Equipment fuseItem1 = player.getInventory().get(Integer.parseInt(forge0)-1);
                     Equipment fuseItem2 = player.getInventory().get(fuelList.get(Integer.parseInt(forge00)-1));
                     String fuseType = fuseItem1.getType();
                     //item potency dependent on item level, calculated on each call to value
                     //item level and experience need to be sorted out in the Equipment class before this can be implemented
                     int ExpToAdd = (int)(fuseItem1.getGoal() * 1/(Math.pow(2, fuseItem1.getLevel()-fuseItem2.getLevel()))) + fuseItem2.getExp();
                     player.removeInventory(fuelList.get(Integer.parseInt(forge00)-1));
                     fuseItem1.setExp(fuseItem1.getExp()+ExpToAdd);
                     System.out.println("You now have a "+fuseItem1.getName()+"(Level: "+fuseItem1.getLevel()+").");
                     input.nextLine();
                  }
               }//end if(!forge0.equals("back") && !forge0.equals("exit"))
            }//end while(!forge0.equals("back") && !forge0.equals("exit"))
         }
         else if(forge.equals("2")){
            System.out.println("Crafting");
         }
      }//end while(!forge.equals("exit"))
   }
   
   public static void printMap(Space[][] map){//displays current map the player is in
      for(int i=0;i<map.length;i++){
         for(int j=0;j<map[0].length;j++){
            System.out.print(map[i][j].getCurrent());
         }
         System.out.print("\n");
      }
   }

   /*public static void place(Space[][] map, int row, int col){
      map[row][col].setCurrent("*");
   }*/
   
   public static Space[][] buildMap(int index){
      if(index==0){//Map 0
         Space[][] construct = new Space[3][3];
         for(int i=0;i<3;i++){
            construct[0][i] = new Space("-", "", true, -1);//top wall
            construct[2][i] = new Space("-", "", true, -1);//bottom wall
         }
         construct[1][0] = new Space("|", "", true, -1);//left wall
         construct[1][1] = new Space(" ", "", false, -1);//empty space in the middle
      
         construct[1][2] = new Space(" ", "d", false, 1);//Exit to Map 1
      
         construct[1][1].setCurrent("+");//set default player spawn
         return construct;
      }
      else if(index==1){//Map 1
         Space[][] construct = new Space[10][10];
         for(int i=0;i<10;i++){
            construct[0][i] = new Space("-", "", true, -1);//top wall
            construct[9][i] = new Space("-", "", true, -1);//bottom wall
            if(i!=0 && i!=9){
               construct[i][0] = new Space("|", "", true, -1);//left wall
               construct[i][9] = new Space("|", "", true, -1);//right wall
            }
         }
         for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
               construct[i][j] = new Space(" ", "", false, -1);//empty space
            }
         }
      
         construct[5][4].setBase("H");//Healing Station
         construct[5][4].setCurrent("H");
         
         construct[5][6].setBase("$");//Weapons and Materials Shop
         construct[5][6].setCurrent("$");
         
         construct[5][5].setBase("F");//Forge
         construct[5][5].setCurrent("F");
      
         construct[1][0].setBase(" ");//Exit to Map 0
         construct[1][0].setCurrent(" ");
         construct[1][0].setDirection("a");
         construct[1][0].setWall(false);
         construct[1][0].setExit(0);
      
         construct[5][9].setBase(" ");//Exit to Map 2
         construct[5][9].setCurrent(" ");
         construct[5][9].setDirection("d");
         construct[5][9].setWall(false);
         construct[5][9].setExit(2);
      
         construct[1][9].setBase(" ");//Exit to Map 3
         construct[1][9].setCurrent(" ");
         construct[1][9].setDirection("d");
         construct[1][9].setWall(false);
         construct[1][9].setExit(3);
      
         construct[9][4].setBase(" ");//Exit to Map 0
         construct[9][4].setCurrent(" ");
         construct[9][4].setDirection("s");
         construct[9][4].setWall(false);
         construct[9][4].setExit(4);
      
         construct[8][8].setCurrent("+");//set default player spawn
         return construct;
      }
      else if(index==2){//Map 2
         Space[][] construct = new Space[5][5];
         for(int i=0;i<5;i++){
            construct[0][i] = new Space("-", "", true, -1);//top wall
            construct[4][i] = new Space("-", "", true, -1);//bottom wall
            if(i!=0 && i!=4){
               construct[i][0] = new Space("|", "", true, -1);//left wall
               construct[i][4] = new Space("|", "", true, -1);//right wall
            }
         }
         for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
               construct[i][j] = new Space(" ", "", false, -1);//empty space
            }
         }
      
         construct[2][2].setBase("&");//enemy respawns every time player enters Map 2
         construct[2][2].setCurrent("&");//override earlier initialization to display enemy
      
         construct[2][0].setBase(" ");//Exit to Map 1
         construct[2][0].setCurrent(" ");
         construct[2][0].setDirection("a");
         construct[2][0].setWall(false);
         construct[2][0].setExit(1);
      
         construct[2][3].setCurrent("+");//set default player spawn
      
         return construct;
      }
      else if(index==3){//Map 3
         Space[][] construct = new Space[3][3];
         for(int i=0;i<3;i++){
            construct[0][i] = new Space("-", "", true, -1);//top wall
            construct[2][i] = new Space("-", "", true, -1);//bottom wall
         }
         construct[1][2] = new Space("|", "", true, -1);//right wall
         construct[1][1] = new Space("&", "", false, -1);//empty space in the middle
      
         construct[1][0] = new Space(" ", "a", false, 1);//Exit to Map 1
      
         construct[1][1].setCurrent("+");//set default player spawn
         return construct;
      }
      else{//Map 4
         Space[][] construct = new Space[3][3];
         for(int i=0;i<3;i++){
            construct[0][i] = new Space("-", "", true, -1);//top wall
            construct[2][i] = new Space("-", "", true, -1);//bottom wall
            if(i!=0 && i!=2){
               construct[i][0] = new Space("|", "", true, -1);//left wall
               construct[i][2] = new Space("|", "", true, -1);//right wall
            }
         }
      
         construct[1][1] = new Space("&", "", false, -1);//enemy spawns every time player enters Map 4
      
         construct[0][1] = new Space(" ", "w", false, 1);//Exit to Map 1
      
         construct[1][1].setCurrent("+");//set default player spawn
         return construct;
      }
   }
   
   public static int[] findPosition(Space[][] map){//find player's coordinates on current map
      int[] pos = new int[2];//row, column
      for(int i=0;i<map.length;i++){
         for(int j=0;j<map[0].length;j++){
            if(map[i][j].getCurrent().equals("+")){
               pos[0] = i;//set row first
               pos[1] = j;//set col second
            }
         }
      }
      return pos;
   }
   public static int[] findExit(Space[][] map, int previous){//find player starting position on new map
   //PROBLEM: DEFAULT VALUE of pos makes it through, map[i][j].getExit() not ever matching previous and properly setting pos
      int[] pos = new int[2];//row, column
      pos[0] = 2;
      pos[1] = 2;
      for(int i=0;i<map.length;i++){
         for(int j=0;j<map[0].length;j++){
            if(map[i][j].getExit() == previous){
               pos[0] = i;//row first
               pos[1] = j;//column second
               return pos;
            }
         }
      }
      return pos;
   }
   
   public static int moveUp(Space[][] map){
      int[] pos = findPosition(map);
      int row = pos[0];
      int col = pos[1];
      if(row!=0){//if not at end
         if(!map[row-1][col].isWall()){//if no wall above
            map[row][col].setCurrent(map[row][col].getBase());
            map[row-1][col].setCurrent("+");
            //printMap(map);
            return 1;
         }
      }
      return 0;
   }

   public static int moveDown(Space[][] map){
      int[] pos = findPosition(map);
      int row = pos[0];
      int col = pos[1];
      if(row!=map.length-1){//if not at end
         if(!map[row+1][col].isWall()){//if no wall below
            map[row][col].setCurrent(map[row][col].getBase());
            map[row+1][col].setCurrent("+");
            //printMap(map);
            return 1;
         }
      }
      return 0;
   }

   public static int moveLeft(Space[][] map){
      int[] pos = findPosition(map);
      int row = pos[0];
      int col = pos[1];
      if(col!=0){//if not at end
         if(!map[row][col-1].isWall()){//if no wall to the left
            map[row][col].setCurrent(map[row][col].getBase());
            map[row][col-1].setCurrent("+");
            //printMap(map);
            return 1;
         }
      }
      return 0;
   }

   public static int moveRight(Space[][] map){
      int[] pos = findPosition(map);
      int row = pos[0];
      int col = pos[1];
      if(col!=map[0].length-1){//if not at end
         if(!map[row][col+1].isWall()){//if no wall to the right
            map[row][col].setCurrent(map[row][col].getBase());
            map[row][col+1].setCurrent("+");
            //printMap(map);
            return 1;
         }
      }
      return 0;
   }
   
   //booty*
   public static Space[][] superMove(String line, int current, Space[][] map){//true means the map changed
      int[] pos = findPosition(map);
      int row = pos[0];
      int col = pos[1];
      if(line.equals(map[row][col].getDirection())){//if switch map
         map = buildMap(map[row][col].getExit());//get proper map
         pos = findPosition(map);//works
         map[pos[0]][pos[1]].setCurrent(map[pos[0]][pos[1]].getBase());//clear player
         pos = findExit(map, current);//find proper position
         System.out.println(pos[0]+", "+pos[1]);//check
         map[pos[0]][pos[1]].setCurrent("+");//set player
         row = pos[0];//update row for this method
         col = pos[1];//update col for this method
      }
      else if(line.equals("w")){
         moveUp(map);
      }
      else if(line.equals("a")){
         moveLeft(map);
      }
      else if(line.equals("s")){
         moveDown(map);
      }
      else if(line.equals("d")){
         moveRight(map);
      }
      return map;
   }
   //*booty
   
   /*public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
   }*/
   
   public static void Battle(Player p, Enemy e, String place)
      {
         
         System.out.println("As "+p.getName()+" was walking through the "+place+",\na "+e.getName()+" appeared and attacked without warning.");
      		
         
      		
      		
         while(p.getHealth() > 0)
         {
            String healthRead = "Health: "+p.getHealth();
            String strengthRead = "Strength: "+p.getStrength();
            String skillRead = "Skill: "+p.getSkill();
            String staminaRead = "Stamina: "+p.getStamina();
            String magicRead = "Magic: "+p.getMagic();
            String speedRead = "Speed: "+p.getSpeed();
            
            int spaceCounter = /*username and others*/Math.max(p.getName().length(), /*all other than username*/Math.max(/*health and strength*/Math.max(healthRead.length(), strengthRead.length()), /*skill,stamina,magic,speed*/Math.max(/*skill and stamina*/Math.max(skillRead.length(), staminaRead.length()), /*magic and speed*/Math.max(magicRead.length(), speedRead.length()))));
            String longWord = "";
            for(int i=0;i<spaceCounter;i++){
               longWord+= " ";
            }
            //System.out.println(longWord.length());//for testing
            String sep = "       ";//7 spaces
            
            String usernameSpace = sep;
            for(int i=0;i<longWord.length()-p.getName().length();i++){
               usernameSpace+= " ";
            }
            String healthSpace = sep;
            for(int i=0;i<longWord.length()-healthRead.length();i++){
               healthSpace+= " ";
            }
            String strengthSpace = sep;
            for(int i=0;i<longWord.length()-strengthRead.length();i++){
               strengthSpace+= " ";
            }
            String skillSpace = sep;
            for(int i=0;i<longWord.length()-skillRead.length();i++){
               skillSpace+= " ";
            }
            String staminaSpace = sep;
            for(int i=0;i<longWord.length()-staminaRead.length();i++){
               staminaSpace+= " ";
            }
            String magicSpace = sep;
            for(int i=0;i<longWord.length()-magicRead.length();i++){
               magicSpace+= " ";
            }
            String speedSpace = sep;
            for(int i=0;i<longWord.length()-speedRead.length();i++){
               speedSpace+= " ";
            }
            
            System.out.println("\n"+p.getName()+usernameSpace+e.getName());
            System.out.println(healthRead+healthSpace+"Health: "+e.getHealth());
            System.out.println(strengthRead+strengthSpace+"Strength: "+e.getStrength());
            System.out.println(skillRead+skillSpace+"Skill: "+e.getSkill());
            System.out.println(staminaRead+staminaSpace+"Stamina: "+e.getStamina());
            System.out.println(magicRead+magicSpace+"Magic: "+e.getMagic());
            System.out.println(speedRead+speedSpace+"Speed: "+e.getSpeed());
            System.out.println("What will you do?\n");
            p.printMoves();
            //Problems with next line
            //Need to print move list
            //System.out.println("1 = "+mv1+"  "+x * 1+" damage "+a+" cost = 0\n2 = "+mv2+" "+x * 2+" damage "+a+" cost = "+drain+"");
            String choice = "";
            boolean proper = false;
            while(!proper){
               System.out.println("Input a number between 1 and "+(p.getMoveList().size())+", inclusive.");
               choice = input.nextLine();
               for(int i=0;i<p.getMoveList().size();i++){
                  if(choice.equals(""+(i+1))){
                     proper = true;
                  }
                  //System.out.println(choice.equals(""+i));
               }
            }
            int index = Integer.parseInt(choice)-1;
            Move move = p.getMoveList().get(index);
            if(!move.getType())
            {
               int stamina = p.getStamina()-move.getCost();
               if(stamina>=0){
                  p.setStamina(stamina);
                  int attackdamage = (int)p.getMoveDamage(index) - e.getDefense();//need better formula
                  if(attackdamage<0){
                     attackdamage = 0;
                  }
                  e.setHealth(e.getHealth() - attackdamage);
                  System.out.println(p.getName()+" attacks "+e.getName()+" with "+move.getName()+", "+e.getName()+" took "+attackdamage+" damage!");
                  if(e.getHealth() <= 0)
                  {
                     System.out.println("You killed "+e.getName()+", gained "+e.getExp()+" Exp, found "+e.getCurrency()+" Gold");
                     //p.setCurrency(p.getCurrency()+e.getCurrency());
                     p.setCurrency(p.getCurrency()+400);
                     //p.setExp(p.getExp()+e.getExp());
                     p.setExp(p.getExp()+100);
                     drops(p, e);
                     break;
                  }
                  int playerDamage = e.getStrength()-p.getTotalDefense();
                  if(playerDamage<0){
                     playerDamage=0;
                  }
                  System.out.println(e.getName()+" attacks "+p.getName()+", "+p.getName()+" took "+playerDamage+" damage!");
                  p.setHealth(p.getHealth() - playerDamage);
               }
               else{
                  System.out.println("NOT ENOUGH STAMINA. CHOOSE DIFFERENT MOVE.");
                  String y = input.nextLine();
               }
            }
            else//MAGICAL ATTACK
            {
               int magic = p.getMagic() - move.getCost();
               //p.setMagic(magic);
               if(magic >= 0)
               {
                  p.setMagic(magic);
                  int attackdamage = (int)p.getMoveDamage(index) - e.getDefense();//need better formula
                  if(attackdamage<0){
                     attackdamage = 0;
                  }
                  e.setHealth(e.getHealth() - attackdamage);
                  System.out.println(""+p.getName()+" attacks "+e.getName()+" with "+move.getName()+", "+e.getName()+" took "+attackdamage+" damage!");
                  if(e.getHealth() <= 0)
                  {
                     System.out.println("You killed "+e.getName()+", gained "+e.getExp()+" Exp, found "+e.getCurrency()+" Gold");
                     //p.setCurrency(p.getCurrency()+e.getCurrency());
                     p.setCurrency(p.getCurrency()+400);
                     //p.setExp(p.getExp()+e.getExp());
                     p.setExp(p.getExp()+100);
                     drops(p, e);
                     break;
                  }
                  int playerDamage = e.getStrength()-p.getTotalDefense();
                  if(playerDamage<0){
                     playerDamage=0;
                  }
                  System.out.println(e.getName()+" attacks "+p.getName()+", "+p.getName()+" took "+playerDamage+" damage!");
                  p.setHealth(p.getHealth() - playerDamage);
               }
               else if(magic < 0)//do nothing
               {
                  System.out.println("NOT ENOUGH MAGIC. CHOOSE DIFFERENT MOVE.");
                  String y=input.nextLine();
               }
               	
            }
               
         }
         if(p.getHealth() <= 0)
         {
            System.out.println("YOU LOSE BITCH! CHOOSE A DIFFERENT CLASS IF YOU WANT TO WIN!");//lose read
         }
      }
//0 1 2 3 4 5 6
   public static void drops(Player player, Enemy enemy){
      int decider = (int)(Math.random()*6);
      if(decider==6){
         double[] s0 = {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2};
         Equipment sword = new Equipment("Basic_Sword", "Weapon", 40, 2, s0);
         sword.setAttackValue(2);
         player.addInventory(sword);
         System.out.println("You found a Basic_Sword Level 2 worth 40 Gold.");
      }
      if(decider==4 || decider==5){
         double[] s0 = {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2};
         Equipment sword = new Equipment("Basic_Sword", "Weapon", 10, 1, s0);
         sword.setAttackValue(1);
         player.addInventory(sword);
         System.out.println("You found a Basic_Sword Level 1 worth 10 Gold.");
      }
      if(decider==2 || decider==3){
         double[] p0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2};
         Equipment potion = new Equipment("Health_Potion", "Potion", 5, 1, p0);
         potion.setLevel(1);
         potion.setHealValue(5);
         player.addInventory(potion);
         System.out.println("You found a Health_Potion Level 1 worth 5 Gold.");
      }
   }
   
   public static void main(String[] args){//start main
      
      //Scanner input = new Scanner(System.in);
      System.out.println("What is your name?");
      String playerName = input.nextLine();
      //int maxHealth = 100;
      Player player = new Player(playerName);
      int[][] connections = new int[5][4];
      int previous = 0;
      int current = 0;
      Space[][] map = buildMap(current);
      int[] pos = findPosition(map);
      int row = findPosition(map)[0];
      int col = findPosition(map)[1];
      String line = "";
      printMap(map);
      player.print();
      //String direction = "";
      boolean win = false;//win condition(probably final boss)
      //I'm really questioning whether a print condition is worth it
      int noWall = 1;//print condition
      
      while(!line.equals("cool") && (player.getHealth()>0) && !win){
         //booty*
         line = input.nextLine();
         if(line.equals("menu")){//menu request
            openMenu(player, current, previous);
            printMap(map);
            player.print();
         }
         else if(line.equals("w") || line.equals("a") || line.equals("s") || line.equals("d")){//movement request
            //superMove() changes the map inside
            if(line.equals(map[row][col].getDirection())){//update map #'s if anything changed or if(superMove(line, current, map))
               previous = current;
               current = map[row][col].getExit();
            }
            map = superMove(line, previous, map);
            pos = findPosition(map);//update row and col variables
            row = pos[0];
            col = pos[1];
            
            
            //need to check new position for events
            if(map[row][col].getBase().equals("&")){//if detect enemy=true -> Battle
               Enemy enemy = new Enemy("Boar");
               Battle(player, enemy, "Room-"+current);
               map[row][col].setBase(" ");//enemy stays erased for this instance
            }
            else if(map[row][col].getBase().equals("H") && (player.getHealth()!=player.getMaxHealth() || player.getStamina()!=player.getMaxStamina() || player.getMagic()!=player.getMaxMagic())){
               openHealing(player);
            }
            else if(map[row][col].getBase().equals("$")){
               openShop(player, current);
            }
            else if(map[row][col].getBase().equals("F")){
               openForge(player);
            }
            printMap(map);
            player.print();           
         }
         else if(!line.equals("cool")){
               System.out.println("Invalid input, please use 'wasd' for movement and 'menu' to open the menu.");
         }
         
         }//end while loop
         System.out.println("Nice Job!");
         }//end main
         }//end class