package com.aircraftmanagementsystem.model;

public class CargoAircraft extends Aircraft{
    private int cargoCapacity;
    private String cargoType;

    public CargoAircraft(String aircraftId, String model, String manufacturer, int capacity, String status, int cargoCapacity, String cargoType) {
        super(aircraftId, model, manufacturer, capacity, status);
        this.cargoCapacity = cargoCapacity;
        this.cargoType = cargoType;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    @Override
    public String getAircraftType(){
        return "Cargo Aircraft";
    }
    @Override
    public String displayDetails(){
        return "Aircraft Id:"+getAircraftId()+"\nModel: "+getModel()+
                "\nManufacturer: "+getManufacturer()+"\nCapacity: "+getCapacity()
                +"\nStatus: "+getStatus()+"\nCargo Capacity: "+getCargoCapacity()
                +"\nCargo Type: "+getCargoType();
    }
    @Override
    public boolean validateCapacity(){
        return cargoCapacity <= getCapacity();
    }
}
