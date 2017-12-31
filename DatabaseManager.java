/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
+ setters and input validation what should function if the input is refuesd 
= exceptions what to do 
*/
package librarymanagmentsystem;
import java.sql.*; 

/**
 *
 * @author root
 */
public class DatabaseManager {
private Connection myConnection = null ; 
private PreparedStatement prepStmt = null ; 
private ResultSet resultSet = null ; 
    public DatabaseManager(){
        try{
        myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
        }catch(Exception ex){
            System.out.println("msh hopa tmam");
        }
    }
    public boolean available(String param,String column,String type){
       try{
           prepStmt = myConnection.prepareStatement("SELECT * FROM " +type+" where "+column+" = ?");
          prepStmt.setString(1,param);
            resultSet = prepStmt.executeQuery();
            boolean valid = false  ; 
            if(resultSet.next())
                valid = true  ; 
            return valid ; 
       }catch(SQLException e){
            e.printStackTrace();
       return true  ; 
       }
   
    }
    public Book searchBook(String title){
        Book res  = new Book();
        try{
            
            prepStmt  = myConnection.prepareStatement("SELECT * FROM books WHERE title LIKE ?");
            prepStmt.setString(1, title+'%');
           resultSet = prepStmt.executeQuery();
           if(resultSet.next()){
           res.setId(resultSet.getInt("id"));
           res.setISBN(resultSet.getLong("ISBN"));
           res.setAuthor(resultSet.getString("author"));
           res.setDescription(resultSet.getString("description"));
           res.setImage(resultSet.getString("image"));
           res.setBookPos(resultSet.getInt("bookPos"));
           res.setShelfNum(resultSet.getInt("shelfNum"));
           
           }
        }catch(SQLException e){
        e.printStackTrace();
        }
        return res ; 
    }
    public boolean authenticateUser(String type ,String username,String password,User user ){
        try{
            prepStmt = myConnection.prepareStatement("SELECT * FROM "+type+" where username =  ? AND password = ? ");
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()){
               user.setId(resultSet.getInt("id"));
               user.setName(resultSet.getString("name"));
               user.setUsername(username);
               user.setImage(resultSet.getString("image"));
               if(type =="reader"){
               ((Reader) user).setEmail(resultSet.getString("email"));
               ((Reader) user).setAddress(resultSet.getString("Address"));
               }
                    return true ; 
            }else {
                return false ; 
            }
        } catch(SQLException e){
        e.printStackTrace();
        return false ; 
        }
        }       
   public void insert(Reader reader){
       try{
        prepStmt = myConnection.prepareStatement("INSERT INTO reader (email,address,name,username,password,image)VALUES"
                + " (?,?,?,?,?,?) ");
        prepStmt.setString(1, reader.getEmail());
        prepStmt.setString(2, reader.getAddress());
        prepStmt.setString(3, reader.getName());
        prepStmt.setString(4, reader.getUsername());
        prepStmt.setString(6, reader.getImage());
        prepStmt.setString(5, reader.getHashedPassword());
        prepStmt.execute();
        
       }catch(SQLException e){
       e.printStackTrace();
       } 
   } 
   public void insert(Admin admin){
   }
   public void insert(Librarian librarian){
   }
 
}
