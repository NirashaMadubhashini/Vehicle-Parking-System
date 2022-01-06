package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginFormContext;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public AnchorPane parkContext;


    public void closeStage(AnchorPane parkContext) {
        this.parkContext = parkContext;
    }

    Stage stage;

    public void backToPark(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) loginFormContext.getScene().getWindow();
        stage.close();
    }

    public void logInParking(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) parkContext.getScene().getWindow();
        stage.close();
        if (txtUserName.getText().equalsIgnoreCase("User") && txtPassword.getText().equals("1234")) {
            Stage window = (Stage) loginFormContext.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InParkForm.fxml"))));
            window.setTitle("Parking System");
        } else {
            new Alert(Alert.AlertType.WARNING, "Incorrect User Name, Password. Try again..", ButtonType.CLOSE).show();
        }
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
