package cn.whl.commonutils.collection.queue;

import java.util.LinkedList;

/**
 * 队列（对LinkedList进行包装）
 * @author wuhailong
 */
public class Queue {
    
    private LinkedList queue = new LinkedList();
    
    /**
     * 入队
     * @param t
     */
    public void enQueue(Object t){
        queue.addLast(t);
    }
    
    /**
     * 出队
     * @return
     */
    public Object deQueue(){
        return queue.removeFirst();
    }
    
    /**
     * 判断空
     * @return
     */
    public boolean isQueueEmpty(){
        return queue.isEmpty();
    }
    
    /**
     * 包含查询
     * @param t
     * @return
     */
    public boolean contains(Object t){
        return queue.contains(t);
    }
    
    /**
     * 队列长度
     * @return
     */
    public int count(){
        return queue.size();
    }
    
    /**
     * 队列清空
     */
    public void clear(){
        queue.clear();
    }
    
}
