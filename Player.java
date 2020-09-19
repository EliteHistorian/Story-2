import java.io.*;
import java.util.*;
/*
Problem: Equipment stats don't affect player in battle

Solution: calculate and display player stats augmented by equipment stats
*/
public class Player{

   String name;
   int maxHealth;
   int health;
   int currency;
   int exp;
   int level;
   int goal;
   int statPoints;
   int skillPoints;
   int strength;
   int skill;
   int defense;
   int maxStamina;
   int stamina;
   int maxMagic;
   int magic;
   int speed;
   ArrayList<Move> moveList;
   ArrayList<Equipment> inventory;
   /*
   //let each of these extend an item class*/
   Equipment helmet;//type = "Helmet"
   Equipment torso;//type = "Torso"
   Equipment gloves;//type = "Gloves"
   Equipment pants;//type = "Pants"
   Equipment shoes;//type = "Shoes"
   Equipment weapon;//type = "Weapon"
   Equipment ring;//limit should be 8, no thumb rings
   
   //let Potion extend item class, NOPE
   //ArrayList inventory;an ArrayList for each item type
   //Helmet, Torso, Glove, Pants, Shoes, Rings, Weapons, Potions, Materials
   

   public Player(String newName){
      name = newName;
      maxHealth = 10;
      health = maxHealth;
      currency = 0;
      exp = 0;
      level = 1;
      goal = (40*(level-1))+20;
      statPoints = 0;
      skillPoints = 0;
      strength = 1;
      skill = 1;
      defense = 0;
      maxStamina = 10;
      stamina = maxStamina;
      maxMagic = 10;
      magic = maxMagic;
      speed = 1;
      moveList = new ArrayList<Move>();
      weapon = new Equipment("Fist", "Weapon", 0);
      double[] strikeFormula = {1,1,0,1,0};
      Move strike = new Move(this, "Strike", strikeFormula, 0, false);
      moveList.add(strike);
      inventory = new ArrayList<Equipment>();
      helmet = new Equipment("Basic_Helmet", "Helmet", 0);//type = "Helmet"
      torso = new Equipment("Basic_Torso", "Torso", 0);//type = "Torso"
      gloves = new Equipment("Basic_Gloves", "Gloves", 0);//type = "Gloves"
      pants = new Equipment("Basic_Pants", "Pants", 0);//type = "Pants"
      shoes = new Equipment("Basic_Shoes", "Shoes", 0);//type = "Shoes"
      ring = new Equipment("Basic_Ring", "Ring", 0);//type = "Ring"
      /*rings = new Ring[8];
      for(int i=0;i<8;i++){
         rings[i] = new Ring();
      }
      */
   }
   public Player(String newName, int newCurrency, int newLevel, int newExp, int newStatPoints, int newSkillPoints, int newMaxHealth, int newHealth, int newStrength, int newSkill, int newDefense, int newMaxStamina, int newStamina, int newMaxMagic, int newMagic, int newSpeed){
      name = newName;
      currency = newCurrency;
      exp = newExp;
      level = newLevel;
      goal = (40*(level-1))+20;//maybe change formula or enemy XP values for a better growth rate(slower or faster)
      statPoints = newStatPoints;
      skillPoints = newSkillPoints;
      maxHealth = newMaxHealth;
      health = newHealth;
      strength = newStrength;
      skill = newSkill;
      defense = newDefense;
      maxStamina = newMaxStamina;
      stamina = newStamina;
      maxMagic = newMaxMagic;
      magic = newMagic;
      speed = newSpeed;
      moveList = new ArrayList<Move>();
      weapon = new Equipment("Fist", "Weapon", 0);
      double[] strikeFormula = {1,1,0,1,0};
      Move strike = new Move(this, "Strike", strikeFormula, 0, false);
      moveList.add(strike);
      inventory = new ArrayList<Equipment>();
      helmet = new Equipment("Basic_Helmet", "Helmet", 0);//type = "Helmet"
      torso = new Equipment("Basic_Torso", "Torso", 0);//type = "Torso"
      gloves = new Equipment("Basic_Gloves", "Gloves", 0);//type = "Gloves"
      pants = new Equipment("Basic_Pants", "Pants", 0);//type = "Pants"
      shoes = new Equipment("Basic_Shoes", "Shoes", 0);//type = "Shoes"
      ring = new Equipment("Basic_Ring", "Ring", 0);//type = "Ring"
   }
   
   public String getName(){
      return name;
   }
   public void setName(String newName){
      name = newName;
   }
   
   public int getMaxHealth(){
      return maxHealth;
   }
   public void setMaxHealth(int newMaxHealth){
      maxHealth = newMaxHealth;
   }
   
   public int getHealth(){
      return health;
   }
   public void setHealth(int newHealth){
      health = newHealth;
   }
   
   public int getCurrency(){
      return currency;
   }
   public void setCurrency(int newCurrency){
      currency = newCurrency;
   }
   
   public int getExp(){
      return exp;
   }
   public boolean setExp(int newExp){
      exp = newExp;
      goal = (40*(level-1))+20;
      int levelUp = 0;
      while(exp >= goal){//levelUp code here
         level++;
         statPoints+=2;
         skillPoints+=1;
         maxHealth+=2;
         maxStamina+=2;
         maxMagic+=2;
         exp -= goal;//preserve remainder
         goal = (40*(level-1))+20;//improve formula
         levelUp = 1;
      }
      if(levelUp==1){
         return true;
      }
      return false;
   }
   
   public int getGoal(){
      return goal;
   }
   public void setGoal(int newGoal){
      goal = newGoal;
   }
   
   public int getLevel(){
      return level;
   }
   public void setLevel(int newLevel){
      level = newLevel;
   }
   
   public int getStatPoints(){
      return statPoints;
   }
   public void setStatPoints(int newStatPoints){
      statPoints = newStatPoints;
   }
   
   public int getSkillPoints(){
      return skillPoints;
   }
   public void setSkillPoints(int newSkillPoints){
      skillPoints = newSkillPoints;
   }
   
   public int getStrength(){
      //return strength+weapon.getAttackValue();
      return strength;
   }
   public void setStrength(int newStrength){
      strength = newStrength;
   }
   
   public int getSkill(){
      return skill;
   }
   public void setSkill(int newSkill){
      skill = newSkill;
   }
   
   public int getDefense(){
      return defense;
   }
   public void setDefense(int newDefense){
      defense = newDefense;
   }
   
   public int getMaxStamina(){
      return maxStamina;
   }
   public void setMaxStamina(int newMaxStamina){
      maxStamina = newMaxStamina;
   }
   
   public int getStamina(){
      return stamina;
   }
   public void setStamina(int newStamina){
      stamina = newStamina;
   }
   
   public int getMaxMagic(){
      return maxMagic;
   }
   public void setMaxMagic(int newMaxMagic){
      maxMagic = newMaxMagic;
   }
   
   public int getMagic(){
      return magic;
   }
   public void setMagic(int newMagic){
      magic = newMagic;
   }
   
   public int getSpeed(){
      return speed;
   }
   public void setSpeed(int newSpeed){
      speed = newSpeed;
   }
   
   public ArrayList<Move> getMoveList(){
      return moveList;
   }
   public void addMove(Move move){
      moveList.add(move);
   }
   
   /*
      0 -> Base damage
      1 -> Strength multiple
      2 -> Skill multiple
      3 -> Weapon.getAttackValue() multiple
      4 -> Weapon.getSkillValue() multiple
   */
   /* not yet
      0 -> Base damage
      1 -> Strength multiple
      2 -> Skill multiple
      3 -> Defense multiple
      4 -> Speed multiple
      5 -> Weapon.getAttackValue() multiple
      6 -> Weapon.getSkillValue() multiple
   */
   public double getMoveDamage(int index){
   //maybe add Equipment bonuses from Equipment, other than weapons, to the Strength and Skill values right before multiplication?
      Move move = moveList.get(index);
      double[] formula = move.getDamage();
      double moveDamage = formula[0]+(formula[1]*strength)+(formula[2]*skill)+(formula[3]*weapon.getAttackValue())+(formula[4]*weapon.getFocusValue());
      return moveDamage;
   }
   
   public int getTotalDefense(){
      int total = defense+weapon.getDefenseValue()+helmet.getDefenseValue()+torso.getDefenseValue()+gloves.getDefenseValue()+pants.getDefenseValue()+shoes.getDefenseValue();
      /*for(int i=0;i<8;i++){
         total+=rings[i];
      }*/
      return total;
   }
   
   public ArrayList<Equipment> getInventory(){
      return inventory;
   }
   public void addInventory(Equipment i){
      inventory.add(i);
   }
   public void removeInventory(int index){
      inventory.remove(index);
   }
   
   public void equip(Equipment e){
      
      if(e.getType().equals("Weapon")){
         weapon.setEquipped(false);
         e.setEquipped(true);
         weapon = e;
      }
      if(e.getType().equals("Helmet")){
         helmet.setEquipped(false);
         e.setEquipped(true);
         helmet = e;
      }
      if(e.getType().equals("Torso")){
         torso.setEquipped(false);
         e.setEquipped(true);
         torso = e;
      }
      if(e.getType().equals("Gloves")){
         gloves.setEquipped(false);
         e.setEquipped(true);
         gloves = e;
      }
      if(e.getType().equals("Pants")){
         pants.setEquipped(false);
         e.setEquipped(true);
         pants = e;
      }
      if(e.getType().equals("Shoes")){
         shoes.setEquipped(false);
         e.setEquipped(true);
         shoes = e;
      }
      if(e.getType().equals("Ring")){
         ring.setEquipped(false);
         e.setEquipped(true);
         ring = e;
      }
      
   }
   public void unEquip(String type){
      if(helmet.getType().equals(type)){
         helmet.setEquipped(false);
         Equipment temp = new Equipment("Basic_Helmet", "Helmet", 0);
         helmet = temp;
         helmet.setEquipped(true);
      }
      else if(torso.getType().equals(type)){
         torso.setEquipped(false);
         Equipment temp = new Equipment("Basic_Torso", "Torso", 0);
         torso = temp;
         torso.setEquipped(true);
      }
      else if(gloves.getType().equals(type)){
         gloves.setEquipped(false);
         Equipment temp = new Equipment("Basic_Gloves", "Gloves", 0);
         gloves = temp;
         gloves.setEquipped(true);
      }
      else if(pants.getType().equals(type)){
         pants.setEquipped(false);
         Equipment temp = new Equipment("Basic_Pants", "Pants", 0);
         pants = temp;
         pants.setEquipped(true);
      }
      else if(shoes.getType().equals(type)){
         shoes.setEquipped(false);
         Equipment temp = new Equipment("Basic_Shoes", "Shoes", 0);
         shoes = temp;
         shoes.setEquipped(true);
      }
      else if(type.equals("Ring")){
      //replace selected ring with basic ring
         ring.setEquipped(false);
         Equipment temp = new Equipment("Basic_Ring", "Ring", 0);
         ring = temp;
         ring.setEquipped(true);
      }
   }
   
   public void print(){
      System.out.println("Level: "+level+"\nHealth: "+health+"\nStamina: "+stamina+"\nMagic: "+magic+"\nRemaining Exp: "+(goal-exp)+"\nGold: "+currency);
   }
   
   public void printMoves(){
      for(int i=0;i<moveList.size();i++){
         if(!moveList.get(i).getType()){
            System.out.println((i+1)+"-> "+moveList.get(i).getName()+": "+(int)this.getMoveDamage(i)+" damage, Cost: "+moveList.get(i).getCost()+" stamina.");
         }
         else if(moveList.get(i).getType()){
            System.out.println((i+1)+"-> "+moveList.get(i).getName()+": "+(int)this.getMoveDamage(i)+" damage, Cost: "+moveList.get(i).getCost()+" magic.");
         }
      }
   }
   /*public void equip(Equipment newEquip){
      call unEquip() on whatever's there
      copy to proper place
      maybe remove from inventory
      need isEquipped() boolean for Equipment class
   }
   public void unEquip(Equipment oldEquip){
      remove from proper place
   }*/
}