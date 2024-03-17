package Task4;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RealTimeArrayManager {
    private RealTimeArrayManager() {}

    public static Object createArray(Class<?> cls, int size){
        return Array.newInstance(cls, size);
    }

    public static Object createMatrix(Class<?> cls, int rowSize, int colSize){
        Object arr = Array.newInstance(cls.arrayType(), rowSize);
        for(int i = 0; i < rowSize; i++){
            Array.set(arr, i, Array.newInstance(cls, colSize));
        }
        return arr;
    }

    public static Object[] resizeArray(Object[] array, int newSize) {
        Class<?> cls = array.getClass().getComponentType();
        Object[] newArray = (Object[])Array.newInstance(cls, newSize);
        int length = Math.min(Array.getLength(array), newSize);
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    public static Object resizeMatrix(Object matrix, int newRowSize, int newColSize) {
        Class<?> type = matrix.getClass().getComponentType().getComponentType();
        Object newMatrix = Array.newInstance(type.arrayType(), newRowSize);
        int rows = Math.min(Array.getLength(matrix), newRowSize);
        for (int i = 0; i < rows; i++) {
            Object row = Array.get(matrix, i);
            Object newRow = Array.newInstance(type, newColSize);
            int cols = Math.min(Array.getLength(row), newColSize);
            System.arraycopy(row, 0, newRow, 0, cols);
            Array.set(newMatrix, i, newRow);
        }
        for (int i = rows; i < newRowSize; i++) {
            Object newRow = Array.newInstance(type, newColSize);
            Array.set(newMatrix, i, newRow);
        }
        return newMatrix;
    }

    public static String arrayToString(Object array) {
        return Arrays.toString((Object[])array);
    }

    public static String matrixToString(Object matrix) {
        return Arrays.deepToString((Object[])matrix);
    }
}
