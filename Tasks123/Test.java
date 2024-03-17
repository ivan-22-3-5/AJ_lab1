package Tasks123;

public class Test {
    private final int field1;
    private final String field2;
    public String field3;
    private static String field4;
    public static int field5;

    public Test(){
        field1 = 1;
        field2 = "QWERTY";
        field3 = "I'm public";
        field4 = "I'm static";
        field5 = 54321;
    }

    public String hello(){
        return "Hello, World!";
    }

    public String love(){
        return "I love you, World!!!";
    }

    public String bye(){
        return "Bye, World!";
    }

    public int nineOneOne(){
        return 911;
    }

    public int sum(int a, int b){
        return a + b;
    }

    private int privateMethod(){
        return 1489;
    }
}
