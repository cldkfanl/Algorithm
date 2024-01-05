import java.util.*;
import java.io.*;
public class Main {
	static boolean arr[];
	static boolean flag[];
	static int N;
	static int count = 0;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1) {
        	System.out.println(0);
        }
        else {
            arr = new boolean[N+1];
            arr[0] = arr[1] = true;
            for(int i=2; i*i <= N; i++) {
            	if(!arr[i]) {
            		for(int j=i*i ; j<=N; j+=i) {
            			arr[j] = true;
            		}
            	}
            }
            List<Integer> flag = new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
            	if(!arr[i]) {
            		flag.add(i);
            	}
            }
            int count = 0, left = 0, right = 0;
            int sum = flag.get(0);
            while(right <flag.size()) {
            	if(sum == N) {
            		count++;
            		sum -= flag.get(left);
            		left++;
            	}
            	else if(sum < N) {
            		right++;
            		if(right<flag.size()) {
            			sum += flag.get(right);
            		}
            	}
            	else {
            		sum -= flag.get(left);
            		left++;
            	}
            }
            System.out.println(count);
        }
	}
}
