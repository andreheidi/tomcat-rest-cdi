package me.moriya.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationResource extends ResourceConfig {

	public ApplicationResource() {
		packages(true, "me.moriya.controller");
	}
	
}