package stack;

import queue.Queue;

public class Stack<T> {
    private Queue<T> queue = new Queue<T>();
    
    public void push(T value){
        queue.push(value);
    }
    
    public T pop(){
        int size = queue.size();
        
        for (int i = 0; i < size - 1; i++) {
            T queueElement = queue.pop();
            queue.push(queueElement);
        }
        
        T element = queue.pop();
        
        return element;
    }
    
    public T peek(){
        int size = queue.size();
        
        for (int i = 0; i < size - 1; i++) {
            T queueElement = queue.pop();
            queue.push(queueElement);
        }
        
        T element = queue.pop();
        queue.push(element);
        
        return element;
    }
    
    public int size(){
        return queue.size();
    }
}