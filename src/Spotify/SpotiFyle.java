package Spotify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SpotiFyle {
    private static final Scanner scanner = new Scanner(System.in);
    private static Spotify spotify = new Spotify();
    static String fileName;

    //getter
    public static String getName(){
        return fileName+".txt";
    }

    public void setName(String fileName){
        this.fileName = fileName;
    }

    public static void writeFile(){
        try {
            FileWriter myWriter = new FileWriter(getName());
            System.out.println("contents: " + spotify.toString());
            System.out.println("name: " + getName());

            myWriter.write(content);
            myWriter.close();  // must close manually

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createFile() {
        try {
            File myObj = new File(fileName + ".txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
