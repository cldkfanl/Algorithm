import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long arr[] = new long[K];
        long maxlen = 0;
        for(int i=0; i<K; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	maxlen = Math.max(maxlen, arr[i]);
        }
        long left = 1;
        long right = maxlen;
        while(left<=right) {
        	long mid = (left + right) /2;
        	long count = 0;
        	for(int i=0; i<K; i++) {
        		count += arr[i] / mid;
        	}
        	if(count >= N) {
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }
        System.out.println(right);
    }
}
