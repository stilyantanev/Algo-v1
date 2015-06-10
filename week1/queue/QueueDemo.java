package queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(19);
        
        System.out.printf("Front element is: %d\n", queue.peek());
        System.out.printf("Front element is: %d\n", queue.pop());
        System.out.printf("Front element is: %d\n", queue.peek());
        System.out.printf("Size is: %d\n", queue.size());
    }
}