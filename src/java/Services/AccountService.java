/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;

/**
 *
 * @author valentinmorales
 */
public class AccountService {

    public AccountService() {
    }
    
    
    public User login(String name, String password)
    {
        if((name.equals("barb")||name.equals("abe"))&& password.equals("password"))
        {
            User user = new User(name,null,false);
            return user;
        }
        return null;
    }
}
