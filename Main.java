
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the full name of the class: ");
        System.out.println(Analyzer.analyzeClass(Scan.scanStr()));

        Test test = new Test();
        System.out.println(Analyzer.analyzeObject(test));
        System.out.print("Enter the method to invoke: ");
        System.out.println(Invoker.invokeMethod(test, Scan.scanStr()));
        try {
            System.out.println(Invoker.invokeMethod(test, "sum", new TypedValue(4, int.class), new TypedValue(5, int.class)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}