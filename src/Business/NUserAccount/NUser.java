/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NUserAccount;

import Business.NOrganization.NOrganization;

/**
 *
 * @author rwalawalkar
 */
public class NUser {
    private String uName;
    private String uEmail;
    private String uPassword;
    private NOrganization nOrganization;
    private boolean isDeleted;

    public NUser(String uName, String uEmail, String uPassword,NOrganization nOrganization ){
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.nOrganization = nOrganization;
        this.isDeleted = false;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public NOrganization getnOrganization() {
        return nOrganization;
    }

    public void setnOrganization(NOrganization nOrganization) {
        this.nOrganization = nOrganization;
    }
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    @Override
    public String toString() {
        return uName;
    }  
}
