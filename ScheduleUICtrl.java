/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author etr11
 */
public class ScheduleUICtrl {
        @FXML private Text actiontarget;
    
    
 
        @FXML protected void handleBackButtonAction(ActionEvent event) {
        actiontarget.setText("Back button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        ScheduleCtrl.getScheduleCntl(theStage).getNavigationCntl(theStage);
    }

}


