package control;

/**
 * @author Alan Huang
 */
public class PayTheFees {


    /**
     * 某人有100000元，每经过一次路口，需要缴费
     * 1.当现金大于50000时，每次交百分之5
     * 2.当现金小于等于50000时，每次交1000
     * 计算该人可以经过多少次路口，使用while break实现。
     * @param args
     */
    public static void main(String[] args) {
        double total = 100000;
        int bout = 0;
        while (total > 0) {
            if (total > 50000) {
                // total = total - total * 0.05;
                total *= 0.95;
                bout++;
            } else if (total > 1000) {
                total = total - 1000;
                bout++;
            } else {
                break;
            }
        }
        System.out.println("bout = " + bout);
    }
}