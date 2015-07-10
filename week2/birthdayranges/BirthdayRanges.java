package birthdayranges;

import java.util.Scanner;

public class BirthdayRanges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfPeopleBirthdays = in.nextInt();
        int numberOfRanges = in.nextInt();

        int[] birthdays = new int[numberOfPeopleBirthdays];
        for (int i = 0; i < birthdays.length; i++) {
            birthdays[i] = in.nextInt();
        }

        int[][] ranges = new int[numberOfRanges][2];
        for (int i = 0; i < ranges.length; i++) {
            for (int j = 0; j < ranges[i].length; j++) {
                ranges[i][j] = in.nextInt();
            }
        }
        
        int[] result = birthdaysCount(birthdays, ranges);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
        in.close();
    }

    public static int[] birthdaysCount(int[] birthdays, int[][] ranges) {
        int dateOfBirthdays = 365;
        int[] histogram = new int[dateOfBirthdays + 1];
        for (int i = 0; i < birthdays.length; i++) {
            histogram[birthdays[i]]++;
        }
        
        for (int i = 1; i < histogram.length; i++) {
            histogram[i] += histogram[i - 1];
        }
        
        int[] result = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            if (histogram[ranges[i][0]] == 0) {
                result[i] = histogram[ranges[i][1]];
            }
            else {
                result[i] = histogram[ranges[i][1]] - histogram[ranges[i][0] - 1];
            }
        }
        
        return result;
    }
}