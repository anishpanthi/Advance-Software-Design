package proxypattern.lab.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import proxypattern.lab.dao.IAccountDAO;

/**
 *
 * @author Anish Panthi
 */
public class Logger implements InvocationHandler {

    private IAccountDAO dao;

    public Logger(IAccountDAO dao) {
        this.dao = dao;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.println("Logger: Invoking " + m.getName());
        return m.invoke(dao, args);
    }

}
