package com.aircraftmanagementsystem.service;

import com.aircraftmanagementsystem.exception.PilotAlreadyAssignedException;
import com.aircraftmanagementsystem.exception.PilotNotFoundException;
import com.aircraftmanagementsystem.model.Pilot;

public class PilotManager {
    private Pilot[] pilots;
    private int count;

    public PilotManager(int size) {
        pilots = new Pilot[size];
        count = 0;
    }

    public void addPilot(Pilot pilot) throws PilotAlreadyAssignedException {
        for (int i = 0; i < count; i++) {
            if (pilots[i].getPilotId().equals(pilot.getPilotId())) {
                throw new PilotAlreadyAssignedException("Pilot with id: " + pilot.getPilotId() + "is already assigned");
            }
        }
        pilots[count] = pilot;
        count++;
        System.out.println("Pilot added successfully");
    }

    public Pilot searchPilot(String pilotId) throws PilotNotFoundException {
        for (int i = 0; i < count; i++) {
            if (pilotId.equals(pilots[i].getPilotId())) {
                return pilots[i];
            }
        }
        throw new PilotNotFoundException("Pilot with id: " + pilotId + " is not found");
    }


    public void displayAllPilot() {
        if (count == 0) {
            System.err.println("No Pilots are available");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(pilots[i].displayDetails());
            System.out.println();
        }
    }


    public Pilot validatePilotAvailability(String pilotId) throws PilotAlreadyAssignedException, PilotNotFoundException{
        Pilot pt = searchPilot(pilotId);
        if(!pt.isAvailability()){
            throw new PilotAlreadyAssignedException("Pilot is already assigned with the id: "+pilotId);
        }
        return pt;
    }
}
