package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
	@After("execution(com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}

	@AfterReturning("execution(* *..*.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("--- AfterReturning Advice ---");
	}

	@AfterThrowing(value="execution(* *..*.ProductService.find(..))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("--- AfterThrowing Advice :" + ex + "---");
	}
	
	@Around("execution(* *..*.ProductService.*(String))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		/* before */
		System.out.println("--- Around(Before) Advice ---");
		
		/* Point Cut Method 실행 */
		
		// Object[] parameters = {"Camera"};
		// Object result = pjp.proceed(parameters);
		
		Object result = pjp.proceed();
		
		/* after */
		System.out.println("--- Around(After) Advice ---");
		
		return result;
	}
	
}
