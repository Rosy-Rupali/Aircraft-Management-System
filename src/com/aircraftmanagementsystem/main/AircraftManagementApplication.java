package com.aircraftmanagementsystem.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aircraftmanagementsystem.service.AircraftManager;
import com.aircraftmanagementsystem.service.PilotManager;
import com.aircraftmanagementsystem.service.FlightManager;

import com.aircraftmanagementsystem.model.Aircraft;
import com.aircraftmanagementsystem.model.PassengerAircraft;
import com.aircraftmanagementsystem.model.CargoAircraft;
import com.aircraftmanagementsystem.model.PrivateAircraft;
import com.aircraftmanagementsystem.model.Pilot;
import com.aircraftmanagementsystem.model.Flight;

import com.aircraftmanagementsystem.exception.*;

public class AircraftManagementApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AircraftManager aircraftManager = new AircraftManager(10);
        PilotManager pilotManager = new PilotManager(10);
        FlightManager flightManager = new FlightManager(10);
        try {
            while (true) {

                try {

                    System.out.println("\n=========================================");
                    System.out.println("       AIRCRAFT MANAGEMENT SYSTEM");
                    System.out.println("=========================================");

                    System.out.println("1. Register Aircraft");
                    System.out.println("2. Display All Aircraft");
                    System.out.println("3. Search Aircraft");
                    System.out.println("4. Add Pilot");
                    System.out.println("5. Display All Pilots");
                    System.out.println("6. Search Pilot");
                    System.out.println("7. Schedule Flight");
                    System.out.println("8. Display All Flights");
                    System.out.println("9. Search Flight");
                    System.out.println("10. Cancel Flight");
                    System.out.println("11. Exit");

                    System.out.print("Enter your choice: ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        // ==========================================
                        // 1. REGISTER AIRCRAFT
                        // ==========================================

                        case 1:

                            try {

                                System.out.println("\n1. Passenger");
                                System.out.println("2. Cargo");
                                System.out.println("3. Private");

                                System.out.print("Enter aircraft type: ");
                                int type = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Aircraft ID: ");
                                String aircraftId = sc.nextLine();

                                System.out.print("Enter Model: ");
                                String model = sc.nextLine();

                                System.out.print("Enter Manufacturer: ");
                                String manufacturer = sc.nextLine();

                                System.out.print("Enter Capacity: ");
                                int capacity = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Status: ");
                                String status = sc.nextLine();

                                Aircraft aircraft;

                                if (type == 1) {

                                    System.out.print("Enter Number of Passengers: ");
                                    int numberOfPassengers = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print(
                                            "Business Class Available (true/false): ");
                                    boolean businessClassAvailable =
                                            sc.nextBoolean();
                                    sc.nextLine();

                                    aircraft = new PassengerAircraft(
                                            aircraftId,
                                            model,
                                            manufacturer,
                                            capacity,
                                            status,
                                            numberOfPassengers,
                                            businessClassAvailable
                                    );

                                } else if (type == 2) {

                                    System.out.print("Enter Cargo Capacity: ");
                                    int cargoCapacity = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Enter Cargo Type: ");
                                    String cargoType = sc.nextLine();

                                    aircraft = new CargoAircraft(
                                            aircraftId,
                                            model,
                                            manufacturer,
                                            capacity,
                                            status,
                                            cargoCapacity,
                                            cargoType
                                    );

                                } else if (type == 3) {

                                    System.out.print("Enter Owner Name: ");
                                    String ownerName = sc.nextLine();

                                    System.out.print("Enter Luxury Level: ");
                                    String luxuryLevel = sc.nextLine();

                                    aircraft = new PrivateAircraft(
                                            aircraftId,
                                            model,
                                            manufacturer,
                                            capacity,
                                            status,
                                            ownerName,
                                            luxuryLevel
                                    );

                                } else {

                                    System.out.println("Invalid aircraft type.");
                                    break;
                                }

                                aircraftManager.registerAircraft(aircraft);

                            } catch (AircraftAlreadyExistsException |
                                     InvalidAircraftException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 2. DISPLAY AIRCRAFT
                        // ==========================================

                        case 2:

                            aircraftManager.displayAllAircrafts();
                            break;


                        // ==========================================
                        // 3. SEARCH AIRCRAFT
                        // ==========================================

                        case 3:

                            try {

                                System.out.print("Enter Aircraft ID: ");
                                String aircraftId = sc.nextLine();

                                Aircraft aircraft =
                                        aircraftManager.searchAircraft(aircraftId);

                                System.out.println(
                                        aircraft.displayDetails());

                            } catch (AircraftNotFoundException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 4. ADD PILOT
                        // ==========================================

                        case 4:

                            try {

                                System.out.print("Enter Pilot ID: ");
                                String pilotId = sc.nextLine();

                                System.out.print("Enter Pilot Name: ");
                                String pilotName = sc.nextLine();

                                System.out.print("Enter License Number: ");
                                String licenseNumber = sc.nextLine();

                                System.out.print("Enter Experience: ");
                                int experience = sc.nextInt();
                                sc.nextLine();

                                Pilot pilot = new Pilot(
                                        pilotId,
                                        pilotName,
                                        licenseNumber,
                                        experience,
                                        true
                                );

                                pilotManager.addPilot(pilot);

                            } catch (PilotAlreadyAssignedException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 5. DISPLAY PILOTS
                        // ==========================================

                        case 5:

                            pilotManager.displayAllPilot();

                            break;


                        // ==========================================
                        // 6. SEARCH PILOT
                        // ==========================================

                        case 6:

                            try {

                                System.out.print("Enter Pilot ID: ");
                                String pilotId = sc.nextLine();

                                Pilot pilot =
                                        pilotManager.searchPilot(pilotId);

                                System.out.println(
                                        "Pilot ID: " + pilot.getPilotId());
                                System.out.println(
                                        "Pilot Name: " + pilot.getPilotName());
                                System.out.println(
                                        "License: " + pilot.getLicenseNumber());
                                System.out.println(
                                        "Experience: " + pilot.getExperience());
                                System.out.println(
                                        "Availability: " +
                                                pilot.isAvailability());

                            } catch (PilotNotFoundException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 7. SCHEDULE FLIGHT
                        // ==========================================

                        case 7:

                            try {

                                System.out.print("Enter Flight ID: ");
                                String flightId = sc.nextLine();

                                System.out.print("Enter Source: ");
                                String source = sc.nextLine();

                                System.out.print("Enter Destination: ");
                                String destination = sc.nextLine();

                                System.out.print("Enter Aircraft ID: ");
                                String aircraftId = sc.nextLine();

                                System.out.print("Enter Pilot ID: ");
                                String pilotId = sc.nextLine();

                                Aircraft aircraft =
                                        aircraftManager.searchAircraft(aircraftId);

                                Pilot pilot =
                                        pilotManager.searchPilot(pilotId);

                                Flight flight = new Flight(
                                        flightId,
                                        source,
                                        destination,
                                        aircraft,
                                        pilot,
                                        "SCHEDULED"
                                );

                                flightManager.scheduleFlight(flight);

                            } catch (AircraftNotFoundException |
                                     PilotNotFoundException |
                                     AircraftNotAvailableException |
                                     PilotAlreadyAssignedException |
                                     InvalidFlightException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 8. DISPLAY FLIGHTS
                        // ==========================================

                        case 8:

                            flightManager.displayFlights();

                            break;


                        // ==========================================
                        // 9. SEARCH FLIGHT
                        // ==========================================

                        case 9:

                            try {

                                System.out.print("Enter Flight ID: ");
                                String flightId = sc.nextLine();

                                Flight flight =
                                        flightManager.searchFlight(flightId);

                                System.out.println(
                                        flight.displayDetails());

                            } catch (FlightNotFoundException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 10. CANCEL FLIGHT
                        // ==========================================

                        case 10:

                            try {

                                System.out.print("Enter Flight ID: ");
                                String flightId = sc.nextLine();

                                flightManager.cancelFlight(flightId);

                            } catch (FlightNotFoundException e) {

                                System.out.println(e.getMessage());
                            }

                            break;


                        // ==========================================
                        // 11. EXIT
                        // ==========================================

                        case 11:

                            System.out.println("Thank you for using Aircraft Management System.");
                            System.exit(0);

                            break;


                        default:

                            System.out.println(
                                    "Invalid choice. Please select 1 to 11.");
                    }

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input. Please enter a valid number.");

                    sc.nextLine();

                }
            }
        } finally {
            sc.close();
        }
    }
}