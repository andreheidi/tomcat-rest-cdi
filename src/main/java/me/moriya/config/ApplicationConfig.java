package me.moriya.config;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.common.collect.Sets;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> clazz = Sets.newHashSet();
		return Collections.emptySet();
	}
	
}