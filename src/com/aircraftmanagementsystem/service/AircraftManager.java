package com.aircraftmanagementsystem.service;

import com.aircraftmanagementsystem.exception.AircraftAlreadyExistsException;
import com.aircraftmanagementsystem.exception.AircraftNotFoundException;
import com.aircraftmanagementsystem.exception.InvalidAircraftException;
import com.aircraftmanagementsystem.model.Aircraft;

public class AircraftManager {
    private Aircraft[] aircrafts;
    private int count;

    public AircraftManager(int size) {
        aircrafts = new Aircraft[size];
        count = 0;
    }

    public void registerAircraft(Aircraft aircraft) throws InvalidAircraftException, AircraftAlreadyExistsException {
        if (aircraft.getCapacity() <= 0) {
            throw new InvalidAircraftException("Aircraft capacity cannot be zero or less than that.");
        }
        if (aircrafts.length == count) {
            throw new InvalidAircraftException("Aircraft array is full. Cannot register more aircraft to array");
        }
        for (int i = 0; i < count; i++) {
            if (aircrafts[i].getAircraftId().equals(aircraft.getAircraftId())) {
                throw new AircraftAlreadyExistsException("Aircraft with id " + aircraft.getAircraftId() + " already exists");
            }
        }
        aircrafts[count] = aircraft;
        count++;
        System.out.println("Aircraft registered successfully");
    }


    public Aircraft searchAircraft(String aircraftId) throws AircraftNotFoundException {
        for (int i = 0; i < count; i++) {
            if (aircraftId.equals(aircrafts[i].getAircraftId())) {
                return aircrafts[i];
            }
        }
        throw new AircraftNotFoundException("Aircraft is not present with id:" + aircraftId);
    }

    public void displayAllAircrafts() {
        if (count == 0) {
            System.err.println("No aircrafts are registered.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(aircrafts[i].displayDetails());
            System.out.println();
        }
    }

    public void removeAirCraft(String aircraftId) throws AircraftNotFoundException{
        int index = -1;
        for(int i=0; i<count; i++){
            if(aircrafts[i].getAircraftId().equals(aircraftId)){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new AircraftNotFoundException("Aircraft with id: "+aircraftId+" not found.");
        }

        for(int i=index; i<count-1; i++){
            aircrafts[i] = aircrafts[i+1];
        }
        aircrafts[count-1] = null;
        count--;
        System.out.println("Aircraft removed successfully");
    }
}
