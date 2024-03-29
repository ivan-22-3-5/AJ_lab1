package Task4;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = (int[][]) RealTimeArrayManager.createMatrix(int.class, 6, 4);
        matrix[0][0] = 4;
        matrix[5][3] = 1;
        System.out.println("matrix: " + RealTimeArrayManager.matrixToString(matrix));
        matrix = (int[][]) RealTimeArrayManager.resizeMatrix(matrix, 4, 4);
        System.out.println("matrix: " + RealTimeArrayManager.matrixToString(matrix));

        int[] arr = (int[])RealTimeArrayManager.createArray(int.class, 7);
        System.out.println("\narr: " + RealTimeArrayManager.arrayToString(arr));
        arr[0]=4;
        arr[1]=9;
        arr[6]=1;
        System.out.println("arr: " + RealTimeArrayManager.arrayToString(arr));
        arr = (int[]) RealTimeArrayManager.resizeArray(arr, 4);
        System.out.println("arr: " + RealTimeArrayManager.arrayToString(arr));
    }
}
