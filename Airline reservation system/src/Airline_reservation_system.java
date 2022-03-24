package Airline;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Airline_reservation_system {
    static File aircraft_file = new File("C:\\Users\\decla\\Documents\\GitHub\\airport-reservation-system\\Airline reservation system\\src\\aircrafts.txt"); // pc
    static Scanner aircraft_file_read;
    static {
        try {
            aircraft_file_read = new Scanner(aircraft_file).useDelimiter("\\Z");
        } catch (FileNotFoundException e) {
            aircraft_file = new File("C:\\Users\\decla\\Documents\\airliner-github\\Airline reservation system\\src\\aircrafts.txt"); // laptop
            try {
                aircraft_file_read = new Scanner(aircraft_file).useDelimiter("\\Z");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    static String[] aircraft = aircraft_file_read.nextLine().split(" ");
    static String[] seat_letters = (aircraft_file_read.nextLine().split("\\|"));
    static String[] seat_amount = aircraft_file_read.nextLine().split("\\|");
    static String[] seat_class = aircraft_file_read.nextLine().split("\\|");
    static ArrayList<Airline.Aeroplane> aircraft_objects = new ArrayList<>();
    static ArrayList<Flight> tFlights = new ArrayList<>();
    static Gate airportGates = new Gate();
    public static void main(String[] args){
        int Flight_number = 1;
        planes();
        Scanner main_menu = new Scanner(System.in);
        while (true) {
            String menu = main_menu.next();
            System.out.println(Arrays.toString(airportGates.gateNumber));
            if (menu.equals("0")){
                break;
            }
            if (menu.equals("1")) {
                String Flight_aircraft;
                int aircraftIndex;
                while (true) {
                    System.out.println("What aircraft is being used: ");
                    Flight_aircraft = main_menu.next();
                    aircraftIndex = aircraft_check(Flight_aircraft);
                    if (aircraftIndex != -1) {
                        break;
                    }
                    System.out.println("That is not an available aircraft");
                }
                ArrayList<Integer> flightDate = new ArrayList<>();
                System.out.println("What hour does it depart (24 hour format): ");
                String flightTimeHour = main_menu.next();
                flightDate.add(Integer.valueOf(flightTimeHour));
                System.out.println("What minute does it depart: ");
                String flightTimeMinute = main_menu.next();
                flightDate.add(Integer.valueOf(flightTimeMinute));
                System.out.println("What day does it depart: ");
                String flightDay = main_menu.next();
                flightDate.add(Integer.valueOf(flightDay));
                System.out.println("What month does it depart: ");
                String flightMonth = main_menu.next();
                flightDate.add(Integer.valueOf(flightMonth));
                System.out.println("Where is the departure: ");
                String flightDeparture = main_menu.next();
                System.out.println("Where does it arrive: ");
                String flightArrival = main_menu.next();
                System.out.println("Flight " + Flight_number + "\nAircraft: " + Flight_aircraft + "\nDate: " + flightDate.get(2) + "-" + flightDate.get(3) + "-" + LocalDateTime.now().getYear() + "  " + flightDate.get(0) + ":" + flightDate.get(1) + "\nDeparture: " + flightDeparture + "\nArrival: " + flightArrival);
                Flight_number++;
                newFlight(aircraftIndex, flightDate, flightDeparture, flightArrival);
                airportGates.addFlight(Flight_number);
            } else {
                System.out.println("type in the flight number: ");
                int flightNumber = Integer.parseInt(main_menu.next()) - 1;
                System.out.println("type in the seat letter: ");
                String seatLetter = main_menu.next();
                System.out.println("type in the seat number: ");
                String seatNumber = main_menu.next();
                System.out.println("type in your first name: ");
                String firstName = main_menu.next();
                System.out.println("type in your last name: ");
                String lastName = main_menu.next();
                tFlights.get(flightNumber).Aircraft.aircraft_seats.get(seatLetterIndex(tFlights.get(flightNumber).Aircraft.aircraft_name, seatLetter)).get(Integer.parseInt(seatNumber)).passenger = new Passenger(firstName, lastName);
                System.out.println(tFlights.get(flightNumber).Aircraft.aircraft_seats.get(seatLetterIndex(tFlights.get(flightNumber).Aircraft.aircraft_name, seatLetter)).get(Integer.parseInt(seatNumber)).passenger.Firstname);
                System.out.println(seatLetterIndex(tFlights.get(flightNumber).Aircraft.aircraft_name, seatLetter));
            }
        }
    }

    public static void newFlight(int aircraftIndex,ArrayList<Integer> flightDate, String flightDepart, String flightArrival){
        tFlights.add(new Flight(aircraft_objects.get(aircraftIndex),new Flightpath(flightDepart,flightArrival,flightDate)));
    }
    public static int aircraft_check(String Flight_aircraft){
        for (int x = 0; x<aircraft.length;x++){
            if (aircraft[x].equals(Flight_aircraft)){
                return x;
            }
        }
        return -1;
    }

    public static int seatLetterIndex(String aircraft, String seatLetter){
        String[] temporary_seat_letter = seat_letters[aircraft_check(aircraft)].split(" ");
        for (int x = 0; x<temporary_seat_letter.length;x++){
            if (seatLetter.equals(temporary_seat_letter[x])){
                return x;
            }
        }
        return -1;
    }

    public static void planes(){
        for (int x = 0; x<aircraft.length;x++){
            aircraft_objects.add(new Airline.Aeroplane());
            aircraft_objects.get(x).aircraft_name = aircraft[x];
            if (aircraft[x].charAt(0) == '7'){
                aircraft_objects.get(x).aircraft_manufacturer = "Boeing";
            }
            else if (aircraft[x].charAt(0) == 'A'){
                aircraft_objects.get(x).aircraft_manufacturer = "Airbus";
            }
            else{
                aircraft_objects.get(x).aircraft_manufacturer = "*";
            }
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

class Gate{
    int[] flightNumber = new int[90];
    int[] gateNumber = new int[90];
    public Gate(){
        Arrays.fill(gateNumber,-1);
        Arrays.fill(flightNumber,-1);
    }
    public void addFlight(int passedflightNumber){
        int x = 0;
        while (!(gateNumber[x] == -1) && (x<gateNumber.length)){
            x++;
        }
        flightNumber[x] = passedflightNumber;
        gateNumber[x] = x+1;
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
    String flightDeparture;
    String flightArrival;
    ArrayList<Integer> flightDate;
    public Flightpath(String passedDeparture, String passedArrival, ArrayList<Integer> passedDate){
        flightDeparture = passedDeparture;
        flightArrival = passedArrival;
        flightDate = passedDate;
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
    public Passenger(String passedFirstname, String passedLastname){
        Firstname = passedFirstname;
        Lastname = passedLastname;
    }
}

