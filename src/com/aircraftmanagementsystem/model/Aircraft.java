package com.aircraftmanagementsystem.model;

import com.aircraftmanagementsystem.interfa.Maintainence;

 public abstract class Aircraft implements Maintainence {
    private String aircraftId;
    private String model;
    private String manufacturer;
    private int capacity;
    private String status;

    public Aircraft(String aircraftId, String model, String manufacturer, int capacity, String status) {
        this.aircraftId = aircraftId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.status = status;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void start(){
        System.out.println("Aircraft with id "+aircraftId+" has been started!!");
    }
    public void stop(){
        System.out.println("Aircraft with id "+aircraftId+" has been stopped!!");
    }

    public abstract String displayDetails();
    public abstract String getAircraftType();
    public abstract boolean validateCapacity();
    @Override
    public void performMaintenance() {
        if (isMaintenanceRequired()) {
            System.out.println("Maintainence performed in the Aircraft with id: " + getAircraftId());
            status = "Available";
        } else
            System.out.println("Maintainence is not required for for Aircraft id: " + getAircraftId());
    }
    @Override
    public boolean isMaintenanceRequired(){
        return status.equalsIgnoreCase("Maintainence required");
    }
}
