package hello;

public class GreetingImpl implements IGreeting {
	private String greeting;

	public GreetingImpl() {
	}

	public GreetingImpl(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting);
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
