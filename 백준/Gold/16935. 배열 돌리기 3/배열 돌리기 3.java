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
        int count = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++) {
        	StringTokenizer st_2 = new StringTokenizer(br.readLine());
        	for(int j =0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st_2.nextToken());
        	}
        }
        StringTokenizer st_3 = new StringTokenizer(br.readLine());
        while(count-- >0) {
        	int input = Integer.parseInt(st_3.nextToken());
        	switch(input) {
        	case 1 : 
        		int transmap[][] = new int[N][M];
        		for(int i1 = 0; i1<N; i1++) {
            		for(int j1 = 0; j1<M; j1++) {
        				transmap[N-1-i1][j1] = arr[i1][j1];
        			}
        		}
        		arr = transmap;
        		break;
        	case 2 :
        		transmap = new int[N][M];
        		for(int i1 = 0; i1<N; i1++) {
            		for(int j1 = 0; j1<M; j1++) {
        				transmap[i1][M-1-j1] = arr[i1][j1];
        			}
        		}
        		arr = transmap;
        		break;
        	case 3 :
        		transmap = new int[M][N];
        		for(int i1= 0; i1<N; i1++) {
        			for(int j1 =0; j1<M; j1++) {
        				transmap[j1][N-1-i1] = arr[i1][j1];
        			}
        		}
        		int temp = M;
        		M = N;
        		N = temp;
        		arr = transmap;
        		break;
        	case 4 :
        		transmap = new int[M][N];
        		for(int i1= 0; i1<N; i1++) {
        			for(int j1 =0; j1<M; j1++) {
        				transmap[M-1-j1][i1] = arr[i1][j1];
        			}
        		}
        		temp = M;
        		M = N;
        		N = temp;
        		arr = transmap;
        		break;
        	case 5 :
        		transmap = new int[N][M];
        		for(int i1 = 0; i1<N/2; i1++) {
            		for(int j1 = 0; j1<M/2; j1++) {
            			transmap[i1][j1] = arr[i1+N/2][j1];
            			transmap[i1+N/2][j1] = arr[i1+N/2][j1+M/2];
            			transmap[i1+N/2][j1+M/2] = arr[i1][j1+M/2];
            			transmap[i1][j1+M/2] = arr[i1][j1];
        			}
        		}
        		arr = transmap;
        		break;
        	case 6 :
        		transmap = new int[N][M];
        		for(int i1 = 0; i1<N/2; i1++) {
            		for(int j1 = 0; j1<M/2; j1++) {
        				transmap[i1][j1] = arr[i1][j1+M/2];
        				transmap[i1][j1+M/2] = arr[i1+N/2][j1+M/2];
        				transmap[i1+N/2][j1+M/2] = arr[i1+N/2][j1];
        				transmap[i1+N/2][j1] = arr[i1][j1];
        			}
        		}
        		arr = transmap;
        		break;
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println("");
        }
	}
}
