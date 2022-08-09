package logic.controller.guicontroller.first.general.registration;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import logic.controller.applicationcontroller.RegisterController;
import logic.controller.applicationcontroller.ViewController;
import logic.controller.guicontroller.AlertGUI;
import logic.engineeringclasses.bean.UserBean;
import logic.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static logic.controller.guicontroller.first.general.Main1GUI.firstBorder;

public class RegisterGUI implements Initializable{
	 
	private final RegisterController registerController = new RegisterController();
	private final ViewController viewController = new ViewController();
	private final AlertGUI alertGUI = new AlertGUI();

	@FXML private TextField tfname;
	@FXML private TextField tfsurname;
	@FXML private TextField tfemail;
	@FXML private PasswordField tfpassword;
	@FXML private PasswordField tfokpwd;
	@FXML private ComboBox<String> rolebox;
    @FXML private ComboBox<String> addressbox;

	@FXML private void onSignClick() {
		Pane pane = viewController.getPage("Login",1);
		firstBorder.setCenter(pane);
    }

    @FXML
    void onSignupClick() throws IOException, SQLException {
    	UserBean bean = getUsrBean(tfname.getText(), tfsurname.getText(), tfemail.getText(), tfpassword.getText(), tfokpwd.getText(), rolebox.getValue(), addressbox.getValue());
		if(registerController.registration(bean)){
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/logic/view/first/SelectApartmentDialog.fxml"));
			DialogPane pane = loader.load();
			SelectApartmentDialogGUI apt = loader.getController();
			ObservableList<String> list = registerController.loadAddress(bean);
			apt.setUp(list,bean);
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(pane);
			Optional<ButtonType> btn = dialog.showAndWait();
			if(btn.isPresent() && btn.get() == ButtonType.OK && !apt.getApt().isEmpty()) {
				for(String aptName : apt.getApt()){
					String name = bean.getUsrName() +" "+ bean.getUsrSurname();
					User user = new User(null,name,bean.getUsrEmail(),bean.getUsrPwd(),bean.getUsrAddr());
					registerController.addRegistrationUser(user,bean.getUsrRole().toUpperCase(),aptName);
				}
				alertGUI.alertInfo("Condominium/Register/Info","Successful Registration" ,
						"Your request has successfully sent to the administrator of the condominium");
				clearState();
			}
		}else{
			alertGUI.alertError("Condominium/Register/Error","Incorrect Data","ERROR TYPE:\nDATABASE NOT CONNECTED\nEmpty Fields\nPASSWORD:least one letter and one number maximum 15 charters\nPassword mismatch");
		}
    }

    public UserBean getUsrBean(String name, String surname, String email, String password, String okPassword, String role, String condominiumCode){
		UserBean user = new UserBean();
		user.setUsrName(name);
		user.setUsrSurname(surname);
		user.setUsrEmail(email);
		user.setUsrPwd(password);
		user.setUsrRole(role);
		user.setOkPassword(okPassword);
		user.setUsrAddr(condominiumCode);
		return user;
	}

    private void clearState() {
    	tfname.setText("");
    	tfsurname.setText("");
    	tfemail.setText("");
    	tfpassword.setText("");
    	tfokpwd.setText("");
    	rolebox.setValue(null);
    	addressbox.setValue(null);
    }

    private void setUp() {
    	rolebox.getItems().addAll("Resident","Owner");
    }

    @Override
   	public void initialize(URL location, ResourceBundle resources){
       	setUp();
       	try {
			 addressbox.setItems(registerController.loadAddresses());
		 }catch(Exception e) {
			 alertGUI.alertError("DATA BASE ERROR","DATA BASE not connected ","Please Restart the Application");
			 Platform.exit();
		 }
    }
}


    

	
    
