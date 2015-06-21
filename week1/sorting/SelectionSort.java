package sorting;

import java.util.Random;

public class SelectionSort {
    public static final int arraySize = 100000;
    public static final int intervalNumbers = 200;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(arraySize);
        System.out.println("Below is UNSORTED array!");
        printArray(array);

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = selectionSort(array);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        // Print sorted array
        System.out.println("Below is SORTED array!");
        printArray(sortedArray);

        // Print time for sorting
        System.out.printf("Time for SELECTION sorting in seconds was: %.3f", elapsedTime);
    }
    
    public static int[] generateRandomArray(int number) {
        int array[] = new int[number];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(intervalNumbers);
        }

        return array;
    }
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }

            if (i != minElementIndex) {
                int temp = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temp;
            }
        }

        return array;
    }
}