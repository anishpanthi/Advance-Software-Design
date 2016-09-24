package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");       
		IGreeting greetingService = context.getBean("greetingService", IGreeting.class);
		greetingService.sayHello();
	}
}
