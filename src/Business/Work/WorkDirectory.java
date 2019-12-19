/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Work;

import Business.NEUServeUp;
import Business.Util.Helper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author rwalawalkar
 */
public class WorkDirectory {
    
    private ArrayList<Work> workList;
    private Helper helper;
    NEUServeUp neuServeUp;
    
    public WorkDirectory(){
        workList = new ArrayList();
        helper = new Helper();
    }

    public ArrayList<Work> getWorkList() {
        return workList;
    }
    
    public ArrayList<Work> getWorkListLastestFirstOrder() {
        ArrayList<Work> tempWorkList = this.workList;
        Collections.sort(tempWorkList, new Comparator<Work>(){

            @Override
            public int compare(Work o1, Work o2) {
                return o2.getCreatedOn().compareTo(o1.getCreatedOn());
            }
            
        });
        return tempWorkList;
    }

    public void setWorkList(ArrayList<Work> workList) {
        this.workList = workList;
    }
    
    public Work addNewWork(){
        Work work = new Work();
        this.workList.add(work);
        return work;
    }
    
    public Work createNewWork(int numberOfPeople, ClothesWorkRequest clothesWorkRequest, MedicalWorkRequest medicalWorkRequest ){
        neuServeUp = NEUServeUp.getInstance();
        Work work = new Work();
        work.setWorkId(helper.generateRandomLong());
        work.setNumberOfPeople(numberOfPeople);
        work.setClothesWorkRequest(clothesWorkRequest); 
        work.setMedicalWorkRequest(medicalWorkRequest); 
        work.setFiduciaryMedicalDecission(null); 
        work.setFiduciaryClothesDecission(null); 
        work.setClothesCostEstimate(null); 
        work.setMedicalCostEstimate(null); 
        work.setCreatedBy(neuServeUp.getuUser()); 
        work.setCreatedOn(helper.getCurrentTimeStamp()); 
        work.setUpdateOn(null);
        this.workList.add(work);
        return work;
    }
}
