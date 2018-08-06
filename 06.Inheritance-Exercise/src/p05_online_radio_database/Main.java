package p05_online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songTokens = reader.readLine().split(";");
            String artistName = songTokens[0];
            String songName = songTokens[1];
            String songLength = songTokens[2];

            try {
                Song song = new Song(artistName, songName, songLength);
                playlist.addSong(song);
                System.out.println("Song added.");
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(playlist.toString());
    }
}