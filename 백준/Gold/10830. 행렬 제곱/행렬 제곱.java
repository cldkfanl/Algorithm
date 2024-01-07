import java.io.*;
import java.util.*;


public class Main {
	static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int arr[][] = new int[N][N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        	}
        }
        
        int result[][] = pow(arr,B);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		sb.append(result[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    static int[][] pow(int[][] input, long exp) {
    	if(exp == 1) {
    		return input;
    	}
    	
    	int ret[][] = pow(input, exp/2);
    	
    	ret = multiply(ret,ret);
    	
    	if(exp % 2 == 1) {
    		ret = multiply(ret, input);
    	}
    	
    	return ret;
    }
    static int[][] multiply(int[][] o1, int[][] o2) {
    	
    	int output[][] = new int[N][N];
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			for(int k=0; k<N; k++) {
    				output[i][j] += o1[i][k] * o2[k][j];
    				output[i][j] %= 1000;
    			}
    		}
    	}
    	return output;
    }
}
