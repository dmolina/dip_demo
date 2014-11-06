package org.uca.dss.twitter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;


import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * This class shorter the URLs into a text using the service tinyurl.com
 * @author daniel
 *
 */
public class TinyUrlShortener implements URLShortener {
	
	private List<String> detectURLs(String text) {
		// separate input by spaces ( URLs don't have spaces )
		String [] parts = text.split("\\s+");
		List<String> urls = new LinkedList<String>();

		// Attempt to convert each item into an URL.   
		for( String item : parts ) {
			try{
				URL url = new URL(item);
				urls.add(item);
			} catch (MalformedURLException e) {
			}
		}
		
		return urls;
	}
	
	/* (non-Javadoc)
	 * @see org.uca.dss.twitter.uRLShortener#shorten(java.lang.String)
	 */
	public String shorten(String text) {
		String newText = text;
		List<String> urls = detectURLs(text);
		CloseableHttpClient httpclient = HttpClients.createDefault();
        
		for (String url : urls) {
			// Prepare a request object
			List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>(); 
			params.add(new BasicNameValuePair("url", url));
			// Encode the URL
			String param_str = URLEncodedUtils.format(params, "utf-8");
			HttpGet method = new HttpGet("http://tinyurl.com/api-create.php?" + param_str); 
		
			String tinyUrl = "";
			
			try {
				// Get the new tinyURL
				CloseableHttpResponse response = httpclient.execute(method);
				 tinyUrl = IOUtils.toString(response.getEntity().getContent(), "utf-8");
			} catch (ClientProtocolException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			method.releaseConnection();
			newText = newText.replace(url, tinyUrl);
		}
		
		return newText;
	}

}
