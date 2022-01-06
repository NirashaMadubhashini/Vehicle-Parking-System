package model;

public class OnDelivery {
     private String collectionOfVehicle;
     private String VehicleTypePark;
     private String  namesOfDrivers;
     private String DateTime;

    public OnDelivery() {
    }

    public OnDelivery(String collectionOfVehicle, String vehicleTypePark, String namesOfDrivers, String dateTime) {
        this.setCollectionOfVehicle(collectionOfVehicle);
        setVehicleTypePark(vehicleTypePark);
        this.setNamesOfDrivers(namesOfDrivers);
        setDateTime(dateTime);
    }

    public String getCollectionOfVehicle() {
        return collectionOfVehicle;
    }

    public void setCollectionOfVehicle(String collectionOfVehicle) {
        this.collectionOfVehicle = collectionOfVehicle;
    }

    public String getVehicleTypePark() {
        return VehicleTypePark;
    }

    public void setVehicleTypePark(String vehicleTypePark) {
        VehicleTypePark = vehicleTypePark;
    }

    public String getNamesOfDrivers() {
        return namesOfDrivers;
    }

    public void setNamesOfDrivers(String namesOfDrivers) {
        this.namesOfDrivers = namesOfDrivers;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String toString(){
        return collectionOfVehicle+" "+VehicleTypePark+" "+namesOfDrivers+" "+DateTime;
    }
}
