import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
    	int[] arr = new int[a+1];
    	String[] arr_2 = new String[a+1];
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=a; i++) {
        	arr_2[i] = st.nextToken();
        	arr[i] = Integer.parseInt(arr_2[i]);
        }
        int dp[] = new int[a+1];
        dp[1] = 1;
        for(int i=2; i<=a; i++) {
        	dp[i] = 1;
        	for(int j = 1; j<i; j++) {
        		if(arr[j]<arr[i]) {
        			if(dp[i] <= dp[j]) {
        				arr_2[i] = arr_2[j] + " " + arr[i];
        			}
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i<dp.length; i++) {
        	if(dp[i] > max) {
        		max = dp[i];
        		maxIndex = i;
        	}
        }
        System.out.println(max);
        System.out.println(arr_2[maxIndex]);
    }
}