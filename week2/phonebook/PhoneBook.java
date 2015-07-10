package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfPairs = in.nextInt();
        int numberOfPhoneNumbers = in.nextInt();

        Map<Integer, String> numberPerson = new HashMap<Integer, String>();
        for (int i = 0; i < numberOfPairs; i++) {
            int phoneNumber = in.nextInt();
            String name = in.next();
            numberPerson.put(phoneNumber, name);
        }

        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < numberOfPhoneNumbers; i++) {
            int phoneNumber = in.nextInt();
            
            if (numberPerson.containsKey(phoneNumber)) {
                names.add(numberPerson.get(phoneNumber));
            }
        }
        
        for (String name : names) {
            System.out.println(name);
        }

        in.close();
    }
}