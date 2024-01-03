import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[5001];   //dp용 배열 생성
        for(int i=1; i<=5; i++) {   //초기값 설정
        	if(i == 3 || i == 5) {  //1~5까지 3,5로 나누어 떨어지는 값 1
        		dp[i] = 1;			//나누어 떨어지지 않는 값 -1
        	}
        	else {
        		dp[i] = -1;
        	}
        }
        for(int i=6; i<=5000; i++) {
        	int thr = Integer.MAX_VALUE;
        	int fiv = Integer.MAX_VALUE;
        	if(dp[i-3] == -1 && dp[i-5] == -1) {  //주어진 수가 3,5 둘다 나누어 떨어지지 않는 경우
        		dp[i] = -1;					  	  //-1 부여
        	}
        	else {
            	if(dp[i-3] != -1) {
            		thr = dp[i-3] + 1;
            	}
            	if(dp[i-5] != -1) {
            		fiv = dp[i-5] + 1;
            	}
            	dp[i] = Math.min(thr, fiv);		  //사용하는 제일 적은 수의 봉지 구하기
        	}
        }
        System.out.println(dp[N]);
	}
}
