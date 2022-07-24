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
     * 输出1-1/2+1/3-1/4....1/100的和
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
                } else if ((i - 1) % 2 == 0){
                    sum = sum + (1.0 / i);
                } else {
                    System.out.println("error: application error");
                }
            }
        }
        System.out.println("1-1/2+1/3-1/4....1/100 = " + sum);
    }
}
