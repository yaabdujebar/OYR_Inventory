package application.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.sun.glass.ui.Window.Level;
//import com.sun.istack.internal.logging.Logger;

import application.model.dataaccess.Auth;
import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;
import application.model.domain.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

	List<User> users;
	//LibraryController l = new LibraryController();
	public LoginController() {
		users = allusers();
	}
	
	public static List<User> allusers() {
		DataAccess da = new DataAccessFacade();
		Collection<User> members = da.readUserMap().values();
		List<User> mems = new ArrayList<>();
		mems.addAll(members);
		
			return mems;
		}
	
	
	public String login(String userName, String password, Button btnLogin) {
		Optional<User> optionalUser = users.stream().filter(u -> u.getId().equals(userName)).findAny();
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			if(password.equals(user.getPassword())) {
				if(Auth.LIBRARIAN.equals(user.getAuthorization())) {
					System.out.println("Congratulations ADMIN");
					return "librarian";
					  
					// call admin window passing user-object
				}else {
					System.out.println("Congratulations USER");
					return "admin";
				}
			}else {
				
				System.out.println("Wrong password");
				return "wrong password";
				
			}
		}else {
			
			System.out.println("No such user exists...");
			return "No such user exists";
		}
	}

}
