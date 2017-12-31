/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hossam
 */
import librarymanagmentsystem.*;

public class Test {
    public static void main(String[] args){
        try{
            Reader myUser = new Reader();
            System.out.println(myUser.toString());
            DatabaseManager testManager = new DatabaseManager();
            if(testManager.authenticateUser("reader", "what", User.getSecurePassword("123456"), myUser))
                System.out.println(myUser.toString());
            else {
                System.out.println("l2 msh naf3");
                System.out.println(User.getSecurePassword("123456"));
                System.out.println(myUser.toString());
            }
//            if(!myUser.checkUsername("hoho"))
//                myUser.setUsername("hoho");
//           else 
//                System.out.println("m7slsh l2");
//           if(!myUser.checkEmail("momo"))
//               myUser.setEmail("mom");
//           else 
//                 System.out.println("email already available");
//            myUser.setPassword("123456");
//            myUser.setName("Hossam");
//            myUser.setAddress("share3 l tlevsion");
//            if(myUser.isReady())
//               testManager.insert(myUser);
//            else{ 
//            System.out.println("la msh gahzen");
//            }
//          System.out.println(myUser.toString());
        }catch(Exception e){
        e.printStackTrace();
        }
            
    }
}
