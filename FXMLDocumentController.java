/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagmentsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author hossam
 */
public class FXMLDocumentController implements Initializable {
   DatabaseManager dataManager ; 
    ObservableList<String> userType = FXCollections.observableArrayList("reader","librarian","admin"); 
    @FXML
    TextField username ;
    @FXML
    AnchorPane searchResult ;  
    @FXML 
    PasswordField password ;
    @FXML 
    ComboBox menu ;
    @FXML
    AnchorPane main ; 
    @FXML 
    AnchorPane loginAnchor ; 
    @FXML 
    TextField search ; 
    @FXML
    ImageView bookImage ;
    @FXML
    Button searchButton ;
    @FXML 
    Label bookTitle ; 
    @FXML 
    Label bookDescription;
    @FXML 
    Label bookPosition ; 
    @FXML
    Label bookAuthor ; 
//    @FXML 
//    CheckBox readerCheck ; 
//    @FXML 
//     CheckBox librarianCheck ; 
//    @FXML 
//     CheckBox adminCheck ; 
    @FXML
    Label alarm,welcome;
    @FXML
    private void handleButtonAction() {
        if(!username.getText().isEmpty() && !password.getText().isEmpty()  ){
          String type = menu.getValue().toString();
          User loggedUser ;
          if(type == "reader")
          loggedUser = new Reader();
          else if (type == "librarian")
          loggedUser = new Librarian(); 
          else 
          loggedUser = new Admin();
          if(dataManager.authenticateUser(type, username.getText(),User.getSecurePassword(password.getText()),loggedUser)){
                System.out.println(loggedUser.toString());
                loginAnchor.setVisible(false);
                search.setVisible(true);
                searchButton.setVisible(true);
                
          }else 
              alarm.setText("wrong username or password");
          
          
          
        }else{
        alarm.setText("please complete the form values ");
        }
        
    }
    @FXML
    private void handleStuff(){
    System.out.println("ok 7lw keda");    
    } 
    @FXML 
    private void search(){
     if(!search.getText().isEmpty() )  {
             Book resultBook = dataManager.searchBook(search.getText());
             searchResult.setVisible(true);
             Image img;
             if( resultBook.getId() !=0){
             img = new Image(getClass().getResourceAsStream(resultBook.getImage()));
            bookTitle.setText(search.getText());
            bookDescription.setText(resultBook.getDescription());
            bookAuthor.setVisible(true);
            bookAuthor.setText("Author: "+resultBook.getAuthor());
            bookPosition.setText("ISBN: "+resultBook.getISBN());
            
             }else {
              img = new Image(getClass().getResourceAsStream("img/oops.png") );
             bookTitle.setText("book not found");
             bookDescription.setText("make sure you type the book title correctly");
             bookPosition.setText("make sure you type the book title correctly");

             }
            bookImage.setImage(img);
       }else {
         search.setPromptText("please enter a title to search first");
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    menu.setValue("reader");
    menu.setItems(userType);
    dataManager = new DatabaseManager();
 //   dashboard.setVisible(false);
    search.setVisible(false);
    bookAuthor.setVisible(false);
    searchResult.setVisible(false);
    searchButton.setVisible(false);
    }    
    
}
