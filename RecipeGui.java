/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recipe;


/**
 *
 * @author corinetoren
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class RecipeGui extends JPanel {
    
    
    
    
    private JTextField typeField = new JTextField(20);
    private JTextField nameField = new JTextField(30);
    private JTextField ingredField = new JTextField(250);
    private JTextField directField = new JTextField(350);
   
    private JButton create = new JButton("New");
    private JButton edit = new JButton("Edit");
    private JButton delete = new JButton("Delete");
    private JButton save = new JButton("Save");
    private JButton back = new JButton("Back");
    private JButton next = new JButton("Next");
   
    private recData bean = new recData();

   public RecipeGui() {
      setBorder(new TitledBorder
      (new EtchedBorder(),"Recipes"));
       setLayout(new BorderLayout(5, 5));
      add(fields(), BorderLayout.NORTH);
      add(Buttons(), BorderLayout.CENTER);
      setFieldData(bean.moveFirst());
   }
private JPanel Buttons() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
    panel.add(create);
    create.addActionListener(new ButtonHandler());
    panel.add(edit);
    edit.addActionListener(new ButtonHandler());
    panel.add(delete);
    delete.addActionListener(new ButtonHandler());
    panel.add(save);
    save.addActionListener(new ButtonHandler());
    panel.add(back);
    back.addActionListener(new ButtonHandler());
    panel.add(next);
    next.addActionListener(new ButtonHandler());
    return panel;
}
    private JPanel fields() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      panel.add(new JLabel("Type"), "align label");
      panel.add(typeField, "wrap");
      typeField.setEnabled(true);
      panel.add(new JLabel("Name"), "align label");
      panel.add(nameField, "wrap");
      panel.add(new JLabel("Ingredients"), "align label");
      panel.add(ingredField, "wrap");
      panel.add(new JLabel("Directions"), "align label");
      panel.add(directField, "wrap");
      return panel;
   }

   private Recipe getFieldData() {
      Recipe r = new Recipe();
      r.setType(typeField.getText());
      r.setName(nameField.getText());
      r.setIngredients(ingredField.getText());
      r.setDirections(directField.getText());
     
      return r;
   }

   private void setFieldData(Recipe r) {
      typeField.setText(String.valueOf(r.getType()));
      nameField.setText(r.getName());
      ingredField.setText(r.getIngredients());
      directField.setText(r.getDirections());
     
   }

   private boolean isEmptyFieldData() {
      return (typeField.getText().trim().isEmpty()
         && nameField.getText().trim().isEmpty()
         && ingredField.getText().trim().isEmpty()
         && directField.getText().trim().isEmpty());
   }
   
    private class ButtonHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         Recipe r = getFieldData();
         switch (e.getActionCommand()) {
         case "Save":
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            if (bean.create(r) != null)
               JOptionPane.showMessageDialog(null,
               "New person created successfully.");
               create.setText("New...");
               break;
         case "New":
            r.setType("");
            r.setName("");
            r.setIngredients("");
            r.setDirections("");
            setFieldData(r);
            create.setText("Save");
            break;
         case "Edit":
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot save an empty record");
               return;
            }
            
               break;
         case "Delete":
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot delete an empty record");
               return;
            }
            
      }
   }
}
}
