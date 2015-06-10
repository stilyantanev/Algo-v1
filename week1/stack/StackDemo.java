package stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.push(10);
        
        System.out.printf("Size is: %d\n", stack.size());
        System.out.printf("Element at end is: %d\n", stack.pop());
        System.out.printf("Size is: %d\n", stack.size());
        System.out.printf("Element at end is: %d\n", stack.peek());
    }
}
