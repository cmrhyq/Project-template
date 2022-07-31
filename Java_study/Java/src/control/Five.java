package control;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.control.Five
 * @date 2022/7/24-1:23
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Five {

    /**
     * 输出1-100之间的不能被5整除的数，每5个一行
     * @param args
     */
    public static void main(String[] args) {
        int row = 0;
        int max = 100;
        int num = 5;
        for (int i = 1; i <= max; i++) {
            if (i % num != 0) {
                row++;
                System.out.print(i + "\t");
                if (row % 5 == 0){
                    System.out.println();
                }
            }
        }
    }
}
