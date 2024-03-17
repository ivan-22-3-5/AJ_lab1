package Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InfoProxy implements InvocationHandler {
    private Object obj;

    public InfoProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(method.getName() + Arrays.toString(args) + " = ");
        return method.invoke(obj, args);
    }
}
