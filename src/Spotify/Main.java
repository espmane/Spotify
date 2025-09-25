package Spotify;

import java.util.Scanner;

public class Main {
    private static final Spotify spotify = new Spotify();
    private static final Scanner scanner = new Scanner(System.in);
    private static SpotiFyle fyle = new SpotiFyle();

    private static UserType userType = null;

    private static void clearScreen() {
        // Heck3er05
        System.out.println("     ".repeat(50000));
    }

    private static void readUserType() {
        System.out.println("""
                Salutation traveler, which type of user are you?
                1: Free
                2: Premium
                """);

        while (userType == null) {
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "free":
                case "1":
                    userType = UserType.Broke;
                    break;
                case "premium":
                case "2":
                    userType = UserType.Premium;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }

    private static void createSong() {
        if (userType == UserType.Broke) {
            SpotifyAd.printAd(5);
        }
        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            spotify.createSong(title, genre);
        } catch (Exception exception) {
            System.err.println("Failed to create song: " + exception.getMessage());
        }
    }


    private static void removeSong() {
        if (userType == UserType.Broke) {
            SpotifyAd.printAd(5);
        }
        System.out.println(spotify.toString());
        System.out.println("Which song would you like to remove?");
        String song2 = scanner.nextLine();
        spotify.removeSong(song2);
    }

    private static void showSongs() {
        if (userType == UserType.Broke) {
            SpotifyAd.printAd(5);
        }
        System.out.println("Here's a list of your songs in your library: ");
        spotify.toString();
    }

    private static void renameSong() {
        if (userType == UserType.Broke) {
            SpotifyAd.printAd(5);
        }

        System.out.println(spotify.toString());

        System.out.println("Which song would you like to rename?");
        String songName = scanner.nextLine();

        System.out.println("What would you like to rename " + spotify.findSong(songName) + " to?");
        String renameOfSong = scanner.nextLine();

        spotify.renameSong(songName, renameOfSong);

    }

    public static void makeFileWithSongs(){
        System.out.println("What would you like to name your file?: ");
        fyle.setName(scanner.nextLine());
        fyle.createFile();
        fyle.writeFile();
    }


    private static void searchForSong() {
        if (userType == UserType.Broke) {
            SpotifyAd.printAd(5);
        }
        System.out.println("Which song would you like to search for?: ");
        String songName = scanner.nextLine();

        Sang song = spotify.findSong(songName);
        if (spotify.songExists(songName)) {
            System.out.println(song.toString() + " does exist!");
        } else  {
            System.out.println(song.toString() + " does NOT exist!");
        }
    }


    public static void main(String[] args) {
        readUserType();
        System.out.println("-".repeat(20));

        if (userType.equals(UserType.Broke)) {
            SpotifyAd.printWelcome();
            clearScreen();
        }

        System.out.println("Welcome to Spotify " + userType.toString() + " user!");
        System.out.println("-".repeat(20));

        boolean exit = false;
        while (!exit) {
            if (userType.equals(UserType.Broke)) {
                SpotifyAd.printAd(5);
            }

            System.out.println("Here's a list of the songs in your library: ");
            System.out.println(spotify);
            System.out.println("-".repeat(20));

            System.out.println("""
                    What would you like to do?
                    1: Add a song
                    2: Remove a song
                    3: Show all your songs
                    4: Rename one of your songs
                    5: Search for a song
                    6: Make a file of your songs
                    8: Exit
                    """);

            int whichAction = scanner.nextInt();
            scanner.nextLine();

            switch (whichAction) {
                case 1:
                    createSong();
                    break;
                case 2:
                    removeSong();
                    break;
                case 3:
                    showSongs();
                    break;
                case 4:
                    renameSong();
                    break;
                case 5:
                    searchForSong();
                case 6:
                    makeFileWithSongs();
                case 7:
                    exit = true;
            }
        }
    }
}