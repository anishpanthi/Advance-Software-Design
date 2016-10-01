package customers;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TraceAspect {

	@Around("execution(* customers.CustomerService.addCustomer(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save = "+totaltime);

		return retVal;
	}

	@After("execution(* customers.EmailSender.sendEmail(..))")
	public void traceMethod(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(new Date() + " method= " + joinPoint.getSignature().getName() + " address="
				+ args[0].toString() + " message= " + args[1].toString());

		EmailSender emailSender = (EmailSender) joinPoint.getTarget();
		System.out.println("outgoing mail server= " + emailSender.getOutgoingMailServer());

	}

}
