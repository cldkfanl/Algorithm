import java.io.*;
import java.util.*;
public class Main {
	static class Loc{
		int num;
		int height;
		
		Loc(int num, int height){
			this.num = num;
			this.height = height;
		}
	}
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	Stack<Loc> stack = new Stack<>();
    	StringBuilder sb = new StringBuilder();
    	int arr[] = new int[N];
    	for(int i=0; i<N; i++) {
    		int tmp = Integer.parseInt(st.nextToken());
    		while(!stack.isEmpty()) {
    			Loc now = stack.peek();
    			if(tmp < now.height) {
    				sb.append(now.num + " ");
    				break;
    			}
    			else {
    				stack.pop();
    			}
    		}
    		if(stack.isEmpty()) {
    			sb.append(0 + " ");
    		}
    		stack.push(new Loc(i+1, tmp));
    	}
    	System.out.println(sb);
	}
}
