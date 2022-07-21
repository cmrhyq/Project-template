import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.judge
 * @date 2022/7/22-0:41
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Judge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int number = sc.nextInt();
            if (number > 0) {
                System.out.println("Number more than the zero");
            } else if (number < 0) {
                System.out.println("Number less than zero");
            } else {
                System.out.println("Number equal zero");
            }
        } catch (Exception e){
            System.out.println("e = " + e.getMessage());
        }
    }
}
