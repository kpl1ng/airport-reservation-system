package Airline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;


//    //<editor-fold desc="Array Initialisation">
//    static ArrayList<testing> flights = new ArrayList<>();
//    static ArrayList<Integer> flight_number = new ArrayList<>();
//    static ArrayList<String> flight_id = new ArrayList<>();
//    //</editor-fold>
//    //<editor-fold desc="Description">
//    public static void main(String[] args) throws FileNotFoundException {
//        //<editor-fold desc="File reading & lists">
//        //<editor-fold desc="File directories">
////        File file = new File("C:\\Users\\decla\\Downloads\\airport-reservation-system-code\\airport-reservation-system-code\\Airline reservation system\\src\\aircrafts.txt");
//        File file = new File("C:\\Users\\decla\\Documents\\airliner-github\\Airline reservation system\\src\\aircrafts.txt"); // laptop
//        //</editor-fold>
//        Scanner fileread = new Scanner(file).useDelimiter("\\Z");
//        String aircrafts = fileread.nextLine();
//        String seatletters = fileread.nextLine();
//        String seatnumbers = fileread.nextLine();
//        String[] tempseatletters = seatletters.split("\\|");
//        String[] aircraftlist = (aircrafts.substring(aircrafts.indexOf("{") + 1, aircrafts.indexOf("}")).split(" "));
//        ArrayList<String[]> seatletterslist = new ArrayList<>(aircrafts.length());
//        ArrayList<Aeroplanetest> aircraftclasslist = new ArrayList<>();
//        for (int x = 0; x < aircraftlist.length; x++) {
//            seatletterslist.add(new String[(int) Math.ceil(tempseatletters[x].length()/2)]);
//            System.out.println(tempseatletters[x]);
//            System.out.println((seatletterslist));
//            System.out.println((tempseatletters[1]));
//            aircraftclasslist.add(new Aeroplanetest());
//            if (aircraftlist[x].charAt(0) == ('7')) {
//                aircraftclasslist.get(x).aircraft_manufacturer = "Boeing";
//            }
//            else{
//                aircraftclasslist.get(x).aircraft_manufacturer = "Airbus";
//            }
//            aircraftclasslist.get(x).aircraft_name = aircraftlist[x];
//        }
//        ArrayList<ArrayList<ArrayList<String[]>>> seatnumberslist = new ArrayList<>(aircraftlist.length);
//        seatnumberslist.add(new ArrayList<>());
//        //</editor-fold>2
//        //<editor-fold desc="seat initialization">
//        for (int x = 0; x<seatletterslist.size();x++) {
//            if (!seatletterslist.get(x)[0].equals("*")){
//                for (int y = 0; y<seatletterslist.get(x).length;y++){
//                    System.out.println(seatletterslist);
//                    String[] q = (seatnumbers.substring(seatnumbers.indexOf("{") + 1, seatnumbers.indexOf("}"))).split(" ");
//                    seatnumbers = seatnumbers.substring(seatnumbers.indexOf("}") + 1);
//                    seatnumberslist.get(x).add(new ArrayList<>());
//                    seatnumberslist.get(x).get(y).add(q);
//                }
//            }
//        }
//        ArrayList<ArrayList<ArrayList<seattest>>> seats = new ArrayList<>(seatletters.length());
//        for (int x = 0; x < seatnumberslist.get(0).get(0).size(); x++) {
//            System.out.println("here");
//
//            seats.add(new ArrayList<>());
//            System.out.println("here");
//            for (int z = 0; z < seatnumberslist.get(0).get(0).get(x).length; z++) {
//                seats.get(x).add(new ArrayList<>());
//                for (int b = 0; b < Integer.parseInt(seatnumberslist.get(0).get(0).get(x)[z]); b++) {
//                    seats.get(x).get(z).add(new seattest());
//                }
//            }
//
//        }
//        //</editor-fold>
//    }
//
//
//    public static String checkaircraft(String aircraft, String[] aircraftlist){
//        for (int x = 0; x<aircraftlist.length;x++){
//            if (aircraftlist[x].equals(aircraft)){
//                if (aircraft.charAt(0) == '7'){
//                    return "boeing";
//                }
//                return "airbus";
//            }
//        }
//        return null;
//    }
//
//    public static void addflight(Integer x,String aircraft,String aircraftmanufacturer){
//        flight_number.add(x);
//        flight_id.add("flight"+aircraftmanufacturer+aircraft+x);
//        flights.add(new testing());
//    }
//    //</editor-fold>

public class testing {
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
    static ArrayList<Aeroplanetest> aircraft_objects = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {
        int Flight_number = 1;
        planes();
        System.out.println(Arrays.toString(aircraft));
        Scanner main_menu = new Scanner(System.in);
        String Flight_aircraft;
        while (true) {
            System.out.println("What aircraft is being used: ");
            Flight_aircraft = main_menu.nextLine();
            if (aircraft_check(Flight_aircraft)) {
                break;
            }
            System.out.println("That is not an available aircraft");
        }
        System.out.println(Flight_aircraft);
        System.out.println("What time does it depart: ");
        String Flight_time = main_menu.next();
        System.out.println("Where is the departure: ");
        String Flight_departure = main_menu.next();
        System.out.println("Where does it arrive: ");
        String Flight_Arrival = main_menu.next();
        System.out.println("Flight " + Flight_number + "\nAircraft: " +Flight_aircraft+ "\nTime: "+Flight_time+"\nDeparture: "+Flight_departure+"\nArrival: "+Flight_Arrival);
    }

    public static boolean aircraft_check(String Flight_aircraft){
        for (int x = 0; x<aircraft.length;x++){
            if (aircraft[x].equals(Flight_aircraft)){
                return true;
            }
        }
        return false;
    }


    public static void planes(){
        for (int x = 0; x<aircraft.length;x++){
            aircraft_objects.add(new Aeroplanetest());
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
            ArrayList<ArrayList<seattest>> aircraft_seats = new ArrayList<>();
            for (int y = 0; y<temporary_seat_amount.length;y++){
                String[] t_temporary_seat_amount = temporary_seat_amount[y].split(" ");
                String[] t_temporary_seat_class = temporary_seat_class[y].split(" ");
                aircraft_seats.add(new ArrayList<>());
                int seat_number = 1;
                for (int z = 0; z<t_temporary_seat_amount.length;z++){
                    for (int i = 0; i<Integer.parseInt(t_temporary_seat_amount[z]);i++) {
                        aircraft_seats.get(y).add(new seattest(Integer.toString(seat_number),temporary_seat_letter[y],t_temporary_seat_class[z]));
                        seat_number ++;
                    }
                }
            }
            aircraft_objects.get(x).aircraft_seats = aircraft_seats;
        }
    }
}

class Flight{
    Aeroplanetest Aircraft;
    Flightpathtest Flight_path;
}

class Flightpathtest{
    String Time;
    String Departure;
    String Arrival;
}

class Aeroplanetest{
    ArrayList<ArrayList<seattest>> aircraft_seats = new ArrayList<>();
    String aircraft_name;
    String aircraft_manufacturer;
}


class seattest{
    Passengertest passenger;
    String seat_number;
    String seat_letter;
    String seat_class;
    public seattest(String passed_seat_number, String passed_seat_letter, String passed_seat_class){
        seat_number = passed_seat_number;
        seat_letter = passed_seat_letter;
        seat_class = passed_seat_class;
    }
}

class Passengertest{
    String Firstname;
    String Lastname;
}

