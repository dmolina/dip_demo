package org.uca.dss.twitter;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
	public static class TestingModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(URLShortener.class).to(TinyUrlShortener.class);
			bind(Tweeter.class).to(SmsTweeter.class);
		}

	}
    public static void main( String[] args )
    {
    	Injector injector = Guice.createInjector(new TestingModule());
    	
    	Twitter tweet = injector.getInstance(Twitter.class);
        String user = "dss_uca";
        String url = "http://esingenieria.uca.es/centro/datos-del-centro/profesorado/";
        tweet.sendText("Creo que no lo entiendo", user);
        tweet.sendText("Si, creo que sí", user);
        
        tweet.sendText("Entendí lo de DIP! gracias a Daniel Molina y José Miguel, cuyos datos aparecen en " +url, user);
    }
}
