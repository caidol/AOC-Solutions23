package day1;
// Java utility package below
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class day1 {
    public static void main(String[] args){
        // Create ArrayList objects for original values and digits only
        ArrayList<String> calibrationValues = new ArrayList<String>();
        ArrayList<String> digits = new ArrayList<String>();

        // Create a hashmap for mapping the words to digits
        HashMap<String, String> conversions = new HashMap<String, String>();
        List<String> hashmap_keys = new ArrayList<String>();

        // value is 54985

        hashmap_keys.add("one");
        hashmap_keys.add("two");
        hashmap_keys.add("three");
        hashmap_keys.add("four");
        hashmap_keys.add("five");
        hashmap_keys.add("six");
        hashmap_keys.add("seven");
        hashmap_keys.add("eight");
        hashmap_keys.add("nine");

        // Add keys and values (append certain letters on the end in case two words are combined
        conversions.put("one", "o1e");
        conversions.put("two", "t2o");
        conversions.put("three", "t3");
        conversions.put("four", "4");
        conversions.put("five", "5e");
        conversions.put("six", "6");
        conversions.put("seven", "7");
        conversions.put("eight", "8t");
        conversions.put("nine", "9");

        int totalCalibration = 0;

        readFile(calibrationValues);

        for (int calibration = 0; calibration < calibrationValues.size(); calibration++){
            String res = removeNonNumerical(calibrationValues.get(calibration));
            //String res = removeAllNonNumerical(calibrationValues.get(calibration), hashmap_keys, conversions);
            System.out.println(res);
            digits.add(res);
        }

        for (int digit = 0; digit < digits.size(); digit++){
            String res = digits.get(digit);
            if (res.length() > 2){
                String val = res.charAt(0) + String.valueOf(res.charAt(res.length() - 1));
                totalCalibration += Integer.valueOf(val);
            } else if (res.length() == 2) {
                totalCalibration += Integer.valueOf(res);
            } else if (res.length() == 1) {
                String val = res.charAt(0) + String.valueOf(res.charAt(0));
                totalCalibration += Integer.valueOf(val);
            }
        }

        //System.out.println("Total calibration value for day 1 part 1 is: " + total_calibration);
        System.out.println("Total calibration value for day 1 part 2 is: " + totalCalibration);
    }

    public static void readFile(ArrayList<String> calibration_values){
        try {
            File myObj = new File("src/main/java/day1/input1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // Add data to calibration values ArrayList
                calibration_values.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String removeNonNumerical(String calibration){
        String digits = "";
        for (int i = 0; i < calibration.length(); i++){
            char calibrationChar = calibration.charAt(i);

            if (Character.isDigit(calibrationChar)){
                char digit = calibration.charAt(i);

                digits += digit;
            }
        }

        return digits;
    }

    public static String removeAllNonNumerical(String calibration, List<String> hashmap_keys, HashMap<String, String> hashmap){
        String digits = "";
        for (int i = 0; i < calibration.length(); i++){
            for (int j = 0; j < hashmap_keys.size(); j++){
                if (calibration.contains(hashmap_keys.get(j))){
                    // retrieve the start index
                    //int start_index = calibration.indexOf(hashmap_keys.get(j));
                    calibration = calibration.replace(hashmap_keys.get(j), hashmap.get(hashmap_keys.get(j)));
                }
            }

            char calibration_char = calibration.charAt(i);

            if (Character.isDigit(calibration_char)){
                char digit = calibration.charAt(i);

                digits += digit;
            }
        }

        return digits;
    }
}
