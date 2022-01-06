package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AddDriver;
import model.AddVehicle;

import java.util.ArrayList;

public class AddDriverController {
    public AnchorPane addDriverContext;


    public TextField txtDriverName;
    public TextField txtNic;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContactNo;

    static ArrayList<AddDriver> DriverList =new ArrayList<>();

    Stage stage;

    public void DriverAdd(ActionEvent actionEvent) {
        AddDriver addDriver= new AddDriver(txtDriverName.getText(), txtNic.getText(), txtLicenseNo.getText(),txtAddress.getText(),Integer.valueOf(txtContactNo.getText()));
        if (DriverList.add(addDriver)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
        }

        Stage stage = (Stage) addDriverContext.getScene().getWindow();
        stage.close();
    }

    public void moveNic(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveDrivingNo(ActionEvent actionEvent) { txtLicenseNo.requestFocus();}

    public void moveAddress(ActionEvent actionEvent) { txtAddress.requestFocus();}

    public void moveContact(ActionEvent actionEvent) { txtContactNo.requestFocus();}
}
