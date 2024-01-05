import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder r_stack;
	public static StringBuilder l_stack;
	public static int count;
	public static int a_len;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l_stack = new StringBuilder(br.readLine());
        r_stack = new StringBuilder();
        int b = Integer.parseInt(br.readLine());
    	while(b-- >0) {
        		
    		char[] command = br.readLine().toCharArray();

            	
    		switch(command[0]) {
    		case 'P':
    			p_1(command[2]);
    			break;
            		
    		case 'L' :
    			l_1();
    			break;
            		
    		case 'D':
    			d_1();
    			break;
    			
    		case 'B' :
    			b_1();
    			break;
    		}
    	}
    	System.out.print(l_stack);
    	r_stack.reverse();
    	System.out.print(r_stack);
	}
	public static void p_1(char input) {
		l_stack.append(input);
	}
	public static void l_1() {
        if (l_stack.length() != 0) {
            r_stack.append(l_stack.charAt(l_stack.length() - 1));
            l_stack.setLength(l_stack.length() - 1);
        }
    }

    public static void d_1() {
        if (r_stack.length() != 0) {
            l_stack.append(r_stack.charAt(r_stack.length() - 1));
            r_stack.setLength(r_stack.length() - 1);
        }
    }

    public static void b_1() {
        if (l_stack.length() != 0) {
            l_stack.setLength(l_stack.length() - 1);
        }
    }
}
