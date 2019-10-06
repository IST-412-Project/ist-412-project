/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

/**
 *
 * @author etr11
 */



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

/**
 *
 * @author SHaynes
 */

public class ScheduleCtrl {
    @FXML private Stage stage;
    private static ScheduleCtrl theScheduleCntl;
    private ObservableList<User> theListOfUsers;
    
    private ScheduleCtrl(Stage theExistingStage){
        theListOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        stage = theExistingStage;
        this.setUpUserListScene();
        stage.show();
    }
    
    public static ScheduleCtrl getScheduleCntl(Stage theStage){
        if(theScheduleCntl != null){
            return theScheduleCntl;
        }else{
            theScheduleCntl = new ScheduleCtrl(theStage);
            return theScheduleCntl;
        }
    }
    
    @FXML public void setUpUserListScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("ScheduleUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Schedule");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
        public void getNavigationCntl(Stage theStage){
        NavigationCntl.getNavigationCntl(theStage).setUpNavigationScene();
    }
    
    
    
    public void addUserRow(User newUser){
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData().add(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }
    
    public ObservableList<User> getListOfUsers(){
        return theListOfUsers;
    }
    
    public Stage getStage(){
        return stage;
    }
    
}




    
