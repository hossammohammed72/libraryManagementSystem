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
public class Reader extends User {
    private String email,address; 
     public Reader(){
     super("reader");
     }
     public boolean checkEmail(String email){
    return userManager.available(email, "email", type);
     }
     public void setEmail(String email){
     if( !checkEmail(email)|| id != 0)
     this.email = email ;
     }
     public void setAddress(String address){
     this.address = address ;
     }
     public String getEmail(){
     return email ; 
     }
        public String getAddress(){
     return address ; 
     }
     public boolean isReady(){
     if(email != null && name != null && username != null && password != null && image != null && address != null)
         return true ; 
         return false ; 
     }
     public String toString(){
     return  this.id + "     "+this.address+"     "+this.email+"      "+this.image+"      "+this.name+"       "+this.password+"       "+this.username ;
     }
}
