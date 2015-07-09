package sorting;

import java.util.Random;

public class BubbleSort {
    public static final int arraySize = 100000;
    public static final int intervalNumbers = 200;

    public static void main(String[] args) {
        // Generate and print array
        int[] array = generateRandomArray(arraySize);
        System.out.println("Below is UNSORTED array!");
        printArray(array);

        // Make sorting and get time for sorting
        long startTime = System.currentTimeMillis();
        int[] sortedArray = bubbleSort(array);
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

    public static int[] bubbleSort(int[] array) {
        boolean swapped = false;
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if(!swapped){
                break;
            }
        }

        return array;
    }
}