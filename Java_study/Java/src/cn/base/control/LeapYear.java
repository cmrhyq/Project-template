package cn.base.control;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.java.base.control.LeapYear
 * @date 2022/7/22-0:59
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class LeapYear {

    /**
     * <h2>判断是否为闰年</h2>
     * 普通闰年：年份是4的倍数并且不是100的倍数
     * 世纪闰年：年份是400的倍数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int year = sc.nextInt();
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("is leap year");
            } else {
                System.out.println("no leap year");
            }
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
