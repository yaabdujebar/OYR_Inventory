package application.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.model.domain.Address;
import application.model.domain.LibraryMember;
import application.model.domain.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;


public class ListMemberController implements Initializable {
	private ObservableList<LibraryMember> memberData = FXCollections.observableArrayList();

	@FXML
	private TableView<LibraryMember> tableMember;
	private List<LibraryMember> members;
	@FXML
	private TableColumn<LibraryMember,String> id; 
	@FXML
	private TableColumn<LibraryMember,String> fName;
	@FXML
	private TableColumn<LibraryMember,String> lName;
	
	@FXML
	private TableColumn<Address,String> street;
	@FXML
	private TableColumn<LibraryMember,String> telephone;
	
	public void showList() {
		SystemController sm = new SystemController();
	
		members = sm.listAllMembers();
		
		for(LibraryMember m:members) {
			memberData.add(m);
			
			
		}
		System.out.println(memberData);
	
        tableMember.setItems(memberData);
	}

//	private ObservableList<LibraryMember> getPersonData() {
//		
//		return memberData;
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("memberId"));
		fName.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstName"));
		lName.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastName"));
		
		telephone.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("telephone"));
        //street.setCellValueFactory(new PropertyValueFactory<Address, String>("street"));
		
	}
}
