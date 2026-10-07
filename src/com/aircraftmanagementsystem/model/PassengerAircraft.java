package com.aircraftmanagementsystem.model;

public class PassengerAircraft extends Aircraft{
    private int noOfPassenger;
    private boolean businessClassAvailable;

    public PassengerAircraft(String aircraftId, String model, String manufacturer, int capacity, String status, int noOfPassenger, boolean businessClassAvailable) {
        super(aircraftId, model, manufacturer, capacity, status);
        this.noOfPassenger = noOfPassenger;
        this.businessClassAvailable = businessClassAvailable;
    }

    public int getNoOfPassenger() {
        return noOfPassenger;
    }

    public boolean isBusinessClassAvailable() {
        return businessClassAvailable;
    }

    public void setNoOfPassenger(int noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public void setBusinessClassAvailable(boolean businessClassAvailable) {
        this.businessClassAvailable = businessClassAvailable;
    }

    @Override
    public String getAircraftType(){
        return "Passenger Aircraft";
    }
    @Override
    public String displayDetails(){
        return "Aircraft Id:"+getAircraftId()+"\nModel: "+getModel()+
                "\nManufacturer: "+getManufacturer()+"\nCapacity: "+getCapacity()
                +"\nStatus: "+getStatus()+"\nNumber of Passenger: "+getNoOfPassenger()
                +"\nBusinessClassAvailable: "+isBusinessClassAvailable();
    }
    @Override
    public boolean validateCapacity(){
        return noOfPassenger <= getCapacity();
    }
}
