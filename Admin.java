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
public class Admin extends User {
    public Admin(){
        super("admin");
    }
   public boolean isReady(){
    if( name != null && username != null && password != null && image != null)
         return true ; 
         return false ; 
   }
}
