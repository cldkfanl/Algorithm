import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayDeque<Integer> dq;
	public static int dq_len =0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int b = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<>();
        
    	while(b-- >0) {
    		st = new StringTokenizer(br.readLine(), " ");
    		switch(st.nextToken()) {
    		case "push_front":
    			push_front(Integer.parseInt(st.nextToken()));
    			break;
    			
    		case "push_back":
    			push_back(Integer.parseInt(st.nextToken()));
    			break;
    			
    		case "pop_front":
    			sb.append(pop_front()).append('\n');
    			break;
    		case "pop_back":
    			sb.append(pop_back()).append('\n');
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
	public static void push_front(int i) {
		dq.offerFirst(i);
		dq_len++;
	}
	public static void push_back(int i) {
		dq.offerLast(i);
		dq_len++;
	}
	public static int pop_front() {
		if(dq_len != 0) {
			int output = dq.peek();
			dq.pollFirst();
			dq_len--;
			return output;
		}
		else {
			return -1;
		}

    }
	public static int pop_back() {
		if(dq_len != 0) {
			int output = dq.peekLast();
			dq.pollLast();
			dq_len--;
			return output;
		}
		else {
			return -1;
		}

    }
	public static int s_1() {
		return dq_len;
    }
	public static int e_1() {
		if(dq_len == 0) {
			return 1;
		}
		else {
			return 0;
		}
    }
	public static int f_1() {
		if(dq_len != 0) {
			return dq.peek();
		}
		else {
			return -1;
		}
    }
	public static int b_1() {
		if(dq_len != 0) {
			return dq.peekLast();
		}
		else {
			return -1;
		}
    }
}
