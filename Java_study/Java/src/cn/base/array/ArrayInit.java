package cn.base.array;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot java.base.array.ArrayDynamicInit
 * @date 2022/7/31-20:37
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayInit {

    /**
     * int char float double short byte long boolean
     * <h1>动态初始化</h1>
     * 数组可以存放多个同一类型的数据，也是一种数据类型，是引用类型
     * 定义：int a[] = new int[] or int[] a
     * <h1>静态初始化</h1>
     * 定义：int a[] = {}
     * 知道数组有多少元素，具体值
     * int a[] = {} 等价于 int a[] = new int[2]; a[0]=1; a[1]=2;
     * @param args
     */
    public static void main(String[] args) {
        // 动态初始化
        // 只是声明数组，这时候的age为null
        double[] age;
        // 分配内存空间，可以存放数据
        // 如果不进行new的操作直接去赋值会出现空指针异常
        age = new double[3];
        System.out.println("age = " + age[0]);
        // 静态初始化
        int a[] = {1,2,3,4,5,6,7,8,9};
        System.out.println("a = " + a[0]);
    }
}
