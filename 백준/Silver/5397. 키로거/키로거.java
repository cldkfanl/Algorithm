import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	String input = br.readLine();
        	Stack<String> left = new Stack<>();
        	Stack<String> right = new Stack<>();
        	for(int j=0; j<input.length(); j++) {
        		String tmp = input.substring(j,j+1);
        		if(tmp.equals("<")) {
        			if(!left.isEmpty()) {
        				right.push(left.pop());
        			}
        		}
        		else if(tmp.equals(">")) {
        			if(!right.isEmpty()) {
        				left.push(right.pop());
        			}
        		}
        		else if(tmp.equals("-")) {
        			if(!left.isEmpty()) {
        				left.pop();
        			}
        		}
        		else {
            		left.push(tmp);
        		}
        	}
        	while(!left.isEmpty()) {
        		right.push(left.pop());
        	}
        	while(!right.isEmpty()) {
        		sb.append(right.pop());
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
}
