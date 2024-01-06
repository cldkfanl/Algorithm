import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i=0; i<a; i++) {
        	int count = Integer.parseInt(br.readLine());
        	int arr[][] = new int[count+1][2];
        	int dp[][] = new int[count+1][2];
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<count; j++) {
        		arr[j][0] = Integer.parseInt(st.nextToken());
        	}
        	StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<count; j++) {
        		arr[j][1] = Integer.parseInt(st_2.nextToken());
        	}
        	dp[0][1] = arr[0][1];
        	dp[0][0] = arr[0][0];
        	dp[1][1] = dp[0][0] + arr[1][1];
        	dp[1][0] = dp[0][1] + arr[1][0];
        	for(int j=2; j<count; j++) {
        		dp[j][0] = arr[j][0] + Math.max(dp[j-1][1], dp[j-2][1]);
        		dp[j][1] = arr[j][1] + Math.max(dp[j-1][0], dp[j-2][0]);
        	}
        	System.out.println(Math.max(dp[count-1][0], dp[count-1][1]));
        }
    }
}
