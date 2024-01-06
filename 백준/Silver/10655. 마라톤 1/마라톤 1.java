import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        int output = 0;
        for(int i=0; i<N-1; i++) {
        	output += Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1]);
        }
        int minusLen = Integer.MIN_VALUE;
        for(int i=1; i<N-1; i++) {
        	int complen = Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1])
        	+ Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]) - 
        	Math.abs(arr[i-1][0] - arr[i+1][0]) - Math.abs(arr[i-1][1] - arr[i+1][1]);
        	minusLen = Math.max(minusLen, complen);
        }
        System.out.println(output - minusLen);
    }
}
