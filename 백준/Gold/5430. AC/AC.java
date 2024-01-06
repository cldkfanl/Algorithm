import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
    		StringBuilder sb = new StringBuilder();
        	Deque<Integer> deq = new LinkedList<>();
        	String p = br.readLine();
        	int n = Integer.parseInt(br.readLine());
        	String input = br.readLine();
        	String inputTokens[] = input.substring(1, input.length() - 1).split(",");
        	for(int i=0; i<n; i++) {
        		deq.add(Integer.parseInt(inputTokens[i]));
        	}
    		boolean state = false;
    		boolean state2 = false;
        	for(int i=0; i<p.length(); i++) {
        		char tmp = p.charAt(i);
        		if(tmp == 'R') {
        			state = !state;
        		}
        		else {
        			if(deq.isEmpty()) {
        				System.out.println("error");
        				state2 = true;
        				break;
        			}
        			else {
            			if(state) {
            				deq.pollLast();
            			}
            			else if(!state) {
            				deq.pollFirst();
            			}
        			}
        		}
        	}
        	if(!state2) {
                sb.append("[");
            	if(state) {
            		while(!deq.isEmpty()) {
            			int output = deq.pollLast();
            			sb.append(output);
            			if(!deq.isEmpty()) {
            				sb.append(",");
            			}
            		}
            	}
            	else {
            		while(!deq.isEmpty()) {
            			int output = deq.pollFirst();
            			sb.append(output);
            			if(!deq.isEmpty()) {
            				sb.append(",");
            			}
            		}
            	}
            	System.out.println(sb+ "]");
        	}
        }
	}
}