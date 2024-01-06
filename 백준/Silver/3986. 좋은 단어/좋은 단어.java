import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	Stack<Character> st = new Stack<>();
        	if(input.length() % 2 != 0) {
        		continue;
        	}
        	else {
            	for(int j=0; j<input.length(); j++) {
            		char tmp = input.charAt(j);
            		if(st.isEmpty()) {
            			st.push(tmp);
            		}
            		else {
            			if(st.peek() == tmp) {
            				st.pop();
            			}
            			else {
            				st.push(tmp);
            			}
            		}
            	}
            	if(st.isEmpty()) {
            		ans ++;
            	}
        	}
        }
        System.out.println(ans);
	}
}
