package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.AddVehicle;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class AddVehicleFormController {
    public AnchorPane addVehicleFormContext;
    public TextField txtAddVehicleNum;
    public TextField txtAddMaxWeight;
    public TextField txtAddNoPassenger;
    public ComboBox vehiclesAddToBe;


    static ArrayList<AddVehicle> vehicleList =new ArrayList();

    public void initialize(){
        vehiclesAddToBe.getItems().addAll("Bus","Van","Cargo Lorry");
    }


    Stage stage;

    public void vehicleAdd(ActionEvent actionEvent) throws IOException {
        AddVehicle addVehicle = new AddVehicle(txtAddVehicleNum.getText(), Integer.valueOf(txtAddMaxWeight.getText()), Integer.valueOf(txtAddNoPassenger.getText()),vehiclesAddToBe.getValue().toString());
        if (vehicleList.add(addVehicle)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
        }


        Stage stage = (Stage) addVehicleFormContext.getScene().getWindow();
        stage.close();

    }


    public void moveWeight(ActionEvent actionEvent) {
        txtAddMaxWeight.requestFocus();
    }

    public void movePassengers(ActionEvent actionEvent) { txtAddNoPassenger.requestFocus();}
    }


