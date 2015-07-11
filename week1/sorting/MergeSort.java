package sorting;

import java.util.Random;

public class MergeSort {
    public static final int ARRAY_SIZE = 100000;
    public static final int INTERVAL_NUMBERS = 2000;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(ARRAY_SIZE);
        System.out.println("Below is UNSORTED array!");
        printArray(array);

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = mergeSort(array);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        // Print sorted array
        System.out.println("Below is SORTED array!");
        printArray(sortedArray);

        // Print time for sorting
        System.out.printf("Time for MERGE sorting in seconds was: %.3f", elapsedTime);
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

    public static int[] leftHalf(int[] array) {
        int middle = array.length / 2;
        int[] leftHalf = new int[middle];

        for (int i = 0; i < middle; i++) {
            leftHalf[i] = array[i];
        }

        return leftHalf;
    }
    
    public static int[] rightHalf(int[] array) {
        int middle = array.length / 2;
        int[] rightHalf = new int[array.length - middle];
        
        for (int i = 0; i < array.length - middle; i++) {
            rightHalf[i] = array[middle + i];
        }
        
        return rightHalf;
    }
    
    public static void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;   

        for (int i = 0; i < array.length; i++) {
            if (rightIndex >= right.length ||
               (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                array[i] = left[leftIndex];
                leftIndex++;
            }
            else {
                array[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }
    
    public static int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            left = mergeSort(left);
            right = mergeSort(right);
            
            merge(array, left, right);
        }
        
        return array;
    }
}