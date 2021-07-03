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
public class CustomerDetails {
    int id;
    String cusName;
    String cusCon;
    String address;
    int age;
    String gender;
    
    CustomerDetails(int id, String cusName, String cont, int age, String address, String gen){
        this.id = id;
        this.cusName = cusName;
        this.address = address;
        this.cusCon = cont;
        this.gender = gen;
        this.age = age;
    }
    public Object[] toArray(){
        Object[] array = new Object[6];
        array[0] = id;
        array[1] = cusName;
        array[2] = cusCon;
        array[3] = age;
        array[4] = address;
        array[5] = gender;
        return array;
    } 
    public static void main(String[] arf){
        DatabaseConn con = new DatabaseConn();
        con.delete(15);
    }
    
}
