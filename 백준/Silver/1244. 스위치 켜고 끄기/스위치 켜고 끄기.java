import java.io.*;
import java.util.*;
public class Main {
	static int arr[];
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	arr = new int[N+1];
    	for(int i=1; i<=N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int S = Integer.parseInt(br.readLine());
    	for(int i=0; i<S; i++) {
    		st = new StringTokenizer(br.readLine());
    		int sta = Integer.parseInt(st.nextToken());
    		int num = Integer.parseInt(st.nextToken());
    		if(sta == 1) {
    			for(int j=1; j<=N; j++) {
    				if(j % num == 0) {
    					swch(j);
    				}
    			}
    		}
    		else if(sta == 2){
    			int left = num-1;
    			int right = num+1;
    			swch(num);
    			while(true) {
        			if(left > 0 && right <= N && (arr[left] == arr[right])) {
    					swch(left);
    					swch(right);
    					left --;
    					right++;
        			}
        			else {
        				break;
        			}
    			}
    		}
    	}
    	for(int i=1; i<=N; i++) {
    		System.out.print(arr[i] + " ");
    		if(i % 20 == 0) {
    			System.out.println("");
    		}
    	}
	}
	static void swch(int num) {
		if(arr[num] == 1) {
			arr[num] = 0;
		}
		else {
			arr[num] = 1;
		}
	}
}
