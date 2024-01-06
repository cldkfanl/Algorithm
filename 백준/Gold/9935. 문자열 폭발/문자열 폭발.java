import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String bomb = br.readLine();
        int bombSize = bomb.length();
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<input.length(); i++) {
        	st.push(input.charAt(i));
        	
        	if(st.size() >= bombSize) {
        		boolean flag = true;
        		
        		for(int j=0; j<bombSize; j++) {
        			if(st.get(st.size() - bombSize + j) != bomb.charAt(j)) {
        				flag = false;
        				break;
        			}
        		}
        		if(flag) {
        			for(int j=0; j<bombSize; j++) {
        				st.pop();
        			}
        		}
        	}
        }
        while(!st.empty()) {
        	sb.append(st.pop());
        }
        if(sb.isEmpty()) {
        	System.out.println("FRULA");
        }
        else {
            System.out.println(sb.reverse());
        }
    }
}
