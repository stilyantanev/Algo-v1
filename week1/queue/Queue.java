package queue;

import vector.Vector;

public class Queue<T> {
    private Vector<T> vector= new Vector<T>();
    
    public void push(T value){
        vector.add(value);
    }
    
    public T pop(){
        T value = vector.get(0);
        vector.remove(0);
        
        return value;
    }
    
    public T peek(){
        return vector.get(0);
    }
    
    public int size(){
        return vector.size();
    }
}