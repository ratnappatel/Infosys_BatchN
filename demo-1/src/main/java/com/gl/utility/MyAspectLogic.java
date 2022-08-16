package com.gl.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectLogic {
	
	private final Log LOGGER=LogFactory.getLog(MyAspectLogic.class);
	
	@Before("execution(* com.gl.persistence.*AOP.print*(..))")
	public void beforeMethod()
	{
		System.out.println("Before Advice is called..");
		LOGGER.info("Before PrintFibonacci is called..");
	}

}
