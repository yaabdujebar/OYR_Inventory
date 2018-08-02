package application.Controller;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;	
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LibraryController {
	@FXML
	private Button closeButton;
	@FXML
	private Button btnLogin;
	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField txtPassword;
	
	private LoginController loginController = new LoginController();

	public void loginClicked() {
		System.out.println("Login Button Clicked");
		String userName = txtUserName.getText();
		String password = txtPassword.getText();
		System.out.println("Credentials: " + userName + " " + password);
		
	String user = loginController.login(userName, password ,btnLogin);
	System.out.println(user);
	if(user.equalsIgnoreCase("librarian")) {
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../UI/Librarian.fxml"));
		Parent root1=(Parent)fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Librarian Window");
		stage.setScene(new Scene(root1));
		stage.setMaximized(true);
		stage.show();
		 Stage stage1 = (Stage) closeButton.getScene().getWindow();
 	    stage1.close();
		}catch(Exception e) {
			
		}
		}/*else if(user.equalsIgnoreCase("No such user exists")) {
			 txtUserName.clear();
			 txtPassword.clear();
			JOptionPane.showMessageDialog(null," There is no such user in the System");
			
		}
	else if(user.equalsIgnoreCase("Wrong password")) {
		 txtPassword.clear();
		JOptionPane.showMessageDialog(null," Wrong Password");
		
	}*/else {
			try {
				System.out.println(user);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//UI/Admin.fxml"));
				Parent root1=(Parent)fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Administrator Window");
				stage.setScene(new Scene(root1));
				stage.setMaximized(true);
				stage.show();
				 Stage stage2 = (Stage) closeButton.getScene().getWindow();
		    	    stage2.close();
				}catch(Exception e) {
					
				}
			
		}
		
	}
	
	@FXML
    public void cancelClicked() {
    	 Stage stage = (Stage) closeButton.getScene().getWindow();
    	    stage.close();
    }
	
	
	@FXML
	public void txtUserNameFocusLost() {
		System.out.println("UserName Field Focus Lost");
	}

	@FXML
	public void txtPasswordFocusLost() {
		System.out.println("Password Field Focus Lost");
	}
}
