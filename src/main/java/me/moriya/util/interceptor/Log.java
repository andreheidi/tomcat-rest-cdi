package me.moriya.util.interceptor;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.Logger;

import me.moriya.util.annotation.Logging;

@Logging
@Interceptor
public class Log {
	
	@Inject
	private Logger log;
	private Instant start;
	private Instant end;

	@AroundInvoke
	public Object logging(InvocationContext context) {
		try {
			String methodName = context.getMethod().getName();
			String className = context.getMethod().getDeclaringClass().getSimpleName();
			
			log.info(String.format("Entrou no metodo [ %s ] da classe [ %s ]", methodName, className));	
			
			log.info("Parametros recebidos:");
			for(int index = 0; index < context.getParameters().length; index++) {
				log.info(String.format("index: [ %s ] - value: [ %s ]", index, context.getParameters()[index]));
			}
			
			log.info(String.format("Executando metodo [ %s ]", methodName));
			start = Instant.now();
			Object result = context.proceed();
			end = Instant.now();
			log.info(String.format("Metodo [ %s ] executado sucesso", methodName));
			
			log.info(String.format("Metodo [ %s ] executado em [ %s ]", methodName, Duration.between(start, end)));			
			
			log.info(String.format("Resultado da execucao do metodo [ %s ]: [ %s ]", methodName, result));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erro ao executar o metodo [ logging ]");
			log.error(String.format("Causa: [ %s ]", e.getMessage().toUpperCase()));
		}
		
		return null;
	}
	
}