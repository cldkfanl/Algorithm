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
        int max = dp[0];
        int max_2 = dp[0];
        for(int i = 1; i< a; i++) {
        	max = Math.max(dp[i], max + dp[i]);
        	max_2 = Math.max(max_2, max);
        }

        System.out.println(max_2);
    }
}
