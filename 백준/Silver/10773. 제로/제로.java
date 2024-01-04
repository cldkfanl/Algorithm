import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++) {
        	int input = Integer.parseInt(br.readLine());
        	if(input != 0) {
        		stack.push(input);
        	}
        	else {
        		stack.pop();
        	}
        }
        int output = 0;
        while(!stack.isEmpty()) {
        	output += stack.pop();
        }
        System.out.println(output);
    }
}
