package sorting;

import java.util.Random;

public class QuickSort {
    public static final int ARRAY_SIZE = 100000;
    public static final int INTERVAL_NUMBERS = 2000;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(ARRAY_SIZE);
        System.out.println("Below is UNSORTED array!");
        printArray(array);
        
        // Calculate first and last indexes of array
        int start = 0;
        int end = array.length - 1;

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = quickSort(array, start, end);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        // Print sorted array
        System.out.println("Below is SORTED array!");
        printArray(sortedArray);

        // Print time for sorting
        System.out.printf("Time for QUICK sorting in seconds was: %.3f", elapsedTime);
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

    public static int[] quickSort(int[] array, int start, int end) {
        int[] sortedArray = array;

        int middle = start + (end - start) / 2;
        int pivot = array[middle];

        int i = start;
        int j = end;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(array, start, j);
        }

        if (i < end) {
            quickSort(array, i, end);
        }

        return sortedArray;
    }
}