import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\decla\\Documents\\Airline reservation system\\src\\aircrafts.txt");
        Scanner fileread =new Scanner(file).useDelimiter("\\Z");
        String aircrafts = fileread.nextLine();
        String seatletters = fileread.nextLine();
        String seatnumbers = fileread.nextLine();
        System.out.println(seatletters.substring(seatletters.indexOf("{")+2,seatletters.indexOf("}")).replaceAll(",","").length());
        String[][] aircraftlist = new String[][]{(aircrafts.substring(aircrafts.indexOf("{") + 1,aircrafts.indexOf("}")).split(",")),(aircrafts.substring(aircrafts.indexOf("}")+3,aircrafts.length()-1)).split(",")};
        String[][] seatletterslist = new String[][]{(seatletters.substring(seatletters.indexOf("{")+2,seatletters.indexOf("}")).split(","))};
        ArrayList<ArrayList<ArrayList<String[]>>> seatnumberslist = new ArrayList<>(aircraftlist.length);
        seatnumberslist.add(new ArrayList<>());
        int y = 0;
        System.out.println("fdajskfjdskaj");
        while (y<seatletters.substring(seatletters.indexOf("{")+2,seatletters.indexOf("}")).replaceAll(",","").length()){
            String[] q = (seatnumbers.substring(seatnumbers.indexOf("{") + 1, seatnumbers.indexOf("}"))).split(" ");
            seatnumbers = seatnumbers.substring(seatnumbers.indexOf("}")+1);
            seatnumberslist.get(0).add(new ArrayList<>());
            seatnumberslist.get(0).get(0).add(q);
            y += 1;
        }
        System.out.println("fdajskfjdskaj");
        ArrayList<ArrayList<Integer>> seats = new ArrayList<>(seatletters.length());
        System.out.println(seats);
        for (int x = 0;x<seatnumberslist.get(0).get(0).size();x++){
            seats.add(new ArrayList<>());
            for (int z = 0; z<seatnumberslist.get(0).get(0).get(x).length;z++){
                seats.get(x).add(Integer.parseInt(seatnumberslist.get(0).get(0).get(x)[z]));
            }
        }
        System.out.println(seats);

//        System.out.println(seats.get(0).get(0));
//        for (int x = 0; x<seatletters.length();x++){
//            for (int z = 0; z<seats.get(x).size();z++){
//                for (int p = 0; p<seats.get(x).get(z);p++){
//
//                }
//            }
//        }

        //while (true){
        //    y = y+1;
        //    seatnumbers = seatnumbers.substring(seatnumbers.indexOf("{"));
            //System.out.println(seatnumbers);
        //    if (y == 5){
        //        break;
    }
}
        //System.out.println(Arrays.deepToString(seatnumberslist));











        //String[][] aircraftlist = new String[][]{(aircrafts.substring(aircrafts.indexOf("{") + 1,aircrafts.indexOf("}")).split(",")),(aircrafts.substring(aircrafts.indexOf("}")+3,aircrafts.length()-1)).split(",")};
        //String[][] seatletterslist = new String[][]{(seatletters.substring(aircrafts.indexOf("{") + 1,seatletters.indexOf("}")).split(",")),(seatletters.substring(seatletters.indexOf("}")+3,seatletters.length()-1)).split(",")};
        //System.out.println((aircraftlist[0][0]));
        //System.out.println(seatletters);
        //System.out.println(seatnumbers);

