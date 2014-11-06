package org.uca.dss.twitter;

import com.google.inject.AbstractModule;

public class TestingModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(URLShortener.class).to(TinyUrlShortener.class);
		bind(Tweeter.class).to(SmsTweeter.class);
	}

}
