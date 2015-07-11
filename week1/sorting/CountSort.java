package sorting;

import java.util.Random;

public class CountSort {
    public static final int ARRAY_SIZE = 100;
    public static final int INTERVAL_NUMBERS = 50;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(ARRAY_SIZE);
        System.out.println("Below is UNSORTED array!");
        printArray(array);

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = countSort(array);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        // Print sorted array
        System.out.println("Below is SORTED array!");
        printArray(sortedArray);

        // Print time for sorting
        System.out.printf("Time for COUNT sorting in seconds was: %.3f", elapsedTime);
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

    public static int[] countSort(int[] array) {
        int[] countingArray = new int[INTERVAL_NUMBERS];
        int[] sortedArray = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            countingArray[array[i]] += 1;
        }
        
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }
        
        for (int i = array.length - 1; i >= 0; i--) {
            countingArray[array[i]]--;
            sortedArray[countingArray[array[i]]] = array[i];
        }

        return sortedArray;
    }
}