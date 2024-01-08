import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int totalpeople = 0;
	static int N;
	static int arr[][];
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            	totalpeople += arr[i][j];
            }
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		for(int d1 = 1; d1 < N; d1++) {
        			for(int d2 = 1; d2<N; d2++) {
        				if(i+d1+d2 >= N) {
        					continue;
        				}
        				if(j-d1<0 || j + d2 >= N) {
        					continue;
        				}
        				solution(i,j,d1,d2);
        			}
        		}
        	}
        }
        System.out.println(min);
    }
    static void solution(int x, int y, int d1, int d2) {
    	boolean flag[][] = new boolean[N][N];
    	
    	for(int i=0; i<=d1; i++) {
    		flag[x+i][y-i] = true;
    		flag[x+d2+i][y+d2-i] = true;
    	}
    	for(int i=0; i<=d2; i++) {
    		flag[x+i][y+i] = true;
    		flag[x+d1+i][y-d1+i] = true;
    	}
    	
    	int[] psum = new int[5];
    	for(int i=0; i<x+d1; i++) {
    		for(int j=0; j<=y; j++) {
    			if(flag[i][j]) {
    				break;
    			}
    			psum[0] += arr[i][j];
    		}
    	}
    	for(int i=0; i<=x+d2; i++) {
    		for(int j=N-1; j>y; j--) {
    			if(flag[i][j]) {
    				break;
    			}
    			psum[1] += arr[i][j];
    		}
    	}
    	for(int i=x+d1; i<N; i++) {
    		for(int j=0; j<y-d1+d2; j++) {
    			if(flag[i][j]) {
    				break;
    			}
    			psum[2] += arr[i][j];
    		}
    	}
    	for(int i=x+d2+1; i<N; i++) {
    		for(int j=N-1; j>=y-d1+d2; j--) {
    			if(flag[i][j]) {
    				break;
    			}
    			psum[3] += arr[i][j];
    		}
    	}
    	psum[4] = totalpeople;
    	for(int i=0; i<=3; i++) {
    		psum[4] -= psum[i];
    	}
    	Arrays.sort(psum);
    	min = Math.min(min, psum[4] - psum[0]);
    }
}
