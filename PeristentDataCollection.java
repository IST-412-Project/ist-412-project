/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapp311;

import java.io.*;

/**
 *
 * @author SHaynes
 */
public class PeristentDataCollection implements Serializable{
    
    private UserList theUserList;
    // All other persistent data will go below here
    
    public PeristentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
    }
    
    public UserList getuserList(){
        return theUserList;
    }
    
}
