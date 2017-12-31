/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagmentsystem;

/**
 *
 * @author hossam
 */
public class Librarian extends User {
    private String address ;
    private int salary;
    private long IDnumber ; 
     public Librarian(){
        super("librarian");
    } 
    public String getAddress(){
        return address ; 
     }
    public int getSalary(){
        return salary ; 
     }
    public void setSalary(int salary){
     this.salary = salary ; 
    }
    public void setAddress(String address){
     this.address = address ; 
    }
   public boolean isReady(){
    if( name != null && username != null && password != null && image != null)
        return true ; 
        return false ; 
    }
        

}
