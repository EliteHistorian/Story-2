
public class Equipment{
   
   String name;
   String type;
   int sellPrice;
   int level;
   int exp;
   int goal;
   int hpValue;
   int staminaValue;
   int magicValue;
   int healValue;
   int attackValue;
   int focusValue;
   int defenseValue;
   int strengthValue;
   int skillValue;
   int speedValue;
   boolean equipped;
   double[] formula = new double[11];//should be in constructor
   //containing multiples of each stat that should occur each level up
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
   
   public Equipment(String newName, String newType, int newSellPrice){
      name = newName;
      type = newType;
      sellPrice = newSellPrice;
      equipped = false;
      level = 0;
      exp = 0;
      goal = 100;
      double[] newFormula = new double[11];
      for(int i=0;i<11;i++){newFormula[i] = 0;}
      formula = newFormula;
      hpValue = 0;
      staminaValue = 0;
      magicValue = 0;
      healValue = 0;
      attackValue = 0;
      focusValue = 0;
      defenseValue = 0;
      skillValue = 0;
      speedValue = 0;
      
      
   }
   
   public Equipment(String newName, String newType, int newSellPrice, int newLevel, double[] newFormula){
      name = newName;
      type = newType;
      sellPrice = newSellPrice;
      equipped = false;
      level = newLevel;
      exp = 0;
      goal = 100*(int)Math.pow(2, level-1);
      formula = newFormula;
      hpValue = 0;
      staminaValue = 0;
      magicValue = 0;
      healValue = 0;
      attackValue = 0;
      focusValue = 0;
      defenseValue = 0;
      skillValue = 0;
      speedValue = 0;
   }
   
   public boolean isEquipped(){
      return equipped;
   }
   public void setEquipped(boolean eq){
      equipped = eq;
   }
   
   public String getName(){
      return name;
   }
   public void setName(String newName){
      name = newName;
   }
   
   public String getType(){
      return type;
   }
   public void setType(String newType){
      type = newType;
   }
   
   public int getLevel(){
      return level;
   }
   public void setLevel(int newLevel){
      level = newLevel;
   }
   
   public int getExp(){
      return exp;
   }
   
   /*
   0 HP
   1 Stamina
   2 Magic
   3 attackValue
   4 focusValue
   5 strength
   6 skill
   7 defense
   8 speed
   9 healValue
   10 sellPrice
   */
   public boolean setExp(int newExp){//maybe update relevant values depending on type during levelUp
      exp = newExp;
      boolean levelUp = false;
      while(exp >= goal){//levelUp code here
         level++;
         exp -= goal;//preserve remainder
         //exp -= this.getGoal()// would make next line and entire goal variable redundant to just calling the getGoal method, think
         goal = 100*(int)Math.pow(2, level-1);
         //start changes
         hpValue = (int)formula[0]*hpValue;
         staminaValue = (int)formula[1]*staminaValue;
         magicValue = (int)formula[2]*magicValue;
         attackValue = (int)formula[3]*attackValue;
         focusValue = (int)formula[4]*focusValue;
         strengthValue = (int)formula[5]*strengthValue;
         skillValue = (int)formula[6]*skillValue;
         defenseValue = (int)formula[7]*defenseValue;
         speedValue = (int)formula[8]*speedValue;
         healValue = (int)formula[9]*healValue;
         sellPrice = (int)formula[10]*sellPrice;
         //end changes
         levelUp = true;
      }
      return levelUp;
   }
   
   public int getGoal(){
      return 100*(int)Math.pow(2, level-1);
   }
   
   public int getSellPrice(){
      return sellPrice;
   }
   public void setSellPrice(int newSellPrice){
      sellPrice = newSellPrice;
   }
   
   public int getHealValue(){
      return healValue;
   }
   public void setHealValue(int newHealValue){
      healValue = newHealValue;
   }
   
   public int getAttackValue(){
      return attackValue;
   }
   public void setAttackValue(int newAttackValue){
      attackValue = newAttackValue;
   }
   
   public int getFocusValue(){
      return focusValue;
   }
   public void setFocusValue(int newFocusValue){
      focusValue = newFocusValue;
   }
   
   public int getDefenseValue(){
      return defenseValue;
   }
   public void setDefenseValue(int newDefenseValue){
      defenseValue = newDefenseValue;
   }
   
   public int getSkillValue(){
      return skillValue;
   }
   public void setSkillValue(int newSkillValue){
      skillValue = newSkillValue;
   }
   
   public int getSpeedValue(){
      return speedValue;
   }
   public void setSpeedValue(int newSpeedValue){
      speedValue = newSpeedValue;
   }
}