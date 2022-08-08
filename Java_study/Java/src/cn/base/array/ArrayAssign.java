package cn.base.array;

/**
 * <h1 style="color:white">数组相关学习</h1>
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
        int[] array = {66, 55, 44, 33, 22, 11, 99};
        int[] list = arrayReverse1(array);
        for (int i = 0; i < list.length; i++) {
            System.out.println("list = " + list[i]);
        }
    }

    /**
     * <h2 style="color:white">数组分配机制</h2>
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
     * <h2 style="color:white">复制数组1的值到数组2</h2>
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
     * <h2 style="color:white">数组反转 - 方法1</h2>
     * <p>使用一个新的数组reverse[]来接收数组反转的值</p>
     * <div style="margin: 0 0 0 15px">
     *     <p>reverse[] 从0 - array.length 正序接收 array[] 的值</p>
     *     <p>array[] 倒着将值赋给 reverse[]，而倒着赋值时 array[] 的下标为 (array.length - 1) - i</p>
     * </div>
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

    /**
     * <h2 style="color:white">数组反转 - 方法2</h2>
     * <p>假定 n为数组长度，i为交换次数，则可以推导</p>
     * <div style="margin: 0 0 0 15px">
     *     <p>第一次，把 array[i-1] 和 array[n-i] 进行交换</p>
     *     <p>第二次，把 array[i-2] 和 array[n-i] 进行交换</p>
     *     <p>第三次，把 array[i-3] 和 array[n-i] 进行交换</p>
     *     <p>第四次 ...... 以此类推</p>
     * </div>
     * <p>可得出</p>
     * <div style="margin: 0 0 0 15px">
     *     <p>一共要交换 n/2 次</p>
     *     <p>每次交换时，在for循环中对应的下标是 array[i] 和 array[array.length - 1 -i]</p>
     * </div>
     *
     * @param array array
     * @return int[]
     */
    public static int[] arrayReverse1(int[] array) {
        int temp = 0;
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            temp = array[len - 1 - i];
            array[len - 1 - i] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
