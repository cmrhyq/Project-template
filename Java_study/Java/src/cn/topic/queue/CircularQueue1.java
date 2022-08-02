package cn.topic.queue;

/**
 * <h1 style="color:#dae8fc;">设计循环队列</h1>
 *
 * <h2>方法1：数组</h2>
 * <div>
 *  设计一个数组进行循环队列的模拟，操作数组构建一个虚拟的收尾相连的环,设置一个队尾rear和队首front，大小固定
 * </div>
 * <div style="margin: 0 0 0 10px">
 *  <p>
 *      1.当队列为空，那么front=rear；当队列满时，那么front=rear。
 *  </p>
 *  <p>
 *      2.为了区别上一种情况，假定使用的数组有 capacity个存储空间
 *     那么此时规定的循环队列最多能有 capacity - 1个队列元素
 *  </p>
 *  <p>
 *      3.当循环队列中只剩下一哥空存储单元时，则表示队列已满。
 *  </p>
 * </div>
 * 根据以上得知；
 * <div style="margin: 0 0 0 10px">
 *     <p>
 *         1.队列判空的条件是 front = rear
 *     </p>
 *     <p>
 *         2.队列判满的条件是 front = ( rear + 1 ) mod capacity
 *     </p>
 *     <p>
 *         3.对于只知道队首 front和队尾 rear时可通过 ( rear - front + capacity ) mod capacity
 *     </p>
 * </div>
 * 循环队列属性如下：
 * <div style="margin: 0 0 0 10px">
 *     <p>
 *         front: 队首元素对应的数组索引。
 *     </p>
 *     <p>
 *         rear: 队尾元素对应索引的下一个索引。
 *     </p>
 *     <p>
 *         elements: 一个固定大小的数组，用于保存队列的元素。
 *     </p>
 *     <p>
 *         capacity: 循环队列的容量，即队列中最多可以容纳的元素数量。
 *     </p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.topic.queue.CircularQueue
 * @date 2022/8/2-22:54
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class CircularQueue1 {
    private int front;
    private int rear;
    private int capacity;
    private int[] elements;

    /**
     * 初始化队列，同事base数组的空间初始化为k+1。front，rear全部初始化为0
     *
     * @param k size
     */
    public void myCircularQueue(int k) {
        capacity = k + 1;
        elements = new int[capacity];
        rear = front = 0;
    }

    /**
     * 在队列尾部插入一个元素，并同时将队尾的索引rear更新为(rear+1) mod capacity
     *
     * @param value inserted value
     * @return true || false
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * 从队首取出一个元素，同时将队首的索引front更新为(front+1) mod capacity
     *
     * @return true || false
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 返回队首的元素，需要检测队列是否为空
     *
     * @return int
     */
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    /**
     * 返回队尾的元素，需要检测队列是否为空
     *
     * @return int
     */
    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    /**
     * 检测队列是否为空，根据之前的定义只需要判断rear是否等于front
     *
     * @return true || false
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 检测队列是否已满，根据之前的定义只需要判断front是否等于( rear + 1 ) mod capacity
     *
     * @return true || false
     */
    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }
}
