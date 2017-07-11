package me.moriya.util.factory;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory implements Serializable {

	private static final long serialVersionUID = -8100521698814906724L;

	@Produces
	public Logger createLogger(InjectionPoint point) {
		Class<?> declaringClass = point.getMember().getDeclaringClass();
		
		return LogManager.getLogger(declaringClass);
	}
}