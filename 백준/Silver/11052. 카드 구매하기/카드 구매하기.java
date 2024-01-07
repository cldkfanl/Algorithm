import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
    	int[] arr = new int[a+1];
    	arr[0] = 0;
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=a; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[a+1];
        for(int i=1; i<=a; i++) {
        	for(int j=1; j<=i; j++) {
        		dp[i] = Math.max(arr[j] + dp[i-j], dp[i]);
        	}
        }
        System.out.println(dp[a]);
    }
}