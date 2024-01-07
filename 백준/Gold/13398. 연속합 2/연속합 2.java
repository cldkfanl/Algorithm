import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
    	int dp[] = new int[a];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<a; i++) {
        	dp[i] = Integer.parseInt(st.nextToken());
        }
        int max_r[] = new int[a+2];
        int max_l[] = new int[a+2];
        max_r[a-1] = dp[a-1];
        max_l[0] = dp[0];
        int max_sum = max_l[0];
        
        for(int i = 1; i< a; i++) {
        	max_l[i] = Math.max(dp[i], max_l[i-1] + dp[i]);
        	max_sum = Math.max(max_sum, max_l[i]);

        }
        for(int i=a-2; i>=0; i--) {
        	max_r[i] = Math.max(dp[i], max_r[i+1] + dp[i]);
        }
        int max_lrs = Integer.MIN_VALUE;
        for(int i=1; i<a-1; i++) {
        	max_lrs = Math.max(max_lrs, max_l[i-1] + max_r[i+1]);
        }
        System.out.println(Math.max(max_sum, max_lrs));
    }
}
