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
        int R = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++) {
        	StringTokenizer st_2 = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st_2.nextToken());
        	}
        }
        while(R-- >0) {
        	int arr2[][] = new int[N][M];
        	for(int i1=0; i1<Math.min(N, M)/2; i1++) {
                	for(int j = i1; j<M-1-i1; j++) {
                		arr2[i1][j] = arr[i1][j+1];
                	}
                	for(int j = i1+1; j<M-i1; j++) {
                		arr2[N-1-i1][j] = arr[N-1-i1][j-1];
                	}
                	for(int j = i1; j<N-1-i1; j++) {
                		arr2[j][M-1-i1] = arr[j+1][M-1-i1];
                	}
                	for(int j = i1+1; j<N-i1; j++) {
                		arr2[j][i1] = arr[j-1][i1];
                	}
        	}

            arr = arr2;
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println("");
        }
	}
}
