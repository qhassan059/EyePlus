/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeplus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseConn {
    Connection con ;
    ResultSet result_cust ;
    ResultSet result_prec ;
    Statement stmt;
    
    
    public void getConnection(){
        try{
            System.out.println("hello");
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Optix","root","root");
            stmt=con.createStatement();
            
//            result_cust = stmt.executeQuery("select * from customer_details");
//            //result_prec = stmt.executeQuery("select * from prescription");
//            while (result_cust.next()) {
//                System.out.println(result_cust.getInt(1)+"  "+result_cust.getString(2)+"  "+result_cust.getString(3));
//            }
//            result_cust.close();
//            con.close();

        }
        catch (Exception e){
                System.out.println(e.getMessage());
        }
        
    }
    public CustomerDetails getLast(){
        getConnection();
        
        try{
            ResultSet rs = stmt.executeQuery("Select * from customer_details order by customer_id desc limit 1");
            if(rs.next()){
                return new CustomerDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ArrayList<PresDetails> getDataFromPres(){
        getConnection();
        ArrayList<PresDetails> pres = new ArrayList<>();
        try{
            ResultSet rs = stmt.executeQuery("Select * from Prescription");
            while(rs.next()){
                pres.add(new PresDetails(rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getInt(17),rs.getInt(18),rs.getString(19),rs.getInt(20),rs.getInt(21),rs.getInt(22)));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pres;
    }
    
    public ArrayList<CustomerDetails> getDataFromCus(){
        ArrayList <CustomerDetails> customers = new ArrayList<>();
        getConnection();
        try{
            ResultSet rs = stmt.executeQuery("Select * from customer_details");
          
            while(rs.next()){
                   CustomerDetails cus  = new CustomerDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                   customers.add(cus);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return customers;
        
    }
    
    
    public void insertCus(String CusName, String ContactNumber, int Age, String Address,String gender){
        getConnection();
        try{
            String query = "Insert into customer_details(cust_name, contact_num, age, address, gender) values (?, ? , ? , ? , ?) ";
            PreparedStatement prst = con.prepareStatement(query);
            //prst.setInt(1, 3);
            prst.setString(1, CusName);
            prst.setString(2, ContactNumber);
            prst.setInt(3, Age);
            prst.setString(4, Address);
            prst.setString(5, gender);
            int a = prst.executeUpdate();
            if(a > 0){
                JOptionPane.showMessageDialog(null, "Record is added Successfully...");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "InsertMethod"+e);
        }
        
    }
    public void delete(int id){
        getConnection();
        try{
            
            int a = stmt.executeUpdate("Delete from customer_details where customer_id = '"+id+"'");
            if(a > 0){
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            }
            else
                JOptionPane.showMessageDialog(null, "Not Deleted");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertPresc(PresDetails pres){
        getConnection();
        try{
          
            String query = "Insert into Prescription(R_SPH, L_SPH,R_CYL, L_CYL, R_Axis, L_Axis, R_VD, L_VD, R_NearAdd, L_NearAdd,  R_VN, L_VN, Lens_type, Lens_for, Lens_price, Frame_price, Frame_type, Paid_Amount, Total_Amount, Pending_Amount) values(?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement prst = con.prepareStatement(query);
            
            prst.setString(1, pres.R_SPH);
            prst.setString(2, pres.L_SPH);
            prst.setString(3, pres.R_CYL);
            prst.setString(4, pres.L_CYL);
            prst.setString(5, pres.R_Axis);
            prst.setString(6, pres.L_Axis);
            prst.setString(7, pres.R_VD);
            prst.setString(8, pres.L_VD);
            prst.setString(9, pres.R_NearAdd);
            prst.setString(10, pres.L_NearAdd);
            prst.setString(11, pres.R_VN);
            prst.setString(12, pres.L_VN);
            //Lens_type, Lens_for, Lens_price, Frame_price, Frame_type, Paid_Amount, Total_Amount, Pending_Amount
            
            prst.setString(13, pres.Lens_type);
            prst.setString(14, pres.Lens_for);
            prst.setInt(15, pres.Lens_price);
            prst.setInt(16, pres.Frame_price);
            prst.setString(17, pres.Frame_type);
            prst.setInt(18, pres.Paid_Amount);
            prst.setInt(19, pres.Total_Amount);
            prst.setInt(20, pres.Pending_Amoun);
            
            
            
            //prst.setInt(0, 0);
            
            int a = prst.executeUpdate();
            if(a > 0){
                JOptionPane.showMessageDialog(null, "Added");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void deletePres(int id){
        getConnection();
        try{
            String query = "Delete from prescription where customer_id ="+id+"'";
            int a = stmt.executeUpdate(query);
            if(a > 0){
                JOptionPane.showMessageDialog(null, "Deleted Successfully...");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    public DatabaseConn(){
        
    }
}
