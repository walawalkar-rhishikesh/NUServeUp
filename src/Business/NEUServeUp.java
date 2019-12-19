/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.NEnterprise.NEnterpriseDirectory;
import Business.NOrganization.NOrganization;
import Business.NUserAccount.NUser;
import Business.NUserAccount.NUserDirectory;
import Business.Work.WorkDirectory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author rwalawalkar
 */
public class NEUServeUp{
    private static NEUServeUp neuServeUp;
    private NEnterpriseDirectory nEnterpriseDirectory;
//    User Listing: Need to add
    private NUserDirectory userDirectory;
//    WorkQueue: Need to add
    private WorkDirectory workDirectory;
    private NUser uUser;
    private JButton btnLogout;
    private JButton btnProfile;
    private JPanel panelBody;

    private NEUServeUp(){
        nEnterpriseDirectory = new NEnterpriseDirectory();
        userDirectory = new NUserDirectory();
        workDirectory = new WorkDirectory();
    }
    
    public static NEUServeUp getInstance(){
        if(neuServeUp==null){
            neuServeUp = new NEUServeUp();
        }
        return neuServeUp;
    }

    public NEnterpriseDirectory getnEnterpriseDirectory() {
        return nEnterpriseDirectory;
    }

    public void setnEnterpriseDirectory(NEnterpriseDirectory nEnterpriseDirectory) {
        this.nEnterpriseDirectory = nEnterpriseDirectory;
    }

    public NUserDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(NUserDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }
    
    public NUser getuUser() {
        return uUser;
    }

    public void setuUser(NUser uUser) {
        this.uUser = uUser;
        if(uUser == null){
            this.btnLogout.setVisible(false);
            this.btnProfile.setVisible(false);
        }else{
            this.btnLogout.setVisible(true);
            this.btnProfile.setVisible(true);
        }
    }
    
    public JButton getbtnLogout() {
        return btnLogout;
    }

    public void setbtnLogout(JButton jButton) {
        this.btnLogout = jButton;
    }
    public JButton getbtnProfile() {
        return btnProfile;
    }

    public void setbtnProfile(JButton btnProfile) {
        this.btnProfile = btnProfile;
    }
    
    public JPanel getPanelBody() {
        return panelBody;
    }

    public void setPanelBody(JPanel panelBody) {
        this.panelBody = panelBody;
    }
    
    public WorkDirectory getWorkDirectory() {
        return workDirectory;
    }

    public void setWorkDirectory(WorkDirectory workDirectory) {
        this.workDirectory = workDirectory;
    }
}
