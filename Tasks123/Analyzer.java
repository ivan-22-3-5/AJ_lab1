package Tasks123;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Analyzer {
    private Analyzer(){}

    public static String analyzeClass(String className) {
        Class<?> cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e){
            return e.toString();
        }
        return analyzeClass(cls);
    }

    public static String analyzeClass(Class<?> cls) {
        StringBuilder sb = new StringBuilder();

        Package pkg = cls.getPackage();
        if (pkg != null) {
            sb.append("Package: ").append(pkg.getName()).append("\n");
        }

        int modifiers = cls.getModifiers();
        sb.append("Modifiers: ").append(Modifier.toString(modifiers)).append("\n");
        sb.append("Class: ").append(cls.getSimpleName()).append("\n");

        Class<?> superclass = cls.getSuperclass();
        if (superclass != null) {
            sb.append("Superclass: ").append(superclass.getName()).append("\n");
        }

        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            StringJoiner joiner = new StringJoiner(", ");
            for (Class<?> i : interfaces) {
                joiner.add(i.getName());
            }
            sb.append("Implemented Interfaces: ").append(joiner).append("\n");
        }

        Field[] fields = cls.getDeclaredFields();
        if (fields.length > 0) {
            sb.append("Fields:\n");
            for (Field field : fields) {
                sb.append("\t").append(Modifier.toString(field.getModifiers()))
                        .append(" ")
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append("\n");
            }
        }

        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        if (constructors.length > 0) {
            sb.append("Constructors:\n");
            for (Constructor<?> constructor : constructors) {
                sb.append("\t")
                        .append(Modifier.toString(constructor.getModifiers()))
                        .append(" ")
                        .append(cls.getSimpleName())
                        .append("(");
                String params = Arrays.stream(constructor.getParameterTypes())
                        .map(Class::getSimpleName)
                        .collect(Collectors.joining(", "));
                sb.append(params).append(")\n");
            }
        }

        Method[] methods = cls.getDeclaredMethods();
        if (methods.length > 0) {
            sb.append("Methods:\n");
            for (Method method : methods) {
                sb.append("\t")
                        .append(Modifier.toString(method.getModifiers()))
                        .append(" ")
                        .append(method.getReturnType().getSimpleName())
                        .append(" ")
                        .append(method.getName())
                        .append("(");
                String params = Arrays.stream(method.getParameterTypes())
                        .map(Class::getSimpleName)
                        .collect(Collectors.joining(", "));
                sb.append(params).append(")\n");
            }
        }
        return sb.toString();
    }

    public static String analyzeObject(Object obj) {
        StringBuilder result = new StringBuilder();

        Class<?> objClass = obj.getClass();
        result.append("Object type: ").append(objClass.getSimpleName()).append("\n");

        result.append("Object state:\n");
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                result.append("\t").append(field.getName()).append(" = ").append(field.get(obj)).append("\n");
            } catch (IllegalAccessException e) {
                return e.toString();
            }
        }

        result.append("Open methods:\n");
        Method[] methods = objClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0 && Modifier.isPublic(method.getModifiers())) {
                result.append("\t").append(method.getName()).append("\n");
            }
        }

        return result.toString();
    }

}
