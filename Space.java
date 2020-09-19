import java.io.*;
import java.util.*;

public class Space{

   String original;
   String current;
   String direction;
   boolean wall;
   int exit;

   public Space(String base){
      original = base;
      current = base;
      wall = false;
      exit = -1;
      direction = "";
   }
   public Space(String base, String dir, boolean status, int door){
      original = base;
      current = base;
      direction = dir;
      wall = status;
      exit = door;
   }
   
   public String getBase(){
      return original;
   }
   public void setBase(String newBase){
      original = newBase;
   }
   
   public String getCurrent(){
      return current;
   }
   public void setCurrent(String newCurrent){
      current = newCurrent;
   }
   
   public String getDirection(){
      return direction;
   }
   public void setDirection(String dir){
      direction = dir;
   }
   
   public boolean isWall(){
      return wall;
   }
   public void setWall(boolean status){
      wall = status;
   }
   
   public boolean isExit(){
      return (exit!=-1);
   }
   public int getExit(){
      return exit;
   }
   public void setExit(int newExit){
      exit = newExit;
   }
}   