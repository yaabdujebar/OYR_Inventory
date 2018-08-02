package application.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.JOptionPane;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;
import application.model.domain.LibraryMember;


public class RemoveMemberContoller {
	@FXML
	private Button removeButton;
	@FXML
	private TextField id;
	@FXML
	private Text display;
	
	public void removeMember() {
		
		DataAccess da = new DataAccessFacade();
		LibraryMember lm = da.removeMember(id.getText());
		SystemController s = new SystemController();
		if(lm!=null) {
		if(s.searchMember(id.getText())== null){
			display.setText("The member  "+lm.getFirstName()+"  is succsesfully removed");
		}else {
			display.setText("The member is NOT removed");
			
		}
	}else {
		display.setText("There is no such Member with this ID");
	}
}}
