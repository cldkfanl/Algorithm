import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[i] = tmp;
        }
        int sum = 0;
        for(int i=0; i<K; i++) {
        	sum += arr[i];
        }
        int max = sum;
        int out = 0;
        int in = K;
        while(in < N) {
        	sum = sum - arr[out] + arr[in];
        	out ++;
        	in++;
        	max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
