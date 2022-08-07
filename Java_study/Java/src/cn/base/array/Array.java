package cn.base.array;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot java.base.array.java.base.array
 * @date 2022/7/31-20:22
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Array {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {4, -1, 9, 10, 23};
        arrayMaxNumber(array);
    }

    /**
     * 求数组中的最大值
     * @param array 数组
     */
    public static void arrayMaxNumber(int[] array) {
        int subscript = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[subscript] < array[i]) {
                subscript = i;
            }
        }
        System.out.println("max value is:" + array[subscript]);
    }
}
