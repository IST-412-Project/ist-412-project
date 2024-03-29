/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import javafx.collections.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author SHaynes
 */
public class UserList implements Serializable{
    
    // private ObservableList<User> theListOfUsers;
    private ArrayList<User> theListOfUsersAL;
    
    public UserList(){
        theListOfUsersAL = getTestUsers();
    }
    
    public ObservableList<User> getUserData() {
        ObservableList<User> theListOfUsers;
        List<User> userList = (List<User>) theListOfUsersAL;
        theListOfUsers = FXCollections.observableList(userList);
        return theListOfUsers;
    }
    
    public ArrayList<User> getTestUsers(){
        ArrayList<User> testUsers = new ArrayList();
        for (int i = 0; i < 100; i++) {
            User newUser = new User("First" + i, "Last" + i, "username" + i, "password" + i);
            testUsers.add(newUser);
        }
        return testUsers;
    }
    
    
}
