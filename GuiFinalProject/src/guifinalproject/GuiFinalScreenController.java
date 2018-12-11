/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifinalproject;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Tyler Martin
 */
public class GuiFinalScreenController{

  /**
  * Initializes the controller class.
  */
  @FXML
  private Label nameField;

  @FXML
  void connect(ActionEvent event) {
    final String Database_Url =
            "jdbc:derby://localhost:1527/contact";
    final String Select_Query =
        "SELECT MEMBERNAME, MEMBERSINCE FROM APP.MEMBER";

    try{ 
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    
    try (
        Connection connection = DriverManager.getConnection(
            Database_Url, "tmartin", "tmartin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Select_Query)) {
      resultSet.next();
      nameField.setText(resultSet.getString(2));
                //set date (3)
                
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }  
    
}
