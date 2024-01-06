import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        int maxlen = Integer.MIN_VALUE;
        int minlen = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	maxlen = Math.max(maxlen, arr[i]);
        }
        minlen = 0;
        while(minlen<= maxlen) {
        	int mid = (maxlen + minlen)/2;
        	long comp = 0;
        	for(int i=0; i<N; i++) {
        		if(arr[i] - mid > 0) {
        			comp += arr[i] - mid;
        		}
        	}
        	if(comp < M) {
        		maxlen = mid - 1;
        	}
        	else if(comp >= M) {
        		minlen =  mid + 1;
        	}
        }
        System.out.println(maxlen);
    }
}
