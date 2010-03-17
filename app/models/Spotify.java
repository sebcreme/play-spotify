package models;

import play.*;

import java.util.*;

import de.felixbruns.jotify.*;
import de.felixbruns.jotify.media.*;
import de.felixbruns.jotify.player.*;

public class Spotify {
    
    static JotifyConnection connection;
    
    static synchronized JotifyConnection connection() throws Exception {
        if(connection == null) {
            connection = new JotifyConnection();
            connection.login(Play.configuration.getProperty("spotify.username"), Play.configuration.getProperty("spotify.password"));
        }
        return connection;
    }

    public static void play(String track) throws Exception {
        stop();
        Track t = connection().browseTrack(track);
        connection().play(t, new PlaybackAdapter());
    }
    
    public static void stop() throws Exception {
        connection().stop();
    }
    
}

