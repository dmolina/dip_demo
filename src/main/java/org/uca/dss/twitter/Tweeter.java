package org.uca.dss.twitter;

public interface Tweeter {

	/**
	 * send a text by twitter service.
	 * @param text to send.
	 * @param user to receive the text.
	 */
	public abstract void send(String text, String user);

}