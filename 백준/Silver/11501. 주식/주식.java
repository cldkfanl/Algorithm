import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[N];
        	for(int j=0; j<N; j++) {
        		arr[j] = Integer.parseInt(st.nextToken());
        	}
        	int max = Integer.MIN_VALUE;
        	long count = 0;
        	for(int j=N-1; j>=0; j--) {
        		if(arr[j] > max) {
        			max = arr[j];
        		}
        		else if(arr[j] < max) {
            		count += max-arr[j];
        		}
        	}
        	sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
