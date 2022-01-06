package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InPark;
import model.OnDelivery;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.ParkFormController.inParkList;
import static controller.ParkFormController.onDeliveryList;
import static sun.plugin.javascript.navig.JSType.Window;

public class InParkFormController  {

    public AnchorPane inParkContext;
    public TableView tblVehiclePark;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleTy;
    public TableColumn colParkSlot;
    public TableColumn colParkedTime;
    public TableView tblLeaveVehicle;
    public TableColumn colLeftVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public ComboBox cmbParkIn;


    private String type="In Parking";

   public static ArrayList<InPark> inParkArrayList = inParkList;

   public static ArrayList<OnDelivery> onDeliveryArrayList= onDeliveryList;



    public void initialize() throws IOException {

        loadPark();
        colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("collectionOfVehicle"));
        colVehicleTy.setCellValueFactory(new PropertyValueFactory<>("VehicleTypePark"));
        colParkSlot.setCellValueFactory(new PropertyValueFactory<>("SlotNum"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("DateTime"));



        loadDelivery();
        colLeftVehicleNum.setCellValueFactory(new PropertyValueFactory<>("collectionOfVehicle"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("VehicleTypePark"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("namesOfDrivers"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("DateTime"));


        checkResultInComboBox();
        cmbParkIn.getItems().addAll("In Parking","On Delivery");
        cmbParkIn.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            type=String.valueOf(newValue);
                checkResultInComboBox();
                });
    }



    private void loadDelivery() {
        ObservableList<InPark> tmObservableList = FXCollections.observableArrayList();
        for (InPark temp : inParkArrayList) {
            tmObservableList.add(new InPark(temp.getCollectionOfVehicle(),temp.getVehicleTypePark(),temp.getSlotNum(),temp.getDateTime()));
        }
        tblVehiclePark.setItems(tmObservableList);

    }

    private void loadPark() {
        ObservableList<OnDelivery> tmObservableList = FXCollections.observableArrayList();
        for (OnDelivery temp : onDeliveryArrayList) {
            tmObservableList.add(new OnDelivery(temp.getCollectionOfVehicle(),temp.getVehicleTypePark(),temp.getNamesOfDrivers(),temp.getDateTime()));
        }
        tblLeaveVehicle.setItems(tmObservableList);
    }

    private void checkResultInComboBox() {
        if (type.equals("On Delivery")){
            tblVehiclePark.setVisible(false);
            tblLeaveVehicle.setVisible(true);
        }if (type.equals("In Parking")){
            tblVehiclePark.setVisible(true);
            tblLeaveVehicle.setVisible(false);
        }
    }


    public void goToAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Add Vehicle");
    }

    public void goToAddDrive(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Add Driver");

    }

    public void goToFirst(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) inParkContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkForm.fxml"))));
    }
}
