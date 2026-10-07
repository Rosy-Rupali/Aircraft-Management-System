package com.aircraftmanagementsystem.model;

public class Flight {
    private String flightId;
    private String source;
    private String destination;
    private Aircraft aircraft;
    private Pilot pilot;
    private String flightStatus;

    public Flight(String flightId, String source, String destination, Aircraft aircraft, Pilot pilot, String flightStatus) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.pilot = pilot;
        this.flightStatus = flightStatus;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
    public String displayDetails() {
        return "Flight ID: " + flightId +
                "\nSource: " + source +
                "\nDestination: " + destination +
                "\nAircraft ID: " + aircraft.getAircraftId() +
                "\nPilot ID: " + pilot.getPilotId() +
                "\nFlight Status: " + flightStatus;
    }
}
