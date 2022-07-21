public class Main {
    //    public static void main(String[] args) {
//        int totalLevel = 20;
//        for (int i = 1; i <= totalLevel; i++) {
//            for (int k = 1; k <= totalLevel - i; k++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i - 1; j++) {
//                if (j == 1 || j == 2 * i - 1 || i == totalLevel) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) {
        double total = 100000;
        int bout = 0;
        while (total > 0) {
            if (total > 50000) {
                total = total - total / 0.05;
                bout++;
            } else if (total <= 50000 && total > 1000) {
                total = total - 1000;
                bout++;
            } else {
                System.out.println("bout = " + bout);
                break;
            }
        }
    }
}