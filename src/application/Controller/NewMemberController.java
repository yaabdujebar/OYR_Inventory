package application.Controller;


import javax.swing.JOptionPane;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;
import application.model.domain.LibrarySystemException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class NewMemberController {
	
	@FXML
	private Button summitButton;
    
	@FXML
	private TextField memberId;
	@FXML
	private TextField fName;
	
	@FXML
	private TextField lName;
	@FXML
	private TextField street;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField zip;
	@FXML
	private TextField telphone;
	
	@FXML
	private Text display;
	
	public void submit() throws LibrarySystemException {
		
		
		SystemController sm = new SystemController();
		
	 boolean b = sm.addMember(memberId.getText(), fName.getText(), lName.getText(), telphone.getText(), street.getText(), city.getText(), state.getText(), zip.getText());
       
            if(b){
	    	  display.setText("New Member "+fName.getText()+"succesfully added");
	      }else {
	    	  display.setText("Sorry member are not added");
	      }
	    	  
	}
	
	
}
