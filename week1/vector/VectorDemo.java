package vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(5);
        vector.pop();
        vector.remove(0);
        vector.insert(1, 555);
        
        System.out.printf("Size is: %d\n", vector.size());
        System.out.printf("Capacity is: %d\n", vector.capacity());
        System.out.printf("Value of element at index 1 is: %d\n", vector.get(2)); 
    }
}