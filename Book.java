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
public class Book {
   private int id=0,shelfNum,bookPos;
   private long ISBN ; 
   private String title,description,author,image;
   public void setTitle(String title){
   this.title = title ; 
   }
   public void setAuthor(String author ){
   this.author = author ; 
   }
   public void setImage(String image){
   this.image = image ; 
   }
   public void setDescription(String description){
   this.description = description ; 
   }
   public void setISBN(long ISBN){
   this.ISBN= ISBN ; 
   }
   public void setId(int id){
   this.id = id ; 
   }
   public void setShelfNum(int shelfNum){
   this.shelfNum = shelfNum ; 
   }
   public void setBookPos(int bookPos){
   this.bookPos = bookPos ; 
   }
    public String getAuthor() {
        return author;
    }
    public int getBookPos() {
        return bookPos;
    }
    public String getDescription() {
        return description;
    }
    public long getISBN() {
        return ISBN;
    }
    public int getId() {
        return id;
    }
    public String getImage() {
        return image;
    }
    public int getShelfNum() {
        return shelfNum;
    }
    public String getTitle() {
        return title;
    }
}
