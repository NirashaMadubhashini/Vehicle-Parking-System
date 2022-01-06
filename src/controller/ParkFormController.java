package controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static controller.AddDriverController.DriverList;
import static controller.AddVehicleFormController.vehicleList;

public class ParkFormController {
    public AnchorPane parkContext;
    public ComboBox collectionOfVehicle;
    public ComboBox namesOfDrivers;
    public TextField txtVehicleTypePark;
    public TextField txtSlotNum;
    public TextField txtDateTime;


    static ArrayList<InPark> inParkList = new ArrayList<>();

    static ArrayList<OnDelivery> onDeliveryList = new ArrayList<>();

    static ArrayList<AddVehicle> addVehicleArrayList = vehicleList;

    static ArrayList<AddDriver> addDriverArrayList = DriverList;

    static int[] slot = new int[14];
    

    public JFXButton button1;
    public JFXButton button2;


    public void initialize() throws IOException {

        loadDriver();

        ObservableList<String> tmObservableList = FXCollections.observableArrayList();
        for (AddVehicle temp : addVehicleArrayList) {
            tmObservableList.add(temp.getAddVehicleNum());
        }
        collectionOfVehicle.setItems(tmObservableList);

        collectionOfVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String type = "none";
            for (AddVehicle temp1 : vehicleList
            ) {
                if (newValue.equals(temp1.getAddVehicleNum())) {
                    type = temp1.getVehicleAdd();
                }
            }
            txtVehicleTypePark.setText(type);
        });


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm a ");
        Date date = new Date();
        txtDateTime.setText(formatter.format(date));

        InParkFormController.onDeliveryArrayList = onDeliveryList;
        InParkFormController.inParkArrayList = inParkList;



    }


    private void loadDriver() throws IOException {
        ObservableList<String> tmObservableList = FXCollections.observableArrayList();
        for (AddDriver temp : addDriverArrayList) {
            tmObservableList.add(temp.getDriverName());
        }
        namesOfDrivers.setItems(tmObservableList);
    }


    public void logToParkVehicle(ActionEvent actionEvent) throws IOException {
        button1.setDisable(false);
        button2.setDisable(true);

        if (collectionOfVehicle.getValue().equals(null) && namesOfDrivers.getValue().equals(null)) {
            new Alert(Alert.AlertType.WARNING, "Pick Up vehicle Number", ButtonType.CLOSE).show();
        } else {
            check(txtVehicleTypePark.getText());
            onDeliveryList.removeIf(temp2 -> collectionOfVehicle.getSelectionModel().getSelectedItem().toString().equals(temp2.getCollectionOfVehicle()));
            inParkList.add(new InPark(collectionOfVehicle.getValue().toString(), txtVehicleTypePark.getText(), txtSlotNum.getText(), txtDateTime.getText()));
        }
        System.out.println(inParkList);
    }

    private void check(String text) {
        if (text.equalsIgnoreCase("Bus")) {
            if (slot[13] == 14) {
                new Alert(Alert.AlertType.WARNING, "Can't be park", ButtonType.CLOSE).show();
            } else {
                txtSlotNum.setText("14");
                slot[13] = 14;
            }
        } else if (text.equalsIgnoreCase("Van")) {
            if (slot[0] == 0) {
                txtSlotNum.setText("1");
                slot[0] = 1;
            } else if (slot[1] == 0) {
                txtSlotNum.setText("2");
                slot[1] = 2;
            } else if (slot[2] == 0) {
                txtSlotNum.setText("3");
                slot[2] = 3;
            } else if (slot[3] == 0) {
                txtSlotNum.setText("4");
                slot[3] = 4;
            } else if (slot[11] == 0) {
                txtSlotNum.setText("12");
                slot[11] = 12;
            } else if (slot[12] == 0) {
                txtSlotNum.setText("13");
                slot[12] = 13;
                new Alert(Alert.AlertType.WARNING, "Can't be park", ButtonType.CLOSE).show();
            }
        } else if (text.equalsIgnoreCase("Cargo Lorry")) {
            if (slot[4] == 0) {
                txtSlotNum.setText("5");
                slot[4] = 5;
            } else if (slot[5] == 0) {
                txtSlotNum.setText("6");
                slot[5] = 6;
            } else if (slot[6] == 0) {
                txtSlotNum.setText("7");
                slot[6] = 7;
            } else if (slot[7] == 0) {
                txtSlotNum.setText("8");
                slot[7] = 8;
            } else if (slot[8] == 0) {
                txtSlotNum.setText("9");
                slot[8] = 9;
            } else if (slot[9] == 0) {
                txtSlotNum.setText("10");
                slot[9] = 10;
            } else if (slot[10] == 0) {
                txtSlotNum.setText("11");
                slot[10] = 11;
                new Alert(Alert.AlertType.WARNING, "Can't be park", ButtonType.CLOSE).show();
            }
        }
    }

    public void logToDilivery(ActionEvent actionEvent) throws IOException {
        button1.setDisable(true);
        button2.setDisable(false);

        if (collectionOfVehicle.getValue().equals("null") && namesOfDrivers.getValue().equals("null")) {
            new Alert(Alert.AlertType.WARNING, "Pick Up vehicle Number", ButtonType.CLOSE).show();
        } else {
            inParkList.removeIf(temp3 -> collectionOfVehicle.getSelectionModel().getSelectedItem().toString().equals(temp3.getCollectionOfVehicle()));
            onDeliveryList.add(new OnDelivery(collectionOfVehicle.getValue().toString(), txtVehicleTypePark.getText(), namesOfDrivers.getValue().toString(), txtDateTime.getText()));
        }
        System.out.println(onDeliveryList);
    }

    public void logToManagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogInForm.fxml"));
        Parent parent = loader.load();
        LoginFormController controller = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        controller.closeStage(parkContext);
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void setType(ActionEvent actionEvent) {
       if (checkParkList()==1){
           getType();
           button1.setDisable(true);
           button2.setDisable(false);
      }else {
           getType();
           button2.setDisable(true);
           button1.setDisable(false);
       }
        System.out.println(txtVehicleTypePark.getText());
    }

//    private int checkOnDeliverList() {
//        int i=0;
//        for (OnDelivery t1 : onDeliveryList) {
//            if (collectionOfVehicle.getValue().equals(t1.getCollectionOfVehicle())) {
//               i=1;
//            }
//        }
//        return i;
//    }

    private int checkParkList() {
        int i = 0;
        for (InPark temp : inParkList) {
            if (collectionOfVehicle.getValue().equals(temp.getCollectionOfVehicle())) {
                i = 1;
            }
        }
        return i;
    }

    private void getType() {
        for (AddVehicle t : addVehicleArrayList) {
            if (collectionOfVehicle.getValue().equals(t.getAddVehicleNum())) {
                txtVehicleTypePark.setText(t.getVehicleAdd());
            }
        }
    }
 }
