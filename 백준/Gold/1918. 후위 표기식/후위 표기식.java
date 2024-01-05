import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
        	char tmp = input.charAt(i);
        	if(tmp >= 'A' && tmp <= 'Z') {
        		sb.append(tmp);
        	}
        	else {
        		if(tmp == '(') {
        			st.add(tmp);
        		}
        		else if(tmp == ')') {
        			while(!st.isEmpty() && st.peek() != '(') {
        				sb.append(st.pop());
        			}
        			if(!st.isEmpty()) {
        				st.pop();
        			}
        		}
        		else {
        			while(!st.isEmpty() && compare(st.peek()) >= compare(tmp)) {
        				sb.append(st.pop());
        			}
        			st.add(tmp);
        		}
        	}
        }
    	while(!st.isEmpty()) {
    		sb.append(st.pop());
    	}
        System.out.println(sb);
    }
    static int compare(char cmp) {
    	if(cmp == '*' || cmp == '/') {
    		return 2;
    	}
    	else if(cmp == '+' || cmp == '-') {
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
}
