/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NOrganization;

/**
 *
 * @author rwalawalkar
 */
public class NOrganization {
    private String nOrganizationName;
    private NOrganizationType nOrganizationType;
    
    public NOrganization(String nOrganizationName,NOrganizationType nOrganizationType ) {
        this.nOrganizationName = nOrganizationName;
        this.nOrganizationType = nOrganizationType;
    }
    
    public enum NOrganizationType{
        Survey("Survey"), Fiduciary("Fiduciary"), Aegis("Aegis"), MedicalAid("MedicalAid"), ClothesAid("ClothesAid"), Admin("Admin");
        
        private String value;
        private NOrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public NOrganizationType getnOrganizationType() {
        return nOrganizationType;
    }

    public void setnOrganizationType(NOrganizationType nOrganizationType) {
        this.nOrganizationType = nOrganizationType;
    }
    @Override
        public String toString(){
            return nOrganizationType.getValue();
        }
    
}
