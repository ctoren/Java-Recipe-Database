package Recipe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author corinetoren
 */
public class Recipe {
    private String type;
    private String name;
    private String ingredients;
    private String directions;
    
   public String getType() {
       return type;
   }
   
   public void setType(String newType) {
       this.type = newType;
   }
   
   public String getName() {
       return name;
   }
   
   public void setName(String newName) {
       this.name = newName;
   }
   
   public String getIngredients() {
       return ingredients;
   }
   
   public void setIngredients(String newIngredients) {
       this.ingredients = newIngredients; 
   }
   
   public String getDirections() {
       return directions;
   }
   
   public void setDirections(String newDirections) {
       this.directions = newDirections;
   }
}
