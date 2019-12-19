/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NEnterprise;

import Business.NOrganization.NOrganizationDirectory;
import Business.NUserAccount.NUser;

/**
 *
 * @author rwalawalkar
 */
public class NEnterprise {
    private String nEnterpriseName;
    private NEnterpriseType nEnterpriseType;
    private NOrganizationDirectory nOrganizationDirectory;
    private NUser nLoggedInUser = null;
    
    public NEnterprise(String nEnterpriseName,NEnterpriseType type){
        nEnterpriseName = nEnterpriseName;
        this.nEnterpriseType=type;
        this.nOrganizationDirectory = new NOrganizationDirectory();
    }
    
    public enum NEnterpriseType{
        CommunityService("CommunityService"),Inventory("Inventory");
        
        private String value;
        
        private NEnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
            return value;
        }
    }
    
    public String getnEnterpriseName() {
        return nEnterpriseName;
    }

    public void setnEnterpriseName(String nEnterpriseName) {
        this.nEnterpriseName = nEnterpriseName;
    }

    public NEnterpriseType getnEnterpriseType() {
        return nEnterpriseType;
    }

    public void setnEnterpriseType(NEnterpriseType nEnterpriseType) {
        this.nEnterpriseType = nEnterpriseType;
    }
    
    public NOrganizationDirectory getnOrganizationDirectory() {
        return nOrganizationDirectory;
    }

    public void setnOrganizationDirectory(NOrganizationDirectory nOrganizationDirectory) {
        this.nOrganizationDirectory = nOrganizationDirectory;
    }

    public NUser getnLoggedInUser() {
        return nLoggedInUser;
    }

    public void setnLoggedInUser(NUser nLoggedInUser) {
        this.nLoggedInUser = nLoggedInUser;
    }
    
    @Override
        public String toString(){
            return nEnterpriseType.getValue();
        }
}
