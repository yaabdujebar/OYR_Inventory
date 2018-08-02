package application.Controller;


import application.model.domain.Book;
import application.model.domain.LibrarySystemException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;



public class AddCopyController {
	private Book book1;
   @FXML
   private Button addButton;
   
   @FXML
   private TextField isbn;
   @FXML
   private TextField nameofthebook;
   @FXML
   private TextField numberOfCopy;
   
   @FXML
   private TextField numOfCopy;
   @FXML
   private Text display;
   
   
   public void add() throws LibrarySystemException {
	  SystemController sc = new SystemController();
      book1 = sc.addCopyBook(isbn.getText(),numOfCopy.getText());
      if(book1!=null) {
	   nameofthebook.setText(book1.getTitle()+"");
	   numberOfCopy.setText(book1.getnumCopies()+"");
      }else {
    	  display.setText("Book is not found");
      }
   }
}
