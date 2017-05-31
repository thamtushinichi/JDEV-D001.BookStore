package jvd001.bookstore.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CheckLogin {
	@Before("execution(* jvd001.bookstore.app.controller.bookmanagement.*.*(..))")
	public void before(JoinPoint joinPoint)
	{
		System.out.println("done");
	}
	
}
