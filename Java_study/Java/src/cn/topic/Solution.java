package cn.topic;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot java.topic.Solution
 * @date 2022/8/1-23:26
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Solution {

    /**
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     *
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
     *
     * @param n
     * @return
     */
    public static String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<n;i++){
            sb.append("a");
        }
        if (n%2==0){
            sb.deleteCharAt(0).append("b");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(4));
    }
}
