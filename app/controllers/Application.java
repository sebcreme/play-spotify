package controllers;

import play.mvc.*;
import play.libs.*;

import org.w3c.dom.*;

public class Application extends Controller {

    public static void index(String query) throws Exception {
        if(query != null) {
            String xml = WS.url("http://ws.spotify.com/search/1/track?q=" + query).get().getString();
            render(xml);            
        }
        render();
    }
    
    public static void play(String href) throws Exception {
        Runtime.getRuntime().exec("open " + href);
    }
    
    public static void close() throws Exception {
        Runtime.getRuntime().exec("killall Spotify");
    }

}