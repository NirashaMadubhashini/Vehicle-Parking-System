package model;

import javafx.scene.control.TextField;

public class AddVehicle {
    private String AddVehicleNum;
    private int AddMaxWeight;
    private int AddNoPassenger;
    private String vehicleAdd;

    public AddVehicle(TextField txtVehicleTypePark, TextField txtSlotNum) {
    }

    public AddVehicle(String addVehicleNum, int addMaxWeight, int addNoPassenger, String vehicleAdd) {
        setAddVehicleNum(addVehicleNum);
        setAddMaxWeight(addMaxWeight);
        setAddNoPassenger(addNoPassenger);
        this.setVehicleAdd(vehicleAdd);
    }

    public String getAddVehicleNum() {
        return AddVehicleNum;
    }

    public void setAddVehicleNum(String addVehicleNum) {
        AddVehicleNum = addVehicleNum;
    }

    public int getAddMaxWeight() {
        return AddMaxWeight;
    }

    public void setAddMaxWeight(int addMaxWeight) {
        AddMaxWeight = addMaxWeight;
    }

    public int getAddNoPassenger() {
        return AddNoPassenger;
    }

    public void setAddNoPassenger(int addNoPassenger) {
        AddNoPassenger = addNoPassenger;
    }

    public String getVehicleAdd() {
        return vehicleAdd;
    }

    public void setVehicleAdd(String vehicleAdd) {
        this.vehicleAdd = vehicleAdd;
    }

    public String toString(){
        return AddVehicleNum+" "+AddMaxWeight+" "+AddNoPassenger+" "+vehicleAdd;
    }
}