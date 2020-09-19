
public class Move{
   String name;
   double[] damageFormula = new double[5];
   /*
      0 -> Base damage
      1 -> Strength multiple
      2 -> Skill multiple
      3 -> Weapon.getAttackValue() multiple
      4 -> Weapon.getSkillValue() multiple
   */
   int cost;
   boolean type;
   
   public Move(Player player, String newName, double[] newDamageFormula, int newCost, boolean newType){
      name = newName;
      damageFormula = newDamageFormula;
      cost = newCost;
      type = newType;
   }
   
   public String getName(){
      return name;
   }
   public void setName(String newName){
      name = newName;
   }
   
   public double[] getDamage(){//refer to formula
      //int damage = (int)(damageFormula[0]+(damageFormula[1]*player.getStrength()));
      return damageFormula;
   }
   
   public int getCost(){
      return cost;
   }
   
   public boolean getType(){
      return type;
   }
}