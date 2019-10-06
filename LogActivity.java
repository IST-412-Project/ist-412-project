/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import java.io.Serializable;

/**
 *
 * @author etr11
 */
public class LogActivity implements Serializable {

    private String activity = new String();
    private String date = new String();

    public LogActivity(String newActivity, String newDate) {
        activity = newActivity;
        date = newDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String newActivity) {
        activity = newActivity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String newDate) {
        date = newDate;
    }
}
