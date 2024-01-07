import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] input, index;
	static ArrayList<Integer> Lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        input = new int[N+1];
        index = new int[N+1];
        Lis = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        Lis.add(Integer.MIN_VALUE);
        
        for(int i=1; i<=N; i++) {
        	int num = input[i];
        	int left = 1;
        	int right = Lis.size() -1;
        	
        	if(num > Lis.get(Lis.size() - 1)) {
        		Lis.add(num);
        		index[i] = Lis.size() - 1;
        	}
        	else {
        		while(left < right) {
        			int mid = (left + right) / 2;
        			if(Lis.get(mid) >= num) {
        				right = mid;
        			}
        			else {
        				left = mid + 1;
        			}
        		}
        		Lis.set(right, num);
        		index[i] = right;
        	}
        }
    	sb.append(Lis.size() - 1).append("\n");
    	Stack<Integer> stack = new Stack();
    	
    	int idx = Lis.size() - 1;
    	
    	for(int i= N; i> 0; i--) {
    		if(index[i] == idx) {
    			idx --;
    			stack.push(input[i]);
    		}
    	}
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop()).append(" ");
    	}
    	System.out.println(sb);
    }
}
