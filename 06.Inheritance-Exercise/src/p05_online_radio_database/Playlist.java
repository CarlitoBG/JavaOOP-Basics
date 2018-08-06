package p05_online_radio_database;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs;

    Playlist() {
        this.songs = new ArrayList<>();
    }

    void addSong(Song song){
        this.songs.add(song);
    }

    private String totalPlaylistLength(){
        int sumInSeconds = 0;

        for (Song song : this.songs) {
            String[] songTokens = song.getLength().split(":");
            int minutes = Integer.parseInt(songTokens[0]);
            int seconds = Integer.parseInt(songTokens[1]);

            sumInSeconds += ((minutes * 60) + seconds);
        }

        int hours = sumInSeconds / 3600;
        int minutes = (sumInSeconds % 3600) / 60;
        int seconds = sumInSeconds % 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %s", this.songs.size(), totalPlaylistLength());
    }
}