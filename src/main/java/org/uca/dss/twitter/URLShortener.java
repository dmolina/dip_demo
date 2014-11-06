package org.uca.dss.twitter;

public interface URLShortener {

	/**
	 * Short the URLs contained in a text
	 * @param text to reduce
	 * @return the text with the reduced URLs
	 */
	public abstract String shorten(String text);

}