import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[1000001];
        Arrays.fill(arr, 1);
        
        for(int i = 2; i <= 1000000; i ++) {
        	for(int j = 1; j*i<=1000000; j++) {
        		arr[i*j] += i;
        	}
        	arr[i] += arr[i-1];
        }
        
        while(N-- >0) {
        	int input = Integer.parseInt(br.readLine());
        	sb.append(arr[input]).append("\n");
        }
        System.out.println(sb);
	}
}
