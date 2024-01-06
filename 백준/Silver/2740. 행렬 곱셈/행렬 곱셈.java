import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int arr[][] = new int[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	st = new StringTokenizer(br.readLine());
    	int M2 = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int tmp[][] = new int[M2][K];
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<K; j++) {
    			tmp[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	int output[][] = new int[N][K];
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<K; j++) {
    			for(int k=0; k<M; k++) {
    				output[i][j] += arr[i][k] * tmp[k][j];
    			}
    		}
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<K; j++) {
    			System.out.print(output[i][j] + " ");
    		}
    		System.out.println("");
    	}
	}
}
