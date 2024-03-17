package Tasks123;

import java.lang.reflect.*;

public class Invoker {
    private Invoker(){}

    public static Object invokeMethod(Object obj, String method){
        try {
            Method methodToCall = obj.getClass().getMethod(method);
            return methodToCall.invoke(obj);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            return e;
        }
    }

    public static Object invokeMethod(Object obj, String methodName, TypedValue... args) throws FunctionNotFoundException {
        try {
            Class<?> objClass = obj.getClass();

            Class<?>[] parameterTypes = new Class[args.length];
            Object[] parameterValues = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getType();
                parameterValues[i] = args[i].getValue();
            }

            Method method = objClass.getMethod(methodName, parameterTypes);
            return method.invoke(obj, parameterValues);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new FunctionNotFoundException("Method " + methodName + " hasn't been found or cannot be invoked");
        }
    }
}
