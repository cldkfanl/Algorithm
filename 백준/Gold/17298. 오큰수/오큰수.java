import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static int arr[];
	public static int arr_2[];
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        count = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	arr = new int[count];
    	arr_2 = new int[count];
        for(int i=0; i<count; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        asdf();
        System.out.println(sb);
	}
	public static void asdf() {
		Stack<Integer> stack = new Stack();
		for(int i=0; i<count; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr_2[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			arr_2[stack.pop()] = -1;
		}
		for(int i=0; i<count; i++) {
			sb.append(arr_2[i]).append(' ');
		}
	}
}
