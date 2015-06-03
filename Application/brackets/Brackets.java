package brackets;

public class Brackets {
	public static void main(String[] args) {
		
	}
	
	static boolean checkOpening(String bracket){
		return bracket == "{" || bracket == "[" || bracket == "(";
	}
	
	static boolean checkClosing(String bracket){
		return bracket == "}" || bracket == "]" || bracket == ")";
	}
	
	
}
