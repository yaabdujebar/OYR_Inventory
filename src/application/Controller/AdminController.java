

package application.Controller;

import com.sun.javafx.scene.control.behavior.TabPaneBehavior;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class AdminController {
	@FXML
	private Button updateInfoButton;
	@FXML
	private Button displayInfoButton;
	@FXML
	private Button listBookButton;
	@FXML
	private Button listMemberButton;
	@FXML
	private Button add;
	@FXML
	private Button addNewMemberButton;
	@FXML
	private Button removeMemberButton;
	
	@FXML
	private Button addCopy;
	@FXML 
	private TabPane rootTab; 
	@FXML
	private Tab addBookTab;
	
	public void addNewBook() {
		Tab tabA = new Tab();
		try {
		tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/author.fxml")));
	} catch (Exception e) {
        e.printStackTrace();
    }
	    tabA.setText("Add New Book");
	    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
		
	    selectionModel.select(tabA);
	     rootTab.getTabs().add(tabA);
		
	}



public void addNewCopy() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/addcopy.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Add Copy");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
    

	
}

public void addNewMember() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/newmember.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Add New Member");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
	
}

public void removeMember() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/RemoveMember.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Remove Member");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
	
}

public void listBook() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/ListBook.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("List of books");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
	
}

public void listMember() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/ListMembers.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("List of Members");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    
    
       selectionModel.select(tabA);
    
     rootTab.getTabs().add(tabA);
	
}

public void displayInfo() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/Abbb.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Remove Member");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
	
}
public void updateInfo() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/Abbb.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Remove Member");
    SingleSelectionModel<Tab> selectionModel = rootTab.getSelectionModel();
	
    selectionModel.select(tabA);
     rootTab.getTabs().add(tabA);
	
}

}
