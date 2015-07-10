package roots;

import java.util.Scanner;

public class Roots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();
        
        System.out.println(String.format("%.5f", squareRoot(number)));
    }

    public static double squareRoot(int number) {
        if (number < 0) {
            return -1;
        }
        else if (number == 0 || number == 1) {
            return number;
        }
        else {
            double precision = 0.000001;
            double low = 1;
            double high = number;
            double middle = (high - low) / 2;

            while (Math.abs((middle * middle) - number) > precision) {
                if ((middle * middle) > number) {
                    high = middle;
                    middle = (high - low) / 2;
                }
                else {
                    low = middle;
                    middle = low + ((high - low) / 2);
                }
            }

            return middle;
        }       
    }
}