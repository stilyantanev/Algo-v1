package palindromes;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindromes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		ArrayList<String> parts = getAllPartsOfString(input);
		ArrayList<String> allPalindromes = new ArrayList<>();
		
		for (int i = 0; i < parts.size(); i++) {
			String part = parts.get(i);
			if(checkIsPalindrome(part)){
				allPalindromes.add(part);
			}
		}
		
		if(allPalindromes.isEmpty()){
			printNone();
		}
		else {
			printAllPalindromes(allPalindromes);
		}
		
		in.close();
	}
	
	static ArrayList<String> getAllPartsOfString(String string){
		ArrayList<String> allParts = new ArrayList<>();
		int length = string.length();
		
		String firstPart = null;
		String secondPart = null;
		
		for (int i = 1; i <= length ; i++) {
			firstPart = string.substring(0, i);
			secondPart = string.substring(i, length);
			
			allParts.add(secondPart + firstPart);
		}
		
		return allParts;
	}
	
	static boolean checkIsPalindrome(String string){
		int length = string.length();
		
		for (int i = 0; i < length; i++) {
			if(string.charAt(i) != string.charAt(length - 1 - i)){
				return false;
			}
		}
		
		return true;
	}
	
	static void printNone(){
		System.out.println("NONE");
	}
	
	static void printAllPalindromes(ArrayList<String> palindromes){
		for (int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}
	}
}