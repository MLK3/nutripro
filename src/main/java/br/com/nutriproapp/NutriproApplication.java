package br.com.nutriproapp;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class NutriproApplication extends ResourceConfig {

	public NutriproApplication() {
		
		packages("br.com.nutriproapp");
		register(JacksonFeature.class);
	}
}
