package com.weizz5.code.leetCode.dataStructure.queue;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *  
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * <p>
 * circularQueue.enQueue(1);  // 返回 true
 * <p>
 * circularQueue.enQueue(2);  // 返回 true
 * <p>
 * circularQueue.enQueue(3);  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * <p>
 * circularQueue.Rear();  // 返回 3
 * <p>
 * circularQueue.isFull();  // 返回 true
 * <p>
 * circularQueue.deQueue();  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 true
 * <p>
 * circularQueue.Rear();  // 返回 4
 *  
 * 提示：
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 *
 * @author weizz5
 * @date 2020/04/21
 */
public class MyCircularQueue {

    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }

    public static void main1(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

//        circularQueue.enQueue(1);  // 返回 true
        System.out.println(circularQueue.enQueue(1));

//        circularQueue.enQueue(2);  // 返回 true
        System.out.println(circularQueue.enQueue(2));

//        circularQueue.enQueue(3);  // 返回 true
        System.out.println(circularQueue.enQueue(3));

//        circularQueue.enQueue(4);  // 返回 false，队列已满
        System.out.println(circularQueue.enQueue(4));

//        circularQueue.rear();  // 返回 3
        System.out.println(circularQueue.Rear());

//        circularQueue.isFull();  // 返回 true
        System.out.println(circularQueue.isFull());

//        circularQueue.deQueue();  // 返回 true
        System.out.println(circularQueue.deQueue());

//        circularQueue.enQueue(4);  // 返回 true
        System.out.println(circularQueue.enQueue(4));

//        circularQueue.rear();  // 返回 4
        System.out.println(circularQueue.Rear());
    }


    Integer[] data;

    int head = -1;

    int tail = -1;

    /**
     * 构造器，设置队列长度为 k
     */
    public MyCircularQueue(int k) {
        this.data = new Integer[k];
    }

    public MyCircularQueue(Integer[] data) {
        this.data = data;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Front() {
        return isEmpty() ? -1 : data[tail];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Rear() {
        try {
            return isEmpty() ? -1 : data[head];
        } catch (Exception e) {
            System.out.println("data:" + JSON.toJSONString(data) + ",head:" + head + ",tail:" + tail);
            return -1;
        }
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     *
     * @return
     */
    public boolean enQueue(int value) {

        if (isFull()) {
            System.out.println(" queue is full !");
            return false;
        }
        if (isEmpty()) {
            tail++;
        }
        head = ++head % data.length;
        data[head] = value;

        return true;
    }

    /**
     * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            System.out.println(" queue is null !");
            return false;
        }
        data[tail] = null;
        if (tail == head) {
            tail = -1;
            head = -1;
        } else {
            tail = ++tail % data.length;
        }
//        tail = ++ tail > data.length ? tail : tail % data.length;
        return true;
    }

    /**
     * 检查循环队列是否为空。
     *
     * @return
     */
    public boolean isEmpty() {
        return tail == -1 && head == -1;
    }

    /**
     * 检查循环队列是否已满。
     *
     * @return
     */
    public boolean isFull() {

        return (head < tail && 1 == Math.abs(head - tail)) || (head > tail && data.length - 1 == Math.abs(head - tail));
    }

}
