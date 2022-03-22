package Airline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;




public class Airline_reservation_system {
    //<editor-fold desc="Array Initialisation">
    static ArrayList<Airline_reservation_system> flights = new ArrayList<>();
    static ArrayList<Integer> flight_number = new ArrayList<>();
    static ArrayList<String> flight_id = new ArrayList<>();
    //</editor-fold>


    //<editor-fold desc="main">
    public static void main(String[] args) throws FileNotFoundException {




        //<editor-fold desc="fix">
        int x = 0;
        while (true) {
            Scanner main_menu = new Scanner(System.in);
            while (true) {
                String main = main_menu.nextLine();
                if (main.equals("555")) {
                    while (true) {
                        while (true) {
                            System.out.println("aircraft: ");
                            String aircraft = main_menu.nextLine();
//                            if (checkaircraft(aircraft,aircraftlist) != null) {
//                                addflight(x, aircraft, checkaircraft(aircraft,aircraftlist));
//                                System.out.println("new flight confirmed, flight number " + x);
//                                x += 1;
                                break;
                            }
                            System.out.println("that is not a valid aircraft");
                        break;
                        }
                        System.out.println("do you want to add another flight? (y/n)");
                        String another_aircraft = main_menu.nextLine();
                        if (another_aircraft.equals("n")) {
                            break;
                        }
                    }
                }
//                if (main.equals("1")) {
//                    break;
//                }
//            }
            System.out.println("flight number: ");
//            String flight_number = main_menu.nextLine();
//            System.out.println("type in your first name: ");
//            String Firstname = main_menu.nextLine();
//            System.out.println("type in your last name: ");
//            String Lastname = main_menu.nextLine();
//            flights.get(Integer.parseInt(flight_number)).availableseats(Integer.parseInt(flight_number));
//            System.out.println("type in what seat you want (letter/number): ");
//            String seat = main_menu.nextLine();
//            flights.get(Integer.parseInt(flight_number)).reserveseat(String.valueOf(seat.charAt(1)), String.valueOf(seat.charAt(0)), Firstname, Lastname, Integer.parseInt(flight_number));
        }
        //</editor-fold>

    }

    public static void seat_initialisation() throws FileNotFoundException {
        //<editor-fold desc="File reading & lists">
        //<editor-fold desc="File directories">
//        File file = new File("C:\\Users\\decla\\Downloads\\airport-reservation-system-code\\airport-reservation-system-code\\Airline reservation system\\src\\aircrafts.txt");
        File file = new File("C:\\Users\\decla\\Documents\\airliner-github\\Airline reservation system\\src\\aircrafts.txt"); // laptop
        //</editor-fold>
        Scanner fileread = new Scanner(file).useDelimiter("\\Z");
        String aircrafts = fileread.nextLine();
        String seatletters = fileread.nextLine();
        String seatnumbers = fileread.nextLine();
        String[] tempseatletters = seatletters.split("\\|");
        String[] aircraftlist = (aircrafts.substring(aircrafts.indexOf("{") + 1, aircrafts.indexOf("}")).split(" "));
        ArrayList<String[]> seatletterslist = new ArrayList<>(aircrafts.length());
        ArrayList<Aeroplane> aircraftclasslist = new ArrayList<>();
        for (int x = 0; x < aircraftlist.length; x++) {
            seatletterslist.add(new String[(int) Math.ceil(tempseatletters[x].length()/2)]);
            System.out.println(tempseatletters[x]);
            System.out.println((seatletterslist));
            System.out.println((tempseatletters[1]));
            aircraftclasslist.add(new Aeroplane());
            if (aircraftlist[x].charAt(0) == ('7')) {
                aircraftclasslist.get(x).aircraft_manufacturer = "Boeing";
            }
            else{
                aircraftclasslist.get(x).aircraft_manufacturer = "Airbus";
            }
            aircraftclasslist.get(x).aircraft_name = aircraftlist[x];
        }
        ArrayList<ArrayList<ArrayList<String[]>>> seatnumberslist = new ArrayList<>(aircraftlist.length);
        seatnumberslist.add(new ArrayList<>());
        //</editor-fold>2
        //<editor-fold desc="seat initialization">
        for (int x = 0; x<seatletterslist.size();x++) {
            if (!seatletterslist.get(x)[0].equals("*")){
                for (int y = 0; y<seatletterslist.get(x).length;y++){
                    System.out.println(seatletterslist);
                    String[] q = (seatnumbers.substring(seatnumbers.indexOf("{") + 1, seatnumbers.indexOf("}"))).split(" ");
                    seatnumbers = seatnumbers.substring(seatnumbers.indexOf("}") + 1);
                    seatnumberslist.get(x).add(new ArrayList<>());
                    seatnumberslist.get(x).get(y).add(q);
                }
            }
        }
        ArrayList<ArrayList<ArrayList<seat>>> seats = new ArrayList<>(seatletters.length());
        for (int x = 0; x < seatnumberslist.get(0).get(0).size(); x++) {
            System.out.println("here");

            seats.add(new ArrayList<>());
            System.out.println("here");
            for (int z = 0; z < seatnumberslist.get(0).get(0).get(x).length; z++) {
                seats.get(x).add(new ArrayList<>());
                for (int b = 0; b < Integer.parseInt(seatnumberslist.get(0).get(0).get(x)[z]); b++) {
                    seats.get(x).get(z).add(new seat());
                }
            }

        }
        //</editor-fold>
    }


    public static String checkaircraft(String aircraft, String[] aircraftlist){
        for (int x = 0; x<aircraftlist.length;x++){
            if (aircraftlist[x].equals(aircraft)){
                if (aircraft.charAt(0) == '7'){
                    return "boeing";
                }
                return "airbus";
            }
        }
        return null;
    }

    public static void addflight(Integer x,String aircraft,String aircraftmanufacturer){
        flight_number.add(x);
        flight_id.add("flight"+aircraftmanufacturer+aircraft+x);
        flights.add(new Airline_reservation_system());
    }
    //</editor-fold>

//<editor-fold desc="modules fix">
//    public void availableseats(int flight_number){
//        ArrayList<String> seats = new ArrayList<>();
//        for (int x = 0; x<flights.get(flight_number).seat_letter.size();x++){
//            seats.add(Arrays.asList(this.seat_number[x]) + "\n");
//        }
//        System.out.println(seats);
//    }

//    public String reserveseat(String seat_number, String seat_letter,String Firstname, String Lastname,int flight_number){
//        if (flights.get(flight_number).seat_number[this.seat_letter.indexOf(seat_letter)][Integer.parseInt(seat_number)-1].equals("")){
//            return "0";
//        }
//        this.seats[Integer.parseInt(seat_number)-1][this.seat_letter.indexOf(seat_letter)].seat_number = seat_number;
//        this.seats[Integer.parseInt(seat_number)-1][this.seat_letter.indexOf(seat_letter)].seat_letter = seat_letter;
//        this.seat_number[this.seat_letter.indexOf(seat_letter)][Integer.parseInt(seat_number)-1] = "";
//        System.out.println("Seat successfully reserved!");
//        return "1";
//    }
//


//</editor-fold>

}

class Aeroplane{
    ArrayList<ArrayList<ArrayList<seat>>> aircraft_seats = new ArrayList<>();
    String aircraft_name;
    String aircraft_manufacturer;
}

class seat{
    String seat_number;
    String seat_letter;
}
class Flightpath{
    String Departure;
    String Arrival;
}
class Passenger{
    String Firstname;
    String Lastname;
}
