/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.sum2
 * @date 2022/7/25-1:09
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Sum2 {

    /**
     * 求1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+4+...+100)的结果
     * 思路：
     * 1.一共有一百项相加
     * 2.每一项都比前一项多一项相加，每一项相加的数字在增加
     * 3.这是一个双层循环
     * 4.用i表示当前是第几项，用j表示当前项的最大值
     * @param args
     */
    public static void main(String[] args) {
        int sum = 0;
        int[] interval = {1, 100};
        for (int i = interval[0]; i <= interval[1]; i++) {
            for (int j = interval[0]; j <= i; j++){
                sum += j;
            }
        }
        System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+4+...+100) = " + sum);
    }
}
