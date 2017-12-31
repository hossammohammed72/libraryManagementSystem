/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagmentsystem;
import java.security.MessageDigest ; 
import java.security.SecureRandom ; 
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 *
 * @author hossam
 */  
public abstract class User  {
  private boolean ready = false ; 
  protected int id ; 
 protected DatabaseManager userManager; 
  protected String name,username,password,image,type;
  public User(String type) { 
      this.type = type ;   
      image = "img\\default.png";
      userManager = new DatabaseManager();
         
  };
  public void setId(int id){
  this.id = id ; 
  }
  public String getUsername(){return username ; }
  public boolean checkUsername(String username){
  return userManager.available(username,"username",type);
  }
  public void setUsername(String username){
 if(!checkUsername(username) || id != 0)
     this.username = username ;  
  }
  public void  setPassword(String password){
    this.password= getSecurePassword(password);
  }
  
 public String getName(){
 return name; }
 
 public String getImage(){
 return image; }
  
 public void setName(String name){
 this.name = name ;  }
 public void setImage(String image){
 this.image = image ;  }
   public static  String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
           // System.out.println(salt.toString().length());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
            
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     public String getHashedPassword(){
         return password ; 
     }
     public abstract boolean isReady();
}
