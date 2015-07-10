package quadruplets;

import java.util.Arrays;
import java.util.Scanner;

public class Quadruplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        int[] first = new int[number];
        int[] second = new int[number];
        int[] third = new int[number];
        int[] fourth = new int[number];

        for (int i = 0; i < first.length; i++) {
            first[i] = in.nextInt();
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = in.nextInt();
        }

        for (int i = 0; i < third.length; i++) {
            third[i] = in.nextInt();
        }

        for (int i = 0; i < fourth.length; i++) {
            fourth[i] = in.nextInt();
        }
        
        int count = numberOfQuadruplets(first, second, third, fourth);
        System.out.println(count);
        
        in.close();
    }

    public static int numberOfQuadruplets(int[] first, int[] second, int[] third, int[] fourth) {
        int counter = 0;
        int[] firstCombination = new int[first.length * second.length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                firstCombination[counter] = first[i] + second[j];
                counter++;
            }
        }

        counter = 0;
        int[] secondCombination = new int[third.length * fourth.length];
        for (int i = 0; i < third.length; i++) {
            for (int j = 0; j < fourth.length; j++) {
                secondCombination[counter] = third[i] + fourth[j];
                counter++;
            }
        }

        Arrays.sort(secondCombination);

        int countQuadruplets = 0;
        for (int i = 0; i < firstCombination.length; i++) {
            int oppositeNumber = firstCombination[i] * (-1);
            int firstIndex = binarySearch(secondCombination, oppositeNumber, true);
            
            if (firstIndex != -1) {
                int secondIndex = binarySearch(secondCombination, oppositeNumber, false);
                countQuadruplets += secondIndex - firstIndex + 1;
            }
        }

        return countQuadruplets;
    }

    public static int binarySearch(int[] array, int key, boolean searchLeftPart) {
        int low = 0;
        int high = array.length - 1;
        int result = -1;
        
        while (low <= high) {
            int middle = low + ((high - low) / 2);
            
            if (key ==  array[middle]) {
                result = middle;
                
                if (searchLeftPart) {
                    high = middle - 1;
                }
                else {
                    low = middle + 1;
                }
            }
            else if (key < array[middle]) {
                high = middle - 1;
            }
            else if (key > array[middle]) {
                low = middle + 1;
            }       
        }
        
        return result;
    }
}