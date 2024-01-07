import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static LinkedList<Integer> q;
	public static int q_len =0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int b = Integer.parseInt(br.readLine());
        
        q = new LinkedList<>();
        
    	while(b-- >0) {
        		
    		st = new StringTokenizer(br.readLine(), " ");

            	
    		switch(st.nextToken()) {
    		case "push":
    			push(Integer.parseInt(st.nextToken()));
    			break;
            		
    		case "pop" :
    			sb.append(pop()).append('\n');
    			break;
            		
    		case "size":
    			sb.append(s_1()).append('\n');
    			break;
    			
    		case "empty" :
    			sb.append(e_1()).append('\n');
    			break;
    			
    		case "front" :
    			sb.append(f_1()).append('\n');
    			break;
    			
    		case "back" :
    			sb.append(b_1()).append('\n');
    			break;
    		}
    	}
    	System.out.println(sb);
	}
	public static void push(int i) {
		q.add(i);
		q_len++;
	}
	public static int pop() {
		if(q_len != 0) {
			q_len--;
			return q.poll();
		}
		else {
			return -1;
		}

    }
	public static int s_1() {
		return q_len;
    }
	public static int e_1() {
		if(q_len == 0) {
			return 1;
		}
		else {
			return 0;
		}
    }
	public static int f_1() {
		if(q_len != 0) {
			return q.peek();
		}
		else {
			return -1;
		}
    }
	public static int b_1() {
		if(q_len != 0) {
			return q.peekLast();
		}
		else {
			return -1;
		}
    }
}
