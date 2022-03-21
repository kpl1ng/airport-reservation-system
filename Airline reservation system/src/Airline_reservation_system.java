import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class Airline_reservation_system {
    //<editor-fold desc="Initialisation">
    static String[][] aircraft_name = {{"A380","A318","A310","A330","A340","A350"},{"737","747","767","777","787"}};
    static String[] aircraft_manufacturer = {"airbus","boeing"};
    static ArrayList<Airline_reservation_system> flights = new ArrayList<>();
    static ArrayList<Integer> flight_number = new ArrayList<>();
    static ArrayList<String> flight_id = new ArrayList<>();
    //</editor-fold>
    public static void main(String[] args) throws FileNotFoundException {
        //<editor-fold desc="File reading & lists">
        File file = new File("C:\\Users\\decla\\Documents\\airliner-github\\Airline reservation system\\src\\aircrafts.txt");
        Scanner fileread = new Scanner(file).useDelimiter("\\Z");
        String aircrafts = fileread.nextLine();
        String seatletters = fileread.nextLine();
        String seatnumbers = fileread.nextLine();
        String[] aircraftlist = (aircrafts.substring(aircrafts.indexOf("{") + 1, aircrafts.indexOf("}")).split(" "));
//        String[][] seatletterslist = new String[][]{(seatletters.substring(seatletters.indexOf("{")+1,seatletters.indexOf("}")).split(","))};
        System.out.println((Arrays.toString(aircraftlist)));

        ArrayList<String[]> seatletterslist = new ArrayList<>();
//        System.out.println(Arrays.deepToString());
        for (int x = 0; x < aircraftlist.length; x++) {
            seatletterslist.add(seatletters.split("\\|"));
        }
        System.out.println((seatletterslist));
        ArrayList<ArrayList<ArrayList<String[]>>> seatnumberslist = new ArrayList<>(aircraftlist.length);
        seatnumberslist.add(new ArrayList<>());
//        System.out.println(Arrays.deepToString(seatletterslist));
        int y = 0;
        //</editor-fold>
//        System.out.println(Arrays.toString(seatletterslist));
        while (y < seatletters.substring(seatletters.indexOf("{") + 2, seatletters.indexOf("}")).replaceAll(",", "").length()) {
            String[] q = (seatnumbers.substring(seatnumbers.indexOf("{") + 1, seatnumbers.indexOf("}"))).split(" ");
            seatnumbers = seatnumbers.substring(seatnumbers.indexOf("}") + 1);
            seatnumberslist.get(0).add(new ArrayList<>());
            seatnumberslist.get(0).get(0).add(q);
            y += 1;
            System.out.println(Arrays.toString(q));
        }
        ArrayList<ArrayList<ArrayList<seat>>> seats = new ArrayList<>(seatletters.length());
        //<editor-fold desc="Description">
        for (int x = 0; x < seatnumberslist.get(0).get(0).size(); x++) {
            seats.add(new ArrayList<>());
            for (int z = 0; z < seatnumberslist.get(0).get(0).get(x).length; z++) {
                seats.get(x).add(new ArrayList<>());
                for (int b = 0; b < Integer.parseInt(seatnumberslist.get(0).get(0).get(x)[z]); b++) {
                    seats.get(x).get(z).add(new seat());
                }
            }
        }
        //</editor-fold>
























//        int x = 0;
//        while (true) {
//            Scanner main_menu = new Scanner(System.in);
//            while (true) {
//                String main = main_menu.nextLine();
//                if (main.equals("555")) {
//                    while (true) {
//                        while (true) {
//                            System.out.println("aircraft: ");
//                            String aircraft = main_menu.nextLine();
//                            if (checkaircraft(aircraft) != null) {
//                                addflight(x, aircraft, checkaircraft(aircraft));
//                                System.out.println("new flight confirmed, flight number " + x);
//                                x += 1;
//                                break;
//                            }
//                            System.out.println("that is not a valid aircraft");
//                        }
//                        System.out.println("do you want to add another flight? (y/n)");
//                        String another_aircraft = main_menu.nextLine();
//                        if (another_aircraft.equals("n")) {
//                            break;
//                        }
//                    }
//                }
//                if (main.equals("1")) {
//                    break;
//                }
//            }
//            System.out.println("flight number: ");
//            String flight_number = main_menu.nextLine();
//            System.out.println("type in your first name: ");
//            String Firstname = main_menu.nextLine();
//            System.out.println("type in your last name: ");
//            String Lastname = main_menu.nextLine();
//            flights.get(Integer.parseInt(flight_number)).availableseats(Integer.parseInt(flight_number));
//            System.out.println("type in what seat you want (letter/number): ");
//            String seat = main_menu.nextLine();
//            flights.get(Integer.parseInt(flight_number)).reserveseat(String.valueOf(seat.charAt(1)), String.valueOf(seat.charAt(0)), Firstname, Lastname, Integer.parseInt(flight_number));
//        }
//
    }
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
//    public static String checkaircraft(String aircraft){
//        int sublistaircraft = 0;
//        int numberofaircraft = 0;
//        if (aircraft.charAt(0) == '7'){
//            sublistaircraft = 1;
//        }
//        numberofaircraft = aircraft_name[sublistaircraft].length;
//        for (int z = 0; z<numberofaircraft;z++){
//            if (aircraft_name[sublistaircraft][z].equals(aircraft)){
//                return aircraft_manufacturer[sublistaircraft];
//            }
//        }
//        return null;
//    }
//
//    public static void addflight(Integer x,String aircraft,String aircraftmanufacturer){
//        flight_number.add(x);
//        flight_id.add("flight"+aircraftmanufacturer+aircraft+x);
//        flights.add(new Airline_reservation_system());
//    }
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
