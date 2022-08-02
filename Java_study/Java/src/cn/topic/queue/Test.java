package cn.topic.queue;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.topic.queue.Test
 * @date 2022/8/3-0:35
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Test {

    public static void main(String[] args) {
        CircularQueue1 c = new CircularQueue1();
        c.myCircularQueue(3);
        System.out.println(c.enQueue(1));
        System.out.println(c.enQueue(2));
        System.out.println(c.enQueue(3));
        System.out.println(c.enQueue(4));
        System.out.println(c.rear());
        System.out.println(c.isFull());
        System.out.println(c.deQueue());
        System.out.println(c.enQueue(4));
        System.out.println(c.rear());
    }
}
