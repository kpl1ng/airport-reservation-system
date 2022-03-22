package Airline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Airline_reservation_system {
    static File aircraft_file = new File("C:\\Users\\decla\\Documents\\GitHub\\airport-reservation-system\\Airline reservation system\\src\\aircrafts.txt"); // pc
    //    static File aircraft_file = new File("C:\\Users\\decla\\Documents\\airliner-github\\Airline reservation system\\src\\aircrafts.txt"); // laptop
    static Scanner aircraft_file_read;
    static {
        try {
            aircraft_file_read = new Scanner(aircraft_file).useDelimiter("\\Z");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static String[] aircraft = aircraft_file_read.nextLine().split(" ");
    static String[] seat_letters = (aircraft_file_read.nextLine().split("\\|"));
    static String[] seat_amount = aircraft_file_read.nextLine().split("\\|");
    static String[] seat_class = aircraft_file_read.nextLine().split("\\|");
    static ArrayList<Airline.Aeroplane> aircraft_objects = new ArrayList<>();
    static ArrayList<Flight> Flights = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        int Flight_number = 1;
        planes();
        Scanner main_menu = new Scanner(System.in);
        String Flight_aircraft;
        int aircraftIndex;
        while (true) {
            System.out.println("What aircraft is being used: ");
            Flight_aircraft = main_menu.nextLine();
            aircraftIndex = aircraft_check(Flight_aircraft);
            if (aircraftIndex != -1) {
                break;
            }
            System.out.println("That is not an available aircraft");
        }
        System.out.println("What time does it depart: ");
        String Flight_time = main_menu.next();
        System.out.println("Where is the departure: ");
        String Flight_departure = main_menu.next();
        System.out.println("Where does it arrive: ");
        String Flight_Arrival = main_menu.next();
        System.out.println("Flight " + Flight_number + "\nAircraft: " +Flight_aircraft+ "\nTime: "+Flight_time+"\nDeparture: "+Flight_departure+"\nArrival: "+Flight_Arrival);
        newFlight(aircraftIndex,Flight_time,Flight_departure,Flight_Arrival);
    }
    public static void newFlight(int aircraftIndex,String Time, String Depart, String Arrival){
        Flights.add(new Flight(aircraft_objects.get(aircraftIndex),new Flightpath(Time,Depart,Arrival)));
    }
    public static int aircraft_check(String Flight_aircraft){
        for (int x = 0; x<aircraft.length;x++){
            if (aircraft[x].equals(Flight_aircraft)){
                return x;
            }
        }
        return -1;
    }
    public static void planes(){
        for (int x = 0; x<aircraft.length;x++){
            aircraft_objects.add(new Airline.Aeroplane());
            aircraft_objects.get(x).aircraft_name = aircraft[x];
            //<editor-fold desc="Aircraft manufacturer name">
            if (aircraft[x].charAt(0) == '7'){
                aircraft_objects.get(x).aircraft_manufacturer = "Boeing";
            }
            else if (aircraft[x].charAt(0) == 'A'){
                aircraft_objects.get(x).aircraft_manufacturer = "Airbus";
            }
            else{
                aircraft_objects.get(x).aircraft_manufacturer = "*";
            }
            //</editor-fold>
            String[] temporary_seat_amount = seat_amount[x].split(",");
            String[] temporary_seat_class = seat_class[x].split(",");
            String[] temporary_seat_letter = seat_letters[x].split(" ");
            ArrayList<ArrayList<Airline.Seats>> aircraft_seats = new ArrayList<>();
            for (int y = 0; y<temporary_seat_amount.length;y++){
                String[] t_temporary_seat_amount = temporary_seat_amount[y].split(" ");
                String[] t_temporary_seat_class = temporary_seat_class[y].split(" ");
                aircraft_seats.add(new ArrayList<>());
                int seat_number = 1;
                for (int z = 0; z<t_temporary_seat_amount.length;z++){
                    for (int i = 0; i<Integer.parseInt(t_temporary_seat_amount[z]);i++) {
                        aircraft_seats.get(y).add(new Airline.Seats(Integer.toString(seat_number),temporary_seat_letter[y],t_temporary_seat_class[z]));
                        seat_number ++;
                    }
                }
            }
            aircraft_objects.get(x).aircraft_seats = aircraft_seats;
        }
    }
}
class Flight{
    Aeroplane Aircraft;
    Flightpath Flight_path;
    public Flight(Aeroplane passedAircraft, Flightpath passedFlightPath){
        Aircraft = passedAircraft;
        Flight_path = passedFlightPath;
    }
}
class Flightpath {
    String Time;
    String Departure;
    String Arrival;
    public Flightpath(String passedTime, String passedDeparture, String passedArrival){
        Time = passedTime;
        Departure = passedDeparture;
        Arrival = passedArrival;
    }
}
class Aeroplane {
    ArrayList<ArrayList<Seats>> aircraft_seats = new ArrayList<>();
    String aircraft_name;
    String aircraft_manufacturer;
}

class Seats {
    Passenger passenger;
    String seat_number;
    String seat_letter;
    String seat_class;
    public Seats(String passed_seat_number, String passed_seat_letter, String passed_seat_class){
        seat_number = passed_seat_number;
        seat_letter = passed_seat_letter;
        seat_class = passed_seat_class;
    }
}
class Passenger {
    String Firstname;
    String Lastname;
}

