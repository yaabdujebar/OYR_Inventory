package application.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;
import application.model.domain.Address;
import application.model.domain.Book;
import application.model.domain.BookCopy;
import application.model.domain.CheckOutRecordEntry;
import application.model.domain.LibraryMember;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ChechOutController implements Initializable{
		private ObservableList<CheckOutRecordEntry> checkData = FXCollections.observableArrayList();

	@FXML
	private TableView<CheckOutRecordEntry> table;
	private List<CheckOutRecordEntry> records;
	@FXML
	private TableColumn<CheckOutRecordEntry,String> isbncol; 
	@FXML
	private TableColumn<CheckOutRecordEntry,String> title;
	@FXML
	private TableColumn<CheckOutRecordEntry,String> date;
	
	@FXML
	private TableColumn<CheckOutRecordEntry,String> duedate;
	 @FXML
	   private Button checkButton;
	   
	   @FXML
	   private TextField memberId;
	  
	   
	   @FXML
	   private TextField isbn;
	   @FXML
	   private Text display;
	   
		
	   @FXML
	   public void check() {
		   DataAccess da = new DataAccessFacade();
           Book book = da.readABook(isbn.getText().trim());
          LibraryMember member = da.readAMember(memberId.getText().trim());
           System.out.println(book == null);
           System.out.println(member == null);
          if (book != null && member != null) {
               if (!book.getCopies().isEmpty()) {
            	   
              
                   BookCopy copy = book.getCopy();

                   CheckOutRecordEntry recordEntry = new CheckOutRecordEntry(copy, LocalDate.now(), LocalDate.now().plusDays(book.getCheckoutLength()));
                 
                  member.addEntryToRecord(recordEntry);
                 records = member.getRecords();
                 for(CheckOutRecordEntry c:records) {
                	 checkData.add(c);
                 }
                table.setItems(checkData);
                 display.setText( "Successfully Checked Out the book \"" + copy.getBook().getTitle() + "\" for " + member.getFirstName());
                          } else {
            	  display.setText( "No copy of this book ");
            	
               }
          }else if (book == null) {
        	  display.setText( "This book does not exist ");
        	
           } else if (member == null) {
              
        	   display.setText( "This member does not exist ");
        	   
          }
//      

	   }
	   
	   
	   @Override
		public void initialize(URL location, ResourceBundle resources) {
			isbncol.setCellValueFactory(calValue -> new SimpleStringProperty(calValue.getValue().getCopy().getBook().getISBN()));
			title.setCellValueFactory(calValue -> new SimpleStringProperty( calValue.getValue().getCopy().getBook().getTitle()));
			date.setCellValueFactory(calValue -> new SimpleStringProperty( calValue.getValue().getDateOfCheckOut().toString()));
			
			duedate.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getDueDate().toString()));
	        //street.setCellValueFactory(new PropertyValueFactory<Address, String>("street"));
			
	}
}
