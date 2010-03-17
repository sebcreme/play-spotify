package controllers;

import play.mvc.*;
import play.libs.*;

import models.*;

public class Application extends Controller {

    public static void index(String query) throws Exception {
        if(query != null) {
            String xml = WS.url("http://ws.spotify.com/search/1/track").setParameter("q", query).get().getString();
            render(xml);            
        }
        render();
    }
    
    public static void play(String href) throws Exception {
        Spotify.play(href);
    }
    
    public static void close() throws Exception {
        Spotify.stop();
    }

}