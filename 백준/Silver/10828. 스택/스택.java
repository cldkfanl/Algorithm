import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] stack; 
	public static int count = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        
        int a = Integer.parseInt(br.readLine());
    	stack = new int[a];
    	while(a-- >0) {
        		
    		st = new StringTokenizer(br.readLine(), " ");
            	
    		switch(st.nextToken()) {
    		case "push":
    			push(Integer.parseInt(st.nextToken()));
    			break;
            		
    		case "pop" :
    			sb.append(pop()).append('\n');
    			break;
            		
    		case "size" :
    			sb.append(size()).append('\n');
    			break;
    			
    		case "empty" :
    			sb.append(empty()).append('\n');
    			break;
    			
    		case "top" :
    			sb.append(top()).append('\n');
    			break;
    			}
    		}
    	System.out.println(sb);
    	}
	public static void push(int item) {
		stack[count] = item;
		count ++;
	}
	public static int pop() {
		if(count == 0) {
			return -1;
		}
		else {
			int output = stack[count-1];
			stack[count-1] = 0;
			count --;
			return output;
		}
	}
	public static int size() {
		return count;
		
	}
	public static int empty() {
		if(count == 0) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public static int top() {
		if(count == 0) {
			return -1;
		}
		else {
			return stack[count-1];
		}
	}
}
