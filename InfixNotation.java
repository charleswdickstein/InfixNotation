import java.util.Stack;
import java.util.StringTokenizer;

public class InfixNotation {
	public static double evaluateInfix(String exp) {
		Stack<String> stack = new Stack<String>();
		int paranCount = 0;
		// double result = 0;
		StringTokenizer tokens = new StringTokenizer(exp, "{}()*/+-", true);
		while (tokens.hasMoreTokens()) {
			String nextToken = tokens.nextToken();

			if (nextToken == "(") {
				stack.push(nextToken);
				paranCount++;

			} else if (nextToken == ")") {
				paranCount--;
				String s = "";
				while (stack.pop() != "(") {
					s = stack.pop() + s;

				}
				stack.push(parseMyString(s));
			} else {
				stack.push(nextToken);
			}
		}
		if (paranCount != 0){
			throw new IllegalArgumentException();
		}
		return Double.parseDouble(stack.pop());

	}

	// Assuming no unary operators
	private static String parseMyString(String s) {
		double leftNum = 0;
		double rightNum = 0;
		double result = 0;
		StringTokenizer tokens = new StringTokenizer(s, "{}()*/+-", true);
		if (tokens.countTokens() != 3) {
			throw new IllegalArgumentException();
		}
		String nextToken = tokens.nextToken();

		
		try {
			leftNum = Double.parseDouble(nextToken);

		} catch (NumberFormatException nfe) {

		}
		String operator = tokens.nextToken();
		try {
			rightNum = Double.parseDouble(nextToken);

		} catch (NumberFormatException nfe) {

		}
		switch (operator) {
		case "+":
			result = leftNum + rightNum;
			return Double.toString(result);
			

		case "-":
			result = leftNum - rightNum;
			return Double.toString(result);
		
		
		case "*":
			result = leftNum * rightNum;
			return Double.toString(result);
			
			
		case "/":
			result = leftNum / rightNum;
			return Double.toString(result);
			
		default:
			throw new IllegalArgumentException();
			
		}
		//throw new IllegalArgumentException();
		
		
	
			

	}
	
	public static void main(String[] args){
		System.out.println(evaluateInfix("( 2 + 2 )"));
	}

}
