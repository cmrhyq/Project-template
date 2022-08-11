package cn.base.array;

import java.util.Scanner;

/**
 * <h1 style="color:white">数组扩容</h1>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.base.array.ArrayExpansion
 * @date 2022/8/10-0:40
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayExpansion {

    public static void main(String[] args) {
//        新数组扩容
        int[] array = {1, 2, 3};
        Scanner scanner = new Scanner(System.in);
        array = arrayExpansion(array);
        while (true) {
            System.out.println();
            System.out.println("Please choose whether to continue(y/n):");
            if ("y".equals(scanner.next().toLowerCase())) {
                array = arrayExpansion(array);
            } else {
                break;
            }
        }
    }

    /**
     * <h2 style="color:white">数组扩容</h2>
     * <div style="margin: 0 0 0 15px">
     *     <p>使用一个新的数组来实现数组扩容</p>
     * </div>
     * @param array array
     * @return int[]
     */
    public static int[] arrayExpansion(int[] array) {
        Scanner scanner = new Scanner(System.in);
        int[] newArray = new int[array.length + 1];
        // parame1: 原数组， parame2: 从元数据的起始位置开始， parame3: 目标数组， parame4: 目标数组的开始起始位置， parame5: 要copy的数组的长度
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.out.println("Please enter a number:");
        newArray[newArray.length - 1] = scanner.nextInt();
        System.out.println("The result after expansion is:");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + "\t");
        }
        return newArray;
    }
}
