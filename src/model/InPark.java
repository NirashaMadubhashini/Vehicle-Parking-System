package model;

public class InPark {
       private String collectionOfVehicle;
       private String VehicleTypePark;
       private String  SlotNum;
       private String DateTime;


    public InPark() {
    }

    public InPark( String collectionOfVehicle,String vehicleTypePark, String slotNum, String dateTime) {
        this.setCollectionOfVehicle(collectionOfVehicle);
        setVehicleTypePark(vehicleTypePark);
        setSlotNum(slotNum);
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

    public String getSlotNum() {
        return SlotNum;
    }

    public void setSlotNum(String slotNum) {
        SlotNum = slotNum;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String toString(){
        return collectionOfVehicle+" "+DateTime+" "+SlotNum+" "+VehicleTypePark;
    }

}
