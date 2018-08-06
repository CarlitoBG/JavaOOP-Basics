package p05_online_radio_database;

public class Song {

    private String artistName;
    private String songName;
    private String length;

    Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    public String getLength() {
        return this.length;
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ARTIST_NAME_EXCEPTION);
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName == null || songName.length() < 3 || songName.length() > 30){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SONG_NAME_EXCEPTION);
        }
        this.songName = songName;
    }

    private void setLength(String length) {
        String[] lengthTokens = length.split(":");
        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(lengthTokens[0]);
            seconds = Integer.parseInt(lengthTokens[1]);
        }catch (IllegalArgumentException iae){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SONG_LENGTH_EXCEPTION);
        }

        if (minutes < 0 || minutes > 14){
            throw  new IllegalArgumentException(ExceptionMessages.INVALID_SONG_MINUTES_EXCEPTION);
        }

        if (seconds < 0 || seconds > 59){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SONG_SECONDS_EXCEPTION);
        }

        this.length = length;
    }
}