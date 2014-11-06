package org.uca.dss.twitter;

/**
 * This class send a tweet to an twitter user
 * @author daniel
 *
 */
public class SmsTweeter {
	/**
	 * send a text by twitter service (TODO)
	 * @param text to send.
	 * @param user to receive the text.
	 */
	public void send(String text, String user) {
		System.out.println(String.format("Enviado el mensaje '%s' a '%s'", text, user));
	}
}
