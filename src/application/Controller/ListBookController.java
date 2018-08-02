package application.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;
import application.model.domain.Book;
import application.model.domain.LibraryMember;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListBookController implements Initializable{
	private ObservableList<Book> bookData = FXCollections.observableArrayList();

	@FXML
	private TableView<Book> table;
	private List<Book> books;
	@FXML
	private TableColumn<Book,String> isbn; 
	@FXML
	private TableColumn<Book,String> title;
//	@FXML
//	private TableColumn<Book,String> num;
	@FXML
	private TableColumn<Book,String> max;
	@FXML
	private Button showlist;
	
	public void showList() {
		SystemController sm = new SystemController();
		books = sm.listAllBooks();
		System.out.println(books);
		
		for(Book b:books) {
			bookData.add(b);
		}
		System.out.println(bookData);
		 table.setItems(bookData);
	}
	  @Override
			public void initialize(URL location, ResourceBundle resources) {
				isbn.setCellValueFactory(calValue -> new SimpleStringProperty(calValue.getValue().getISBN()));
				title.setCellValueFactory(calValue -> new SimpleStringProperty( calValue.getValue().getTitle()));
				//num.setCellValueFactory(calValue -> new SimpleStringProperty( calValue.getValue().getnumCopies()+""));
				
			max.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getCheckoutLength()+""));
		        //street.setCellValueFactory(new PropertyValueFactory<Address, String>("street"));
				
		}
}
