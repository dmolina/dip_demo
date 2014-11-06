package org.uca.dss.twitter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Twitter tweet = new Twitter();
        String user = "dss_uca";
        String url = "http://esingenieria.uca.es/centro/datos-del-centro/profesorado/";
        tweet.sendText("Creo que no lo entiendo", user);
        tweet.sendText("Si, creo que sí", user);
        
        tweet.sendText("Entendí lo de DIP! gracias a Daniel Molina y José Miguel, cuyos datos aparecen en " +url, user);
    }
}
