import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] >= i-j && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        if(dp[N-1] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[N-1]);
        }
    }
}
