import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int arr[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(start<=N && end <=N) {
        	if(sum >= S && min > end - start) {
        		min = end-start;
        	}
        	if(sum < S) {
        		sum += arr[end];
        		end++;
        	}
        	else {
        		sum -= arr[start];
        		start++;
        	}
        }
        if(min == Integer.MAX_VALUE) {
        	System.out.println(0);
        }
        else {
        	System.out.println(min);
        }
	}
}
