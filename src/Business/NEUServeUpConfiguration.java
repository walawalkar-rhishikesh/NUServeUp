/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.NEnterprise.NEnterprise;
import Business.NOrganization.NOrganization;

/**
 *
 * @author rwalawalkar
 */
public class NEUServeUpConfiguration {
    
    public static NEUServeUp configure(){
        
        NEUServeUp system = NEUServeUp.getInstance();
        
//        Create Default Enterprise
        system.getnEnterpriseDirectory().addNEnterprise("CommunityService", NEnterprise.NEnterpriseType.CommunityService);
        system.getnEnterpriseDirectory().addNEnterprise("Inventory", NEnterprise.NEnterpriseType.Inventory);
        
//        Create Default Organizations
        system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().createOrganization("Survey",NOrganization.NOrganizationType.Survey);
        system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().createOrganization("Fiduciary",NOrganization.NOrganizationType.Fiduciary);
        system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().createOrganization("Aegis",NOrganization.NOrganizationType.Aegis);

        system.getnEnterpriseDirectory().getNEnterpriseList().get(1).getnOrganizationDirectory().createOrganization("MedicalAid",NOrganization.NOrganizationType.MedicalAid);
        system.getnEnterpriseDirectory().getNEnterpriseList().get(1).getnOrganizationDirectory().createOrganization("ClothesAid",NOrganization.NOrganizationType.ClothesAid);

//          Add Users
        NOrganization surveyNOrganization = system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().getOrganizationList().get(0);
        NOrganization fiduciaryNOrganization = system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().getOrganizationList().get(1);
        NOrganization aegisNOrganization = system.getnEnterpriseDirectory().getNEnterpriseList().get(0).getnOrganizationDirectory().getOrganizationList().get(2);
        NOrganization medicalAidNOrganization = system.getnEnterpriseDirectory().getNEnterpriseList().get(1).getnOrganizationDirectory().getOrganizationList().get(0);
        NOrganization clothesAidNOrganization = system.getnEnterpriseDirectory().getNEnterpriseList().get(1).getnOrganizationDirectory().getOrganizationList().get(1);
        
        system.getUserDirectory().userCreation("s@neu.com", "s@neu.com", "s@neu",surveyNOrganization );
        system.getUserDirectory().userCreation("f@neu.com", "f@neu.com", "f@neu",fiduciaryNOrganization );
        system.getUserDirectory().userCreation("a@neu.com", "a@neu.com", "a@neu",aegisNOrganization );
        system.getUserDirectory().userCreation("m@neu.com", "m@neu.com", "m@neu",medicalAidNOrganization );
        system.getUserDirectory().userCreation("c@neu.com", "c@neu.com", "c@neu",clothesAidNOrganization );
        
        return system;
    }
    
}
