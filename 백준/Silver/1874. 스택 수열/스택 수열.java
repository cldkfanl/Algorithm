import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] stack_1;
	public static int count = 0;
	public static int value = 0;
	public static int count_2 = 0;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String output = "";
        int a = Integer.parseInt(br.readLine());
    	stack_1 = new int[a+1];
    	stack_1[0] = 0;
    	for(int i=0; i<a; i++) {
    		int input = Integer.parseInt(br.readLine());
    		push_pop(input);
    	}
    	if(count_2 == 0) {
        	System.out.println(sb);
    	}
    	else {
    		System.out.println("NO");
    	}

	}
	public static void push_pop(int input) {
		if(input > stack_1[count]) {
				count++;
				value ++;
				stack_1[count] = value;
				sb.append("+").append('\n');
				push_pop(input);
			}
			else if(input == stack_1[count]) {
				stack_1[count] = count;
				count --;
				sb.append("-").append('\n');
			}
			else {
				count_2 ++;
			}
	}
}
