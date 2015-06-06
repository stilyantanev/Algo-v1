package brackets;

import java.util.Scanner;
import java.util.Stack;

public class Brackets{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		boolean isValid = bracketValidator(input);
		if (isValid) {
			int value = evaluateExpression(input);
			System.out.println(value);
		}
		else {
			System.out.println("NO");
		}
		
		in.close();
	}
	
	static boolean bracketValidator(String string){
		boolean isValid = true;
		
		//Check starts with '(' and ends with ')' type bracket
		if (string.charAt(0) == '('){
			if (string.charAt(string.length() - 1) != ')') {
				isValid = false;
			}
		}
		
		//Check starts with '[' and ends with ']' type bracket
		if (string.charAt(0) == '['){
			if (string.charAt(string.length() - 1) != ']') {
				isValid = false;
			}
		}
		
		//Check starts with '[' and ends with ']' type bracket
		if (string.charAt(0) == '{'){
			if (string.charAt(string.length() - 1) != '}') {
				isValid = false;
			}
		}
		
		//Check starts and ends with digit
		if (Character.isDigit(string.charAt(0)) ||
			Character.isDigit(string.charAt(string.length() - 1))) {
			
			isValid = false;
		}
		
		//Check if '{' exist in position different from first
		if (string.indexOf('{') != 0 && string.indexOf('{') != -1) {
			isValid = false;
		}
		
		//Check if '}' exist in position different from first or last
		if (string.indexOf('}') != (string.length() - 1) && string.indexOf('}') != -1) {
			isValid = false;
		}
		
		//Check for (digits[]digits) it is not valid combination
		if (string.indexOf('(') < string.indexOf('[') &&
			string.indexOf(']') < string.indexOf(')')) {
			
			isValid = false;
		}
		
		//Make stack with opening brackets
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);
			
			if (letter == '{' ||
				letter == '(' ||
				letter == '[')
				
				stack.push(letter);
		}
		
		//Check for {digits()digits} it is not valid combination
		if (stack.indexOf('{') != -1) {
			if (stack.indexOf('{') == stack.indexOf('(') - 1) {
				isValid = false;
			}
		}
		
		//Check for (digits()digits) it is not valid combination
		int circleBracketIndex = stack.indexOf('(');
		
		if (circleBracketIndex != - 1) {
			if (circleBracketIndex == stack.indexOf('(', circleBracketIndex) - 1) {
				isValid = false;
			}
		}
		
		//Check for [digits[]digits] it is not valid combination
		int squareBracketIndex = stack.indexOf('[');
		
		if (squareBracketIndex != - 1) {
			if (squareBracketIndex == stack.indexOf('[', squareBracketIndex) - 1) {
				isValid = false;
			}
		}
		
		//Check opening and closing are equal of same type
		int openCircle = 0;
		int closeCircle = 0;
		int openSquare = 0;
		int closeSquare = 0;
		int openCurly = 0;
		int closeCurly = 0;
		
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '{') {
				openCurly++;
			}
			else if (string.charAt(i) == '[') {
				openSquare++;
			}
			else if (string.charAt(i) == '(') {
				openCircle++;
			}
			else if (string.charAt(i) == '}') {
				closeCurly++;
			}
			else if (string.charAt(i) == ']') {
				closeSquare++;
			}
			else if (string.charAt(i) == ')') {
				closeCircle++;
			}
			
		}
		
		if (openCurly != closeCurly) {
			isValid = false;
		}
		if (openSquare != closeSquare) {
			isValid = false;
		}
		if (openCircle != closeCircle) {
			isValid = false;
		}
		
		//Check incorrectly closing brackets
		String partWithoutEndBrackets = string.substring(1, string.length() - 1);
		
		if (partWithoutEndBrackets.indexOf('(') > partWithoutEndBrackets.indexOf(')')){
			isValid = false;
		}

		return isValid;
	}
	
	static boolean isOpenBracket(char ch){
		return ch == '{' || ch == '(' || ch == '[';
	}
	
	static boolean isCloseBracket(char ch){
		return ch == '}' || ch == ')' || ch == ']';
	}
	
	static int evaluateExpression(String string){
		String nums = "";
		int i = 0;
		int realSum = 0;
		
		while (i < string.length()) {
			i++;
			char symbol = string.charAt(i);
			
			if (Character.isDigit(symbol)) {
				nums += symbol;
			}
			else if (isOpenBracket(symbol)) {
				if (nums != "") {
					realSum += Integer.parseInt(nums);
					nums = "";
				}
				
				realSum += evaluateExpression(string.substring(i));
				while(Character.isDigit(string.charAt(i + 1))){
					i++;
				}
				i+=1;
			}
			else if  (isCloseBracket(symbol)) {
				if(i == string.length() - 1){
					return realSum + Integer.parseInt(nums);
				}
				else if (nums != ""){
					return 2 * Integer.parseInt(nums);
				}
				else {
					return 0;
				}
			}
		}
		
		return realSum;
	}
}