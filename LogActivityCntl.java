/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author etr11
 */
public class LogActivityCntl {
   @FXML private Stage stage;
    private static LogActivityCntl theLogActivityCntl;
    private ObservableList<User> theListOfActivity;
    
    private LogActivityCntl(Stage theExistingStage){
        theListOfActivity = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        stage = theExistingStage;
        this.setUpLogActivityListScene();
        stage.show();
    }
    
    public static LogActivityCntl getLogActivityCntl(Stage theStage){
        if(theLogActivityCntl != null){
            return theLogActivityCntl;
        }else{
            theLogActivityCntl = new LogActivityCntl(theStage);
            return theLogActivityCntl;
        }
    }
    
    @FXML public void setUpLogActivityListScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("LogActivityUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("LogActivity");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
        public void getNavigationCntl(Stage theStage){
        NavigationCntl.getNavigationCntl(theStage).setUpNavigationScene();
    }
    
    
    
    public void addLogActivityRow(User newUser){
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData().add(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }
    
    public ObservableList<User> getListOfActivity(){
        return theListOfActivity;
    }
    
    public Stage getStage(){
        return stage;
    }
    
}
