import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        boolean check[] = new boolean[1000001];
    	int output[] = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	check[arr[i]] = true;
        }
        for(int i=1; i<= 1000000; i++) {
        	if(check[i]) {
        		for(int j=2 * i ; j<=1000000; j+= i) {
        			if(check[j]) {
        				output[i] ++;
        				output[j] --;
        			}
        		}
        	}
        }
    	for(int i=0; i<N; i++) {
    		System.out.print(output[arr[i]] + " ");
    	}
    }
}
