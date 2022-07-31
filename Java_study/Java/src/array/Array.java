package array;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot array.array
 * @date 2022/7/31-20:22
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Array {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double sum = 0;
        double[] pasture = {3, 5, 1, 3.4, 2, 50};
        for (double v : pasture) {
            sum += v;
        }
        System.out.println(sum / pasture.length);
    }
}
