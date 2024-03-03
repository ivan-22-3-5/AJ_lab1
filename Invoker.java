import java.lang.reflect.*;

public class Invoker {
    private Invoker(){}

    public static Object invokeMethod(Object obj, String method){
        try {
            Method methodToCall = obj.getClass().getMethod(method);
            return methodToCall.invoke(obj);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            return e.getMessage();
        }
    }
}
