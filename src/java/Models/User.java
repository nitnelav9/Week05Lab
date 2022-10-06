/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author valentinmorales
 */
public class User implements Serializable{
    
    private String name;
    private boolean logout;

    private String password;
    
    public User()
    {
        this.name="";
        this.password = "";
        this.logout=false;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }
    
    public User(String name, String password, boolean logout) {
        this.name = name;
        this.password = password;
        this.logout = logout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    
    
    
}
