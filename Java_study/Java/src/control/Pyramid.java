package control;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.control.Pyramid
 * @date 2022/7/21-23:34
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Pyramid {

    /**
     * <div>
     * <h2>title:输出空心金字塔</H2>
     *         *
     *        *  *
     *       *    *
     *      *       *
     *     ***********
     * <h3>金字塔一层一层输出</h3>
     * <h3>注意System.out.print和System.out.println的区别</h3>
     * 1.最外层循环控制金字塔层数
     *   - totalLevel 控制金字塔层数
     * 2.外层循环的循环体中第一个循环控制空心金字塔的空格输出
     *   - 空心金字塔左侧空格 = 层数 - 当前层数 = 当前层空格个数
     * 3.外层循环的循环体中第二个循环控制星号的输出
     *   - 当前层输出星号个数 = 2 * 当前层数 - 1 = 当前层星号个数
     * 4.金字塔星号输出规则
     *   - 除了最后一行以外都是输出第一个和最后一个
     * </div>
     * @param args
     */
    public static void main(String[] args) {
        int totalLevel = 20;
        for (int i = 1; i <= totalLevel; i++) {
            for (int k = 1; k <= totalLevel - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == totalLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
