import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        String input = br.readLine();
        
        int input_len = input.length();
                
        boolean true_false = false;
        
        Stack < Character > stack = new Stack < > ();
        
        for(int i=0; i<input_len; i++) {
        	if(input.charAt(i) == '<') {
        		while(!stack.isEmpty()) {
        			sb.append(stack.pop());
        		}
        		true_false= true;
        	}
        	else if(input.charAt(i) == '>') {
        		true_false = false;
        		sb.append(input.charAt(i));
        		continue;
        	}
        	
        	if(true_false == true) {
        		sb.append(input.charAt(i));
        	}
        	else if (true_false == false) {
        		if(input.charAt(i) == ' ') {
        			while(!stack.isEmpty()) {
        				sb.append(stack.pop());
        			}
        			sb.append(' ');
        			continue;
        		}
        		else {
        			stack.push(input.charAt(i));
        		}
        	}
        	if(i == input.length() -1) {
        		while(!stack.isEmpty()) {
        			sb.append(stack.pop());
        		}
        	}
        }
        System.out.println(sb);
	}
}
