import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	String input = br.readLine();
        	if(input.equals(".")) {
        		break;
        	}
        	Stack<Character> stack = new Stack<>();
        	boolean check = true;
        	for(int i=0; i<input.length(); i++) {
        		char currentChar = input.charAt(i);
        		if(currentChar == '(' || currentChar == '[') {
        			stack.push(currentChar);
        		}else if(currentChar == ')' || currentChar == ']') {
        			if(stack.isEmpty()) {
        				check = false;
        				break;
        			}else {
            			char top = stack.pop();
                        if ((currentChar == ')' && top != '(') || (currentChar == ']' && top != '[')) {
                            check = false;
                            break;
                        }
            		}
            	}
        	}
        	if(!stack.isEmpty()) {
        		check = false;
        	}
        	if(check) {
        		System.out.println("yes");
        	}
        	else {
        		System.out.println("no");
        	}
        }
    }
}
