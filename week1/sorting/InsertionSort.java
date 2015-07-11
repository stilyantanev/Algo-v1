package sorting;

import java.util.Random;

public class InsertionSort {
    public static final int ARRAY_SIZE = 100000;
    public static final int INTERVAL_NUMBERS = 200;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(ARRAY_SIZE);
        System.out.println("Below is UNSORTED array!");
        printArray(array);

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = insertionSort(array);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        // Print sorted array
        System.out.println("Below is SORTED array!");
        printArray(sortedArray);

        // Print time for sorting
        System.out.printf("Time for INSERTION sorting in seconds was: %.3f", elapsedTime);
    }
    
    public static int[] generateRandomArray(int number) {
        int array[] = new int[number];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(INTERVAL_NUMBERS);
        }

        return array;
    }
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentNumber = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > currentNumber) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = currentNumber;
        }

        return array;
    }
}