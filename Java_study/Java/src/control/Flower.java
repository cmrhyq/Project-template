package control;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.flower
 * @date 2022/7/22-1:08
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Flower {

    /**
     * <h2>水仙花数</h2>
     * 水仙花数是指一哥三位数，其各个位数上数字立方和等于其本身
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        flower(sc.nextInt());
//        for (int i = 100; i < 1000; i++) {
//            flower(i);
//        }
    }

    public static void flower(int number) {
        try {
            if (String.valueOf(number).length() <= 3) {
                int ones = number % 10;
                int tens = number / 10 % 10;
                int hundred = number / 100;
//                if (Math.pow(ones, 3) + Math.pow(tens, 3) + Math.pow(hundred, 3) == number) {
                if (ones * ones * ones + tens * tens * tens + hundred * hundred * hundred == number) {
                    System.out.println("is daffodils");
                } else {
                    System.out.println("no daffodils");
                }
            } else {
                System.out.println("Numbers more than the three");
            }
        } catch (
                Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
