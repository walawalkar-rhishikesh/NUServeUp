/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NOrganization;

import Business.NOrganization.NOrganization.NOrganizationType;
import java.util.ArrayList;

/**
 *
 * @author rwalawalkar
 */
public class NOrganizationDirectory {
    
    private ArrayList<NOrganization> nOrganizationList;

    public NOrganizationDirectory() {
        nOrganizationList = new ArrayList();
    }

    public ArrayList<NOrganization> getOrganizationList() {
        return nOrganizationList;
    }
    
    public NOrganization createOrganization(String nOrganizationName, NOrganizationType nOrganizationType){
        NOrganization nOrganization = new NOrganization(nOrganizationName,nOrganizationType);
        nOrganizationList.add(nOrganization);
        return nOrganization;
    }
    
}
