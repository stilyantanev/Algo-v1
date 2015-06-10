package vector;

import java.util.Arrays;

public class Vector<T> {
    private static final int initialCapacitySize = 400;

    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Vector() {
        size = 0;
        capacity = initialCapacitySize;

        array = (T[]) new Object[initialCapacitySize];
    }

    private T[] ensureCapacity(T[] array) {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);

        return array;
    }

    private void checkCorrectIndex(int index, int size) {
        try {
            if (index < 0 || index >= size) {
                String message =String.format("Such index \"%d\" doesn't exist!", index);
                throw new ArrayIndexOutOfBoundsException(message);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void insert(int index, T value) {
        checkCorrectIndex(index, size);

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    public void add(T value) {
        if (size == capacity) {
            array = ensureCapacity(array);
        }

        if (size < capacity) {
            array[size] = value;
            size++;
        }
    }

    public T get(int index) {
        checkCorrectIndex(index, size);

        return array[index];
    }

    public void remove(int index) {
        checkCorrectIndex(index, size);

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    public void pop() {
        array[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}