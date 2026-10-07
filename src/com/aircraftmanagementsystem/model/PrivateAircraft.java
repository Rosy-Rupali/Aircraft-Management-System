package com.aircraftmanagementsystem.model;

public class PrivateAircraft extends Aircraft{
    private String ownerName;
    private String luxuryLevel;

    public PrivateAircraft(String aircraftId, String model, String manufacturer, int capacity, String status, String ownerName, String luxuryLevel) {
        super(aircraftId, model, manufacturer, capacity, status);
        this.ownerName = ownerName;
        this.luxuryLevel = luxuryLevel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLuxuryLevel() {
        return luxuryLevel;
    }

    public void setLuxuryLevel(String luxuryLevel) {
        this.luxuryLevel = luxuryLevel;
    }
    @Override
    public String getAircraftType(){
        return "Private Aircraft";
    }
    @Override
    public String displayDetails(){
        return "Aircraft Id:"+getAircraftId()+"\nModel: "+getModel()+
                "\nManufacturer: "+getManufacturer()+"\nCapacity: "+getCapacity()
                +"\nStatus: "+getStatus()+"\nOwner Name: "+getOwnerName()
                +"\nLuxury Level: "+getLuxuryLevel();
    }
    @Override
    public boolean validateCapacity(){
        return getCapacity() >0 && getCapacity()<20;
    }
}
