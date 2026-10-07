package com.aircraftmanagementsystem.service;

import com.aircraftmanagementsystem.exception.AircraftNotAvailableException;
import com.aircraftmanagementsystem.exception.FlightNotFoundException;
import com.aircraftmanagementsystem.exception.InvalidFlightException;
import com.aircraftmanagementsystem.exception.PilotAlreadyAssignedException;
import com.aircraftmanagementsystem.model.Aircraft;
import com.aircraftmanagementsystem.model.Flight;
import com.aircraftmanagementsystem.model.Pilot;

public class FlightManager {
    private Flight[] flights;
    private int count;

    public FlightManager(int size) {
        flights = new Flight[size];
        count = 0;
    }

    // Schedule Flight
    public void scheduleFlight(Flight flight) throws AircraftNotAvailableException, PilotAlreadyAssignedException, InvalidFlightException {

        if (count == flights.length) {
            throw new InvalidFlightException("Flight is full.");
        }

        Aircraft aircraft = flight.getAircraft();
        Pilot pilot = flight.getPilot();

        // Check aircraft availability
        if (!aircraft.getStatus().equalsIgnoreCase("Available")) {
            throw new AircraftNotAvailableException("Aircraft is not available.");
        }

        // Check pilot availability
        if (!pilot.isAvailability()) {
            throw new PilotAlreadyAssignedException("Pilot is already assigned.");
        }

        // Add flight
        flights[count] = flight;
        count++;

        // Make aircraft and pilot unavailable
        aircraft.setStatus("In Use");
        pilot.setAvailability(false);

        System.out.println("Flight scheduled successfully.");
    }

    public Flight searchFlight(String flightId) throws FlightNotFoundException {

        for (int i = 0; i < count; i++) {

            if (flights[i].getFlightId().equals(flightId)) {
                return flights[i];
            }
        }

        throw new FlightNotFoundException("Flight with ID " + flightId + " not found.");
    }

    public void displayFlights() {
        if (count == 0) {
            System.err.println("No flights available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(flights[i].displayDetails());
            System.out.println();
        }
    }

    public void cancelFlight(String flightId) throws FlightNotFoundException {
        Flight flight = searchFlight(flightId);
        flight.getAircraft().setStatus("Available");
        flight.getPilot().setAvailability(true);

        for (int i = 0; i < count; i++) {

            if (flights[i].getFlightId().equals(flightId)) {

                for (int j = i; j < count - 1; j++) {
                    flights[j] = flights[j + 1];
                }

                flights[count - 1] = null;
                count--;

                System.out.println("Flight cancelled successfully.");
            }
        }

    }
}
