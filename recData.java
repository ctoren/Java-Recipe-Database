package Recipe;


import Recipe.Recipe;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author corinetoren
 */
public class recData {
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/recipe";
    static final String DB_USER = "ctoren";
    static final String DB_PASS = "ca91356";
    private JdbcRowSet rowSet = null;
    
    public recData() {
        try {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(recData.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM RECIPE");
            rowSet.execute();
        }  
        catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
   public Recipe create(Recipe r){
        try {
         rowSet.moveToInsertRow();
         rowSet.updateString("type", r.getType());
         rowSet.updateString("name", r.getName());
         rowSet.updateString("ingredients", r.getIngredients());
         rowSet.updateString("directions", r.getDirections());
         rowSet.insertRow();
         rowSet.moveToCurrentRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
            r = null;
         } catch (SQLException e) {

         }
         ex.printStackTrace();
      }
      return r;
   }

   public Recipe update(Recipe r) {
      try {
         rowSet.updateString("type", r.getType());
         rowSet.updateString("name", r.getName());
         rowSet.updateString("ingredients", r.getIngredients());
         rowSet.updateString("directions", r.getDirections());
         rowSet.updateRow();
         rowSet.moveToCurrentRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
         } catch (SQLException e) {

         }
         ex.printStackTrace();
      }
      return r;
   }

   public void delete() {
      try {
         rowSet.moveToCurrentRow();
         rowSet.deleteRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
         } catch (SQLException e) { }
         ex.printStackTrace();
      }

   }

   public Recipe moveFirst() {
      Recipe r = new Recipe();
      try {
         rowSet.first();
         r.setType(rowSet.getString("type"));
         r.setName(rowSet.getString("name"));
         r.setIngredients(rowSet.getString("ingredients"));
         r.setDirections(rowSet.getString("directions"));
         

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return r;
   }

   public Recipe moveLast() {
      Recipe r = new Recipe();
      try {
         rowSet.last();
         r.setType(rowSet.getString("type"));
         r.setName(rowSet.getString("name"));
         r.setIngredients(rowSet.getString("ingredients"));
         r.setDirections(rowSet.getString("directions"));
         

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return r;
   }

   public Recipe moveNext() {
      Recipe r = new Recipe();
      try {
         if (rowSet.next() == false)
            rowSet.previous();
         r.setType(rowSet.getString("type"));
         r.setName(rowSet.getString("name"));
         r.setIngredients(rowSet.getString("Ingredients"));
         r.setDirections(rowSet.getString("directions"));
         

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return r;
   }

   public Recipe movePrevious() {
      Recipe r = new Recipe();
      try {
         if (rowSet.previous() == false)
            rowSet.next();
         r.setType(rowSet.getString("type"));
         r.setName(rowSet.getString("name"));
         r.setIngredients(rowSet.getString("ingredients"));
         r.setDirections(rowSet.getString("directions"));
         

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return r;
   }

   public Recipe getCurrent() {
      Recipe r = new Recipe();
      try {
         rowSet.moveToCurrentRow();
         r.setType(rowSet.getString("type"));
         r.setName(rowSet.getString("name"));
         r.setIngredients(rowSet.getString("ingredients"));
         r.setDirections(rowSet.getString("directions"));
       
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return r;
   }
}



