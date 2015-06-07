package encryptedmessage;

import java.util.Scanner;

public class EncryptedMessage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		String reversedString = reverseString(input);
		
		//First part
		String alphabet = getAlphabet(reversedString);
		
		//Second part
		String key = getKey(reversedString);
		
		//Middle part
		String encryptedMessage = getEncryptedMessage(reversedString);
		
		//Make whole key
		String wholeKey = getWholeKey(key, encryptedMessage.length());
		
		//Get indexes in alphabet of encrypted message
		int[] indexesEncryptedMessage = getIndexesOfMessage(encryptedMessage, alphabet);
		
		//Get indexes in alphabet of real word
		int[] indexesRealWord = getIndexesOfRealWord(indexesEncryptedMessage, wholeKey, alphabet);
		
		//Make real word
		String realWord = makeRealWord(indexesRealWord, alphabet);
		
		System.out.println(realWord);
		
		in.close();
	}
	
	static String reverseString(String string) {
		int length = string.length();
		String firstHalf = string.substring(0, length / 2);
		String secondHalf = string.substring(length / 2, length);
		
		return secondHalf + firstHalf;
	}
	
	static int getLengthOfAlphabet(String string) {
		int firstTilda = string.indexOf('~');
		int lengthOfAlphabet = Integer.parseInt(string.substring(0, firstTilda));
		
		return lengthOfAlphabet;
	}
	
	static String getAlphabet(String string) {
		int firstTilda = string.indexOf('~');
		String alphabet = string.substring(firstTilda + 1, firstTilda + getLengthOfAlphabet(string) + 1);
		
		return alphabet;
	}
	
	static int getLengthOfKey(String string) {
		int firstTilda = string.indexOf('~');
		int secondTilda = string.indexOf('~', firstTilda + 1);
		int lengthOfKey = Integer.parseInt(string.substring(secondTilda + 1));
		
		return lengthOfKey;
	}
	
	static String getKey(String string) {
		int firstTilda = string.indexOf('~');
		int secondTilda = string.indexOf('~', firstTilda + 1);
		String key = string.substring(secondTilda - getLengthOfKey(string), secondTilda);
		
		return key;
	}
	
	static String getEncryptedMessage(String string) {
		int firstTilda = string.indexOf('~');
		int secondTilda = string.indexOf('~', firstTilda + 1);
		String encryptedMessage = string.substring(firstTilda + getLengthOfAlphabet(string) + 1, secondTilda - getLengthOfKey(string));
		
		return encryptedMessage;
	}
	
	static String getWholeKey(String key, int length) {
		String wholeKey = "";
		int keyLength = key.length();
		int lengthOfWholeKey = length;
		
		while (lengthOfWholeKey > 0){
			if (lengthOfWholeKey < keyLength) {
				String partKey = key.substring(0, lengthOfWholeKey);
				wholeKey += partKey;
				break;
			}
			
			wholeKey += key;
			lengthOfWholeKey -= keyLength;
		}
		
		return wholeKey;
	}
	
	static int[] getIndexesOfMessage(String encryptedMessage, String alphabet) {
		int[] indexesEncryptedMessage = new int[encryptedMessage.length()];
		
		for (int i = 0; i < encryptedMessage.length(); i++) {
			char letter = encryptedMessage.charAt(i);
					
			for (int j = 0; j < alphabet.length(); j++) {
				if (letter == alphabet.charAt(j)){
					indexesEncryptedMessage[i] = j;
				}
			}
		}
			
		return indexesEncryptedMessage;
	}
	
	static int[] getIndexesOfRealWord(int[] indexesEncryptedMessage, String wholeKey, String alphabet) {
		int[] indexesRealWord = new int[indexesEncryptedMessage.length];
		
		for (int i = 0; i < indexesEncryptedMessage.length; i++) {
			char letter = wholeKey.charAt(i);
			int alphabetIndex = alphabet.indexOf(letter);
			
			int index = indexesEncryptedMessage[i] + alphabet.length();
			index = index - alphabetIndex;
			index = index % alphabet.length();
			
			indexesRealWord[i] = index;
		}
		
		return indexesRealWord;
	}
	
	static String makeRealWord(int [] indexesRealWord, String alphabet) {
		String realWord = "";
		
		for (int i = 0; i < indexesRealWord.length; i++) {
			char letter = alphabet.charAt(indexesRealWord[i]);
			realWord += letter;
		}
		
		return realWord;
	}
}