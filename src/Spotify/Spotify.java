package Spotify;

import java.util.ArrayList;


public class Spotify {
    private final ArrayList<Sang> songs = new ArrayList<>();

    public void createSong(String title, String genreStr) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Invalid title");

        if (genreStr == null || genreStr.isBlank())
            throw new IllegalArgumentException("Invalid genre");

        Genre genre = switch (genreStr.toLowerCase()) {
            case "rock" -> Genre.ROCK;
            case "metal" -> Genre.METAL;
            case "pop" -> Genre.POP;
            case "jazz" -> Genre.JAZZ;
            default -> throw new IllegalStateException("Invalid genre");
        };

        Sang song = new Sang(title, genre);
        if (!songs.add(song))
            throw new IllegalStateException("Song already exists");
    }

    public void removeSong(String title) {
        Sang song = findSong(title);
        if (song == null)
            throw new RuntimeException("Song not found");

        songs.remove(song);
    }

    public Sang findSong(int index) {
        if (index < 0 || index >= songs.size())
            throw new IndexOutOfBoundsException("Index out of bounds");

        return songs.get(index);
    }

    public Sang findSong(String title) throws IllegalArgumentException, NullPointerException {
        if (title == null)
            throw new IllegalArgumentException("Title is null");

        if (title.isBlank())
            throw new IllegalArgumentException("Title is blank");

        for (Sang song : songs) {
            if (title.equalsIgnoreCase(song.getTitle()))
                return song;
        }

        throw new NullPointerException("No such song");
    }

    public ArrayList<Sang> getSongs() {
        return songs;
    }

    public boolean songExists(String title) {
        for (Sang song : songs) {
            if (title.equalsIgnoreCase(song.getTitle()))
                return true;
        }
        return false;
    }

    public boolean renameSong(String oldTitle, String newTitle) {
        Sang renameSong = findSong(oldTitle);
        if (renameSong != null) {
            renameSong.setTitle(newTitle);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String builder = "";
        for (int i = 0; i < songs.size(); i++) {
            builder += i + 1 + ": " + songs.get(i).toString();
            builder += "\n";
        }
        return builder;
    }
}