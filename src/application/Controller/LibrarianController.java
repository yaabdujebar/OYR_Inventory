package application.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LibrarianController {
	@FXML
	private TabPane rootLibrarianTab;
	
	@FXML
	private Button checkOutRecordButton;
	@FXML
	private Button overDueButton;
	
	
	@FXML
	private Button checkOutBookButton;
	
	
	
	


public void checkOutToConsole() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/Abbb.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Check Out To Console");
    SingleSelectionModel<Tab> selectionModel = rootLibrarianTab.getSelectionModel();
	
    selectionModel.select(tabA);
    rootLibrarianTab.getTabs().add(tabA);
	
}
public void chechOut() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/checkout.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Check out Record");
    SingleSelectionModel<Tab> selectionModel = rootLibrarianTab.getSelectionModel();
	
    selectionModel.select(tabA);
    rootLibrarianTab.getTabs().add(tabA);
	
}

public void overDue() {
	Tab tabA = new Tab();
	try {
	tabA.setContent(FXMLLoader.load(getClass().getResource("../UI/overDue.fxml")));
} catch (Exception e) {
    e.printStackTrace();
}
    tabA.setText("Over Due");
    SingleSelectionModel<Tab> selectionModel = rootLibrarianTab.getSelectionModel();
	
    selectionModel.select(tabA);
    rootLibrarianTab.getTabs().add(tabA);
}




}
