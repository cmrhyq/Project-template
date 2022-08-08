package cn.base.array;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.base.array.ArrayAssign
 * @date 2022/8/8-1:16
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayAssign {

    public static void main(String[] args) {
        int[] array = {66, 55, 44, 33, 22, 11};
        int[] list = arrayReverse(array);
        for (int i = 0; i < list.length; i++) {
            System.out.println("list = " + list[i]);
        }
    }

    /**
     * 数组分配机制
     */
    public static void arrayAssign() {
        // 基本数据类型复制，复制方向为值拷贝
        // n2的变化不会影响n1的值
        int n1 = 10;
        int n2 = n1;
        n2 = 80;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        // 数组默认情况使用的是引用传递，赋的值是地址，赋值方式为引用传递
        // 所以arr2的赋值会影响arr1的值
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 9;
        System.out.println("arr1 = " + arr1[0]);
        System.out.println("arr2 = " + arr2[0]);
    }

    /**
     * 复制数组1的值到数组2
     */
    public static void arrayCopy() {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2 = " + arr2[i]);
        }
    }

    /**
     * 数组反转
     *
     * @param array array
     * @return int[]
     */
    public static int[] arrayReverse(int[] array) {
        int[] reverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[(array.length - 1) - i];
        }
        return reverse;
    }
}
