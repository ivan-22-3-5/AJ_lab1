package Task5;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements InvocationHandler{
    private Object obj;

    public TimeProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = method.invoke(obj, args);
        long finish = System.currentTimeMillis();
        System.out.println("\tScore time: " + (finish - start) + " ms");
        return res;
    }
}


