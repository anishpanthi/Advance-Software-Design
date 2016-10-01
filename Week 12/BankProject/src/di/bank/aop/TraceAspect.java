package di.bank.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TraceAspect {
	
	@After("execution(* di.bank.dao.AccountDAO.*(..))")
	public void traceMethodCreateAccount(JoinPoint joinPoint) {
		System.out.println(new Date() + " method called= " + joinPoint.getSignature().getName());

	}
	
	@Around("execution(* di.bank.service.AccountService.*(..)) || execution(* di.bank.service.AccountService.*())")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute "+call.getSignature().getName()+" = "+totaltime);

		return retVal;
	}
	
	@After("execution(* di.bank.dao.AccountDAO.*())")
	public void traceMethodGetAllAccounts(JoinPoint joinPoint) {
		System.out.println(new Date() + " method called= " + joinPoint.getSignature().getName());

	}
	
}