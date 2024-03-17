package Task5;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Main {

    public static Function<Integer> createProxy(Object obj, InvocationHandler handler) {
        return (Function<Integer>) Proxy.newProxyInstance(obj.getClass().getClassLoader() ,
                obj.getClass().getInterfaces(), handler);
    }

    public static void main(String[] args) {
        Function<Integer> fib = new Fibonacci();
        Function<Integer> timeCountingFib = createProxy(fib, new TimeProxy(fib));
        Function<Integer> tracingFib = createProxy(fib, new InfoProxy(fib));

        System.out.println("Start calculations:");
        for (int x = 30; x < 40; x += 1) {
            System.out.println("f(" + x + ") = " + timeCountingFib.apply(x));
            System.out.println(tracingFib.apply(x));
        }
    }
}

