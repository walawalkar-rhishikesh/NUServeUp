/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NEnterprise;

import Business.NOrganization.NOrganization;
import java.util.ArrayList;

/**
 *
 * @author rwalawalkar
 */
public class NEnterpriseDirectory {
    private ArrayList<NEnterprise> nEnterpriseList;
    
    public NEnterpriseDirectory(){
        nEnterpriseList=new ArrayList<NEnterprise>();
    }
    
    public ArrayList<NEnterprise> getNEnterpriseList() {
        return nEnterpriseList;
    }
    
    public void setNEnterpriseList(ArrayList<NEnterprise> nEnterpriseList) {
        this.nEnterpriseList = nEnterpriseList;
    }
    
    public NEnterprise addNEnterprise(String nEnterpriseName,NEnterprise.NEnterpriseType nEnterpriseType){
        NEnterprise nEnterprise= new NEnterprise(nEnterpriseName,nEnterpriseType);
        this.nEnterpriseList.add(nEnterprise);
        return nEnterprise;
    }
    
    public ArrayList<NOrganization> getAllOrganization(){
        ArrayList<NOrganization> nOrganizationList = new ArrayList();
        
        for(NEnterprise nEnterprise: this.nEnterpriseList){
            for(NOrganization nOrganization: nEnterprise.getnOrganizationDirectory().getOrganizationList()){
                nOrganizationList.add(nOrganization);
            }
        }
        
        return nOrganizationList;
    }
    
    public ArrayList<NOrganization> getEnterpriseOrganizationList(String enterpriseName){
        ArrayList<NOrganization> nTempOrganizationList = new ArrayList();
        for(NEnterprise nEnterprise: this.nEnterpriseList){
            if(nEnterprise.getnEnterpriseType().getValue().equalsIgnoreCase(enterpriseName)){
                for(NOrganization nOrganization: nEnterprise.getnOrganizationDirectory().getOrganizationList()){
                    nTempOrganizationList.add(nOrganization);
                }
            }
        }
        return nTempOrganizationList;
    }
}
