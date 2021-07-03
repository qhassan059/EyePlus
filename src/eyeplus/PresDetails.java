/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeplus;

/**
 *
 * @author Hassan Ahmed
 */
public class PresDetails {
    int pid;
    int cusId;
    String R_SPH;
    String L_SPH;
    String R_CYL;          
    String L_CYL ;
    String R_Axis ;
    String L_Axis  ;
    String R_VD     ;
    String L_VD      ;
    String R_NearAdd  ;
    String L_NearAdd   ;
    String R_VN ;
    String  L_VN          ;
    String Lens_type      ;
    String Lens_for       ;
    int Lens_price     ;
    int Frame_price    ;
    String Frame_type     ;
    int Paid_Amount    ;
    int  Total_Amount   ;
    int Pending_Amoun;
    //RSPH, LSPH, RCYL, LCYL, RAXIS, LAXIS, RVD, LVD, LNearAdd, RVN, LVN, LensType, LensFor, LensPrice, FramePrice, FrameType, PaidAmount, TotalAmount, PendingAmount

    public PresDetails(int cid, String R_SPH, String L_SPH, String R_CYL, String L_CYL, String R_Axis, String L_Axis, String R_VD, String L_VD, String R_NearAdd, String L_NearAdd, String R_VN, String L_VN, String Lens_type, String Lens_for, int Lens_price, int Frame_price, String Frame_type, int Paid_Amount, int Total_Amount, int Pending_Amoun) {
        this.pid = pid;
        this.cusId = cid;
        this.R_SPH = R_SPH;
        this.L_SPH = L_SPH;
        this.R_CYL = R_CYL;
        this.L_CYL = L_CYL;
        this.R_Axis = R_Axis;
        this.L_Axis = L_Axis;
        this.R_VD = R_VD;
        this.L_VD = L_VD;
        this.R_NearAdd = R_NearAdd;
        this.L_NearAdd = L_NearAdd;
        this.R_VN = R_VN;
        this.L_VN = L_VN;
        this.Lens_type = Lens_type;
        this.Lens_for = Lens_for;
        this.Lens_price = Lens_price;
        this.Frame_price = Frame_price;
        this.Frame_type = Frame_type;
        this.Paid_Amount = Paid_Amount;
        this.Total_Amount = Total_Amount;
        this.Pending_Amoun = Pending_Amoun;
    }
    
    public Object[] toArrays(){
        Object[] array = new Object[21];
        //array[0] = pid;
        array[0] = cusId;
        
        
        array[1]= R_SPH;
        array[2] = L_SPH;
        array[3] = R_CYL;
        array[4] = L_CYL;
        array[5] = R_Axis;
        array[6] = L_Axis;
        array[7] = R_VD;
        array[8] = L_VD;
        array[9] = R_NearAdd;
        array[10] = L_NearAdd;
        array[11] = R_VN;
        array[12] = L_VN;
        array[13] = Lens_type;
        array[14] = Lens_for;
        array[15] = Lens_price;
        array[16] = Frame_price;
        array[17] = Frame_type;
        array[18] = Paid_Amount;
        array[19] = Total_Amount;
        array[20] = Pending_Amoun;
        return array;
    }
}
