package cn.topic.queue;

import java.util.Arrays;

/**
 * <h1 style="color:white">给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾</h1>
 * <div>
 *     <p>计算<a href="https://baike.baidu.com/item/%E5%AD%97%E5%85%B8%E5%BA%8F/7786229?fr=aladdin">字典序</a>最小的字符串时，需要分别考虑 k=1 和 k>1 的情况</p>
 *     <p>当 k=1 时</p>
 *     <div style="margin: 0 0 0 10px">
 *          <p>每次只能取s的首个字母并将其移动到末尾，因此对于给定的字符串，可能的移动方法是唯一的，移动后的结果也是唯一的。</p>
 *          <p>对于长度为n的字符串s，经过0次到n-1次移动后分别得到n个字符串，这n个字符串中的字典序最小的字符串即为答案。</p>
 *     </div>
 *     <p>当 k>1 时</p>
 *     <div style="margin: 0 0 0 10px">
 *         <p>一定可以经过移动将s变成升序字符串，因此将字符串s升序排序之后得到的字符串即为答案，理由如下</p>
 *         <p style="margin-left:10px">考虑 k=2 的情况。假设s的所有字符按照升序排序依次是 C0,C1,....,Cn-1。对于s的任意排列，总是可以经过若按此移动将Cn-1变成首个字符</p>
 *         <div style="margin-left:10px">
 *             当Cn-1变成首个字符以后，可以将Cn-2,Cn-1变成前两个字符：
 *             <p style="margin-left:10px">1.每次将首个字符移动到末尾，直到Cn-2变成首个字符</p>
 *             <p style="margin-left:10px">2.保持Cn-1位于首个字符，每次将Cn-2后面的字符移动到末尾，直到Cn-2后面的字符是Cn-1</p>
 *         </div>
 *         <p>使用同样的方法，对于1<= m < n，如果 Cn - m, Cn - m + 1,......,Cn-1位于前 m 个字符，则可以经过若干次移动将 Cn-m-1,Cn-m+1,...,Cn-1编程前m+1个字符</p>
 *         <div style="margin-left:10px">
 *              <p>1.每次将首个字符移动到末尾，直到Cn-m-1变成首个字符，此时Cn-m，Cn-m+1,......,Cn-1为字符串中连续的m个字符</p>
 *              <p>2.保持Cn-m-1位于首个字符，每次将Cn-m-1后面的字符移动到末尾，直到Cn-m-1后面的字符是Cn-m，此时前m+1个字符是Cn-m-1，Cn-m，Cn-m+1,......,Cn-1</p>
 *         </div>
 *     </div>
 *     <p>因此，当k==2时，一定可以经过移动将s变成升序字符串</p>
 *     <p>当k>2时，同样可以对字符串的前两个字符执行移动操作将s变成升序字符串</p>
 * </div>
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.topic.queue.OrderQueue
 * @date 2022/8/3-23:24
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class OrderQueue {

    public static String orderlyQueue(String s, int k) {
        if (k != 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0){
                    smallest = sb.toString();
                }
            }
            return smallest;
        }
    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cbfdqvdsafa", 1));
    }
}
