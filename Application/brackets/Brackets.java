package brackets;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		boolean isValid = bracketValidator(input);
		if (isValid) {
			int number = evaluate(input);
			System.out.println(number);
		}
		else {
			System.out.println("NO");
		}
		
		in.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static boolean bracketValidator(String string){
		Stack stack = new Stack();
		boolean isValid = true;
		
		for (int i = 0; i < string.length()	; i++) {
			char bracket = string.charAt(i);
			
			if (bracket == '{'){
				stack.push(bracket);
			}
			
			if (bracket == '('){
				stack.push(bracket);
			}
			
			if (bracket == '['){
				stack.push(bracket);
			}
			
			if(string.indexOf('(') != -1 && string.indexOf('{') != -1){
				if(string.indexOf('(') < string.indexOf('{') &&
				   string.indexOf('}') < string.indexOf(')')){
					isValid = false;
				}
			}
			
			if(string.indexOf('(') != -1 && string.indexOf('[') != -1){
				if(string.indexOf('(') < string.indexOf('[') &&
				   string.indexOf(']') < string.indexOf(')')){
					isValid = false;
				}
			}
			
			if(string.indexOf('[') != -1 && string.indexOf('{') != -1){
				if(string.indexOf('[') < string.indexOf('{')){
					isValid = false;
				}
			}
			
			if(string.indexOf('{') != -1){
				int counter = 0;
				for (int j = 0; j < string.length(); j++) {
					if(string.charAt(j) == '{' ) {
				        counter++;
				    } 
				}
				
				if (counter > 1 && string.indexOf('{') != 0) {
					isValid = false;
				}
			}
			
			if (stack.contains('(') && stack.contains('{')) {
				if (stack.indexOf('{') == stack.indexOf('(') - 1) {
					isValid = false;
				}
			}
		}
		
		while (stack.size() != 0) {
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == ']' ||
					string.charAt(i) == '}' ||
					string.charAt(i) == ')') {
					if (string.charAt(i) == ')' && (char)stack.elementAt(stack.size() - 1) == '(') {
						stack.pop();
					}
					else if (string.charAt(i) == ']' && (char)stack.elementAt(stack.size() - 1) == '[') {
						stack.pop();
					}
					else if (string.charAt(i) == '}' && (char)stack.elementAt(stack.size() - 1) == '{') {
						stack.pop();
					}
					else{
						isValid = false;
					}
				}
			}
		}
		
		return isValid;
	}
	
	@SuppressWarnings({ "rawtypes" })
	static void sumUntilOpening(Stack stack){
		int sum = 0;
		int base = 1;
		String temp = (String)stack.pop();
		
		while (!checkOpening(temp)) {
			if (temp == "+"){
				sum += Integer.parseInt(temp);
				base = 1;
			}
			else {
				sum += base * Integer.parseInt(temp);
				base *= 10;
			}
			if (stack.size() == 0){
				break;
			}
			else {
				temp = (String)stack.pop();
			}	
		}
		
		if (stack.size() != 0){
			sum = 2 * sum;
		}
		stack.push("+" + Integer.toString(sum));
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static int evaluate(String string){
		Stack stack = new Stack();
		for (int i = 0; i < string.length(); i++) {
			if (checkOpening(Character.toString(string.charAt(i))) || isDigit(string.charAt(i))) {
				stack.push(string.charAt(i));
			}
			else if(checkClosing(Character.toString(string.charAt(i)))) {
				sumUntilOpening(stack);
			}
		}

		return Integer.parseInt(String.valueOf(stack.pop()));
	}

	static boolean checkOpening(String bracket){
		return bracket == "{" || bracket == "[" || bracket == "(";
	}

	static boolean checkClosing(String bracket){
		return bracket == "}" || bracket == "]" || bracket == ")";
	}
	
//	@SuppressWarnings("rawtypes")
//	static boolean isEmpty(Stack stack){
//		return stack.isEmpty();
//	}
	
	static boolean isDigit(char ch){
		return Character.isDigit(ch);
	}
}

