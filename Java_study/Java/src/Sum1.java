/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.Sum1
 * @date 2022/7/24-1:48
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Sum1 {

    /**
     * <h2>输出1-1/2+1/3-1/4....1/100的和</h2>
     * 1-1/2+1/3-1/4....1/100 = 1-(1/2)+(1/3)-(1/4)....(1/100)
     * for循环中的i从2开始到100，i等于(1/2) (1/3) (1/4)中的分母
     * 当(i-1)等于奇数的时候就是-
     * 当(i-1)等于偶数的时候就是+
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] interval = {2, 100};
        double sum = 0;
        for (int i = interval[0]; i <= interval[1]; i++) {
            if (i == 2) {
                sum = 1.0 - (1.0 / i);
            } else {
                if ((i - 1) % 2 != 0) {
                    sum = sum - (1.0 / i);
                } else if ((i - 1) % 2 == 0) {
                    sum = sum + (1.0 / i);
                } else {
                    System.out.println("error: application error");
                }
            }
        }
        System.out.println("1-1/2+1/3-1/4....1/100 = " + sum);
        sum();
    }

    /**
     * 1.1-1/2+1/3-1/4....1/100 = 1-(1/2)+(1/3)-(1/4)....(1/100)
     * 2.一共有100个数，分子为1.0，分母从1-100
     * 3.当分母等于奇数的时候就是- 当分母等于偶数的时候就是+
     * 使用for循环+if
     */
    public static void sum() {
        double sum = 0.0;
        int[] interval = {1, 100};
        for (int i = interval[0]; i <= interval[1]; i++) {
            if (i % 2 != 0) {
                sum = sum + (1.0 / i);
            } else {
                sum = sum - (1.0 / i);
            }
        }
        System.out.println("1-1/2+1/3-1/4....1/100 = " + sum);
    }
}
