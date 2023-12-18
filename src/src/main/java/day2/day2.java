package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day2 {
    final static int RED_LIMIT = 12;
    final static int GREEN_LIMIT = 13;
    final static int BLUE_LIMIT = 14;

    public static void main(String[] args){
        ArrayList<String> input_data = new ArrayList<String>();
        HashMap<String, Integer> colour_max = new HashMap<String, Integer>();

        colour_max.put("red", 12);
        colour_max.put("green", 13);
        colour_max.put("blue", 14);

        readFile(input_data);
        //int answer1 = problem1(input_data);
        //System.out.println("Answer to day 1 is: " + answer1);
        int answer2 = problem2(input_data);
        System.out.println("Answer to day 2 is: " + answer2);
    }

    public static void readFile(ArrayList<String> input_data){
        File myObj = new File("src/src/main/java/day2/input2.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input_data.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static int problem1(ArrayList<String> input_data){
        int answer = 0;
        boolean isGreater = false;

        for (String line : input_data){
            String games = (line.split(": ")[1]);
            String game_id = ((line.split(":")[0]).split(" "))[1];
            //System.out.println("Game ID: " + game_id);

            //System.out.println("Games: " + games);
            String[] sets = games.split("; ");
            for (String set : sets){
                String[] cubes = set.split(", ");

                for (String colours : cubes){
                    String[] colour = colours.split(" ");

                    if (colour[1].contains("red")){
                        int amount = Integer.parseInt(colour[0]);
                        //System.out.println("amount: " + amount);
                        if (amount > RED_LIMIT){
                            isGreater = true;
                        }
                    }
                    if (colour[1].contains("green")){
                        int amount = Integer.parseInt(colour[0]);
                        //System.out.println("amount: " + amount);
                        if (amount > GREEN_LIMIT){
                            isGreater = true;
                        }
                    }
                    if (colour[1].contains("blue")){
                        int amount = Integer.parseInt(colour[0]);
                        //System.out.println("amount: " + amount);
                        if (amount > BLUE_LIMIT){
                            isGreater = true;
                        }
                    }
                }
            }

            if (!isGreater){
                //System.out.println("ANSWER IS: " + game_id);
                answer += Integer.parseInt(game_id);
            }
            else {
                isGreater = false;
            }
        }

        return answer;
    }

    public static int problem2(ArrayList<String> input_data){
        int answer = 0;
        boolean isGreater = false;

        int red = 0;
        int green = 0;
        int blue = 0;

        for (String line : input_data){
            String games = (line.split(": ")[1]);

            String[] sets = games.split("; ");
            for (String set : sets){
                String[] cubes = set.split(", ");

                for (String colours : cubes){
                    String[] colour = colours.split(" ");

                    if (colour[1].contains("red")){
                        int amount = Integer.parseInt(colour[0]);
                        if (amount > red){
                            red = amount;
                        }
                    }
                    if (colour[1].contains("green")){
                        int amount = Integer.parseInt(colour[0]);
                        if (amount > green){
                            green = amount;
                        }
                    }
                    if (colour[1].contains("blue")){
                        int amount = Integer.parseInt(colour[0]);
                        if (amount > blue){
                            blue = amount;
                        }
                    }
                }
            }

            answer += (red * green * blue);
            red = 0;
            green = 0;
            blue = 0;
        }

        return answer;
    }
}
