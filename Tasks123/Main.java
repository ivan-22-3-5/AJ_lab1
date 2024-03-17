package Tasks123;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the full name of the class: ");
        System.out.println(Analyzer.analyzeClass(Scan.scanStr()));

        Test test = new Test();
        System.out.println(Analyzer.analyzeObject(test));
        System.out.print("Enter the method to invoke: ");
        System.out.println(Invoker.invokeMethod(test, Scan.scanStr()));

        try {
            int a = 4;
            int b = 5;
            System.out.println("test.sum(" + a + ", " + b + ") = " + Invoker.invokeMethod(test, "sum", new TypedValue(a, int.class), new TypedValue(b, int.class)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}