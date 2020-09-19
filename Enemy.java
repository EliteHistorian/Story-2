

public class Enemy{
   /*
   Problem: need enemies to drop items for player
   Solution: randomly generate drops in the main based on enemy level and current MAP #
   */
   String name;
   int maxHealth;
   int health;
   int currency;
   int exp;
   int level;
   int strength;
   int skill;
   int defense;
   int stamina;
   int magic;
   int speed;
   
   public Enemy(String newName){
      name = newName;
      maxHealth = 10;
      health = maxHealth;
      currency = 15;
      exp = 10;
      level = 1;
      strength = 1;
      skill = 1;
      defense = 0;
      stamina = 0;
      magic = 0;
      speed = 0;
   }
   public Enemy(String newName, int newHealth, int newStrength, int newSkill, int newDefense, int newStamina, int newMagic, int newSpeed){
      
      name = newName;
      maxHealth = newHealth;
      health = maxHealth;
      currency = 15;
      exp = 10;
      level = 1;
      strength = newStrength;
      skill = newSkill;
      defense = newDefense;
      stamina = newStamina;
      magic = newMagic;
      speed = newSpeed;
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
   public void setExp(int newExp){
      exp = newExp;
   }
   
   public int getStrength(){
      return strength;
   }
   public void setStength(int newStrength){
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
   
   public int getStamina(){
      return stamina;
   }
   public void setStamina(int newStamina){
      stamina = newStamina;
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
}