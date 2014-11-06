package org.uca.dss.twitter;

/**
 * This class allow us to send tweets
 * @author daniel
 *
 */
public class Twitter {
	/**
	 * Send a new tweet.
	 * 
	 * This method check the length, if length is greater than 140, it throw an exception.
	 * The URLs are reduced to get more space for real text.
	 * 
	 * @param text to send
	 * @param user to receive the text
	 */
	public void sendText(String text, String user) {
		
		if (text.length() > 140) {
			// uses the tinyURL 
			TinyUrlShortener shortener = new TinyUrlShortener();
			text = shortener.shorten(text);
		}
		
		if (text.length() <= 140) {
			SmsTweeter tweeter = new SmsTweeter();
			tweeter.send(text, user);
		}
		else {
			throw new RuntimeException(String.format("Error, msg '%s' is too long", text));
		}

	}
}
