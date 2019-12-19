/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Work;

import Business.NUserAccount.NUser;

/**
 *
 * @author rwalawalkar
 */
public class FiduciaryClothesDecission {
    private String fiduciaryClothesDecission; // APPROVE REJECT OR NULL
    private String commentOnClothesByFiduciary;
    private NUser fiduciaryDecissionBy;

    public String getFiduciaryClothesDecission() {
        return fiduciaryClothesDecission;
    }

    public void setFiduciaryClothesDecission(String fiduciaryClothesDecission) {
        this.fiduciaryClothesDecission = fiduciaryClothesDecission;
    }

    public String getCommentOnClothesByFiduciary() {
        return commentOnClothesByFiduciary;
    }

    public void setCommentOnClothesByFiduciary(String commentOnClothesByFiduciary) {
        this.commentOnClothesByFiduciary = commentOnClothesByFiduciary;
    }
    
    public NUser getFiduciaryDecissionBy() {
        return fiduciaryDecissionBy;
    }

    public void setFiduciaryDecissionBy(NUser fiduciaryDecissionBy) {
        this.fiduciaryDecissionBy = fiduciaryDecissionBy;
    }
    
}
