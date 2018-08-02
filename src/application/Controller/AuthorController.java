package application.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import application.model.domain.Author;
import application.model.domain.LibrarySystemException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthorController {
	List<Author> list = new ArrayList<>();
	  @FXML
	   private TextField fname;
	  @FXML
	   private TextField lname;
	  @FXML
	   private TextField tel;
	  @FXML
	   private TextField street;
	  @FXML
	   private TextField state;
	  @FXML
	   private TextField zip;
	  @FXML
	   private TextField bio;
	  @FXML
	   private TextField isbn;
	  @FXML
	   private TextField title;
	  @FXML
	   private TextField length;
	  @FXML
	   private TextField city;
	  @FXML
	   private TextField num;
	  @FXML
		private Button addauthor;
	  @FXML
		private Button addbook;
	  
	  public void addBook() throws LibrarySystemException {
		  SystemController s =new SystemController();
		  int n = Integer.parseInt(num.getText());
		  s.addBook(isbn.getText(), title.getText(), n , list);
		  JOptionPane.showMessageDialog(null, "New Book "+title.getText()+" is Succesfully Added");
		   }
 public void addAuthor() {
	 SystemController s =new SystemController();
	 list =  s.addAuthor(fname.getText() ,lname.getText(),tel.getText(),street.getText(), city.getText(), state.getText(),zip.getText(),bio.getText());
	 JOptionPane.showMessageDialog(null, "Author "+fname.getText()+" is Added");
	 fname.clear();
	 lname.clear();
	 tel.clear();
	 street.clear();
	 city.clear();
	 state.clear();
	 zip.clear();
	 bio.clear();
	  }
}
