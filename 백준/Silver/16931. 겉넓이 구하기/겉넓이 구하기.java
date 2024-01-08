import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st2.nextToken());
        	}
        }
        int sum = 0;
    	for(int i=0; i<N; i++) {
    		for(int j=M-1; j>=1; j--) {
    			int space = arr[i][j-1] - arr[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += arr[i][M-1];
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<=M-2; j++) {
    			int space = arr[i][j+1] - arr[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += arr[i][0];
    	}
    	for(int j=0; j<M; j++) {
    		for(int i=N-1; i>=1; i--) {
    			int space = arr[i-1][j] - arr[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += arr[N-1][j];
    	}
    	for(int j=0; j<M; j++) {
    		for(int i=0; i<=N-2; i++) {
    			int space = arr[i+1][j] - arr[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += arr[0][j];
    	}
        sum += (M*N)*2;
        System.out.println(sum);
	}
}