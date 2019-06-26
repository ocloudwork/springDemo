package com.ocloudwork.spring.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
   *    扫描方式
 */

@Aspect
@Component
public class DemoAspect {

	@Pointcut("execution(* com.ocloudwork.spring.demo.service.impl.*.*(..))")
	public void pointCut() {
	}

	//在目标方法被调用之前做增强处理,@Before只需要指定切入点表达式即可
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("AOP Before Advice...");
	}
	//在目标方法完成之后做增强，无论目标方法时候成功完成。@After可以指定一个切入点表达式
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("AOP After Advice...");
	}
	//在目标方法正常完成后做增强,@AfterReturning除了指定切入点表达式后，
	//还可以指定一个返回值形参名returning,代表目标方法的返回值
	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturn(JoinPoint joinPoint, Object returnVal) {
		System.out.println("AOP AfterReturning Advice:" + returnVal);
	}

	// 主要用来处理程序中未处理的异常,@AfterThrowing除了指定切入点表达式后，
	// 还可以指定一个throwing的返回值形参名,可以通过该形参名
	//来访问目标方法中所抛出的异常对象
	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("AOP AfterThrowing Advice..." + error);
		System.out.println("AfterThrowing...");
	}

	// 环绕通知,在目标方法完成前后做增强处理,环绕通知是最重要的通知类型,像事务,日志等都是环绕通知,
	// 注意编程中核心是一个ProceedingJoinPoint
//	@Around("pointCut()")
//	public void around(ProceedingJoinPoint pjp) {
//		System.out.println("AOP Aronud before...");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("AOP Aronud after...");
//	}

}