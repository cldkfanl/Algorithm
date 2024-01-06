import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[1001];
        arr[0] = arr[1] = true;
        for(int i=2 ; i*i <= 1000; i++) {
    		if(!arr[i]) {
    			for(int j = i*i; j<=1000; j+= i) {
    				arr[j] = true;
    			}
    		}
    	}
        int cnt[] = new int[N+1];
        int output = 1;
        boolean check[] = new boolean[N+1];
    	for(int i=2; i<=N; i++) {
    		if(!arr[i]) {
    			for(int j=i; j<=N; j+=i) {
    				if(!check[j]) {
    					cnt[j] = output;
    					check[j] = true;
    					output++;
    					
    					if(cnt[j] == K) {
    						System.out.println(j);
    						break;
    					}
    				}
    			}
    		}
    	}
    }
}
