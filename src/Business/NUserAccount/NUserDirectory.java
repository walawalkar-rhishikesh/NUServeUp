/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NUserAccount;

import Business.NEUServeUp;
import Business.NOrganization.NOrganization;
import Business.Util.Helper;
import java.util.ArrayList;

/**
 *
 * @author rwalawalkar
 */
public class NUserDirectory {
    private ArrayList<NUser> userList;
    private Helper helper;

    public NUserDirectory() {
        userList = new ArrayList();
        helper = new Helper();
    }

    public ArrayList<NUser> getUserList() {
        return userList;
    }
    
    public NUser userAuthentication(String uEmail, String uPassword){
        for (NUser user : userList){
            if(user.getuEmail().equalsIgnoreCase(uEmail) && user.getuPassword().equals(uPassword)){
                return user;
            }
        }
        return null;
    }
    
    public NUser userCreation(String uName, String uEmail, String uPassword, NOrganization nOrganization){
        if(!checkIfUserExists(uPassword)){
            NUser user = new NUser(helper.capitalizeFirstLetter(uName.trim()),uEmail.toLowerCase().trim(), uPassword,nOrganization);
            userList.add(user);
            return user;
        }
        return null; 
    }
    
    public void userDeletion(String uEmail){
        for(NUser user : NEUServeUp.getInstance().getUserDirectory().getUserList()){
            if(user.getuEmail() == uEmail){
                userList.remove(user);
            }
        }
        
    }
    
    public void userUpdate(String uEmail, String upassword){
         for(NUser user : NEUServeUp.getInstance().getUserDirectory().getUserList()){
            if(user.getuEmail() == uEmail){
                user.setuPassword(upassword);
            }
        }
    }
    
    public boolean checkIfUserExists(String uEmail){
        for (NUser user : userList){
            if (user.getuEmail().equalsIgnoreCase(uEmail))
                return true;
        }
        return false;
    }
    public boolean checkIfUserIsDeleted(String uEmail){
        for (NUser user : userList){
            if (user.getuEmail().equalsIgnoreCase(uEmail) && user.isIsDeleted())
                return true;
        }
        return false;
    }
}
