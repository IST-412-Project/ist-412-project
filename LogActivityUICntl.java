/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author etr11
 */
public class LogActivityUICntl implements Initializable {

    @FXML
    private TableView<User> userTable = new TableView<User>();
    @FXML
    private TableColumn<User, String> activityColumn = new TableColumn("Activity");
    @FXML
    private TableColumn<User, String> dateColumn = new TableColumn("Date");
    @FXML
    private ObservableList<User> listOfUsers;
    @FXML
    private Button getSelectedRowButton;
    @FXML
    private Button addRowButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();

        // Set up the table columns and link them to the table data fields
        activityColumn.setCellValueFactory(new PropertyValueFactory<User, String>("activity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<User, String>("date"));

        SimpleStringProperty s = new SimpleStringProperty("Test");
        TextField t = new TextField("Test");
        if (s.get().equals(t.getText())) {
            System.out.println("Success");
        }

        // Add the data to the table
        userTable.setItems(listOfUsers);
    }

 /*   @FXML
    public void addRow() {
        LogActivity tempUser = new User("AddActivity", "AddDate");
        Stage theStage = (Stage) addRowButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).addUserRow(tempUser);
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        userTable.setItems(listOfUsers);
    }
*/
    @FXML
    public void getSelectedRow() {
        User tempUser = userTable.getSelectionModel().getSelectedItem();
        System.out.println(tempUser.getUsername());
        // Could pass the user to the UserCntl to show in a new Stage/Scene
    }
}




//this was in LogActivityUI.fxml under  <Button fx:id="getSelectedRowButton"  but would not work with it
  // <Button fx:id="addRowButton" layoutX="321.0" layoutY="337.0" mnemonicParsing="false" onAction="#addRow" prefHeight="25.0" prefWidth="96.0" text="Add Activity" />
