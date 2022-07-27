/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot PACKAGE_NAME.letter
 * @date 2022/7/24-1:35
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Letter {

    /**
     * 输出小写的a-z和大写的Z-A
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] lowerLetter = {97, 122};
        int[] capitalLetter = {90, 65};
        for (int i = lowerLetter[0]; i <= lowerLetter[1]; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
        for (int j = capitalLetter[0]; j >= capitalLetter[1]; j--) {
            System.out.print((char) j + " ");
        }
    }

    public static void letter() {
        char[] lowerLetter = {'a', 'z'};
        char[] capitalLetter = {'A', 'Z'};
        for (char i = lowerLetter[0]; i <= lowerLetter[1]; i++) {
            System.out.print(i + "\t");
        }
        for (char i = lowerLetter[1]; i >= lowerLetter[0]; i--) {
            System.out.print(i + "\t");
        }
    }
}
