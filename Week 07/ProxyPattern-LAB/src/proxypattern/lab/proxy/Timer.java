package proxypattern.lab.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Anish Panthi
 */
public class Timer implements InvocationHandler {

    private Object o;

    public Timer(Object o) {
        this.o = o;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = m.invoke(o, args);
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println("Timer: " + elapsedTimeMillis + " milliseconds to invoke " + m.getName());
        return result;
    }
}
