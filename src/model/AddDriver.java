package model;

public class AddDriver {
   private String  DriverName;
   private String  Nic;
   private String  LicenseNo;
   private String  Address;
   private int ContactNo;

    public AddDriver() {
    }

    public AddDriver(String driverName, String nic, String licenseNo, String address, int contactNo) {
        setDriverName(driverName);
        setNic(nic);
        setLicenseNo(licenseNo);
        setAddress(address);
        setContactNo(contactNo);
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        LicenseNo = licenseNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int contactNo) {
        ContactNo = contactNo;
    }
}
