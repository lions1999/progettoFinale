package logic.engineeringclasses.bean;

public class FeeBean {

    private String apartment;
    private Double admin;
    private Double park;
    private Double elevator;
    private Double pet;
    private Double wifi;


    public String getApt() {
        return apartment;
    }

    public void setApt(String apartment) {
        this.apartment = apartment;
    }

    public Double getFeeAdmin() {
        return admin;
    }

    public void setFeeAdmin(Double admin) {
        this.admin = admin;
    }

    public Double getFeePark() {
        return park;
    }

    public void setFeePark(Double park) {
        this.park = park;
    }

    public Double getFeeElevator() {
        return elevator;
    }

    public void setFeeElevator(Double elevator) {
        this.elevator = elevator;
    }

    public Double getFeePet() {
        return pet;
    }

    public void setFeePet(Double pet) {
        this.pet = pet;
    }

    public Double getFeeWifi() {
        return wifi;
    }

    public void setFeeWifi(Double wifi) {
        this.wifi = wifi;
    }


}
