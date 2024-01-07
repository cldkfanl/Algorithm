import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
    	int[] arr = new int[a+1];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=a; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[a+1];
        dp[1] = 1;
        for(int i=2; i<=a; i++) {
            dp[i] = 1;
        	for(int j = 1; j<i; j++) {
        		if(arr[j]<arr[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}