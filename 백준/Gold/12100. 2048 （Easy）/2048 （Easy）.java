import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int max = 0;
	static int cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N]; 
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = new int[5];
        bfs(0, arr);
        
        System.out.println(max);
    }
    static void bfs(int depth, int map[][]) {
    	if(depth == 5) {
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				max = Math.max(max, map[i][j]);
    			}
    		}
    		return;
    	}
    	for(int i=0; i<4; i++) {
    		int copy[][] = new int[N][N];
    		for(int j=0; j<N; j++) {
    			copy[j] = Arrays.copyOf(map[j], N);
    		}
    		copy = newSwipe(copy, i);
    		bfs(depth + 1, copy);
    	}
    }
    static int[][] newSwipe(int base[][] , int num){
    	switch(num) {
    	case 0 : // 상
    		for(int i=0; i<N; i++) {
    			int index = 0;
    			int block = 0;
    			for(int j=0; j<N; j++) {
    				if(base[j][i] != 0) {
    					if(block == base[j][i]) {
    						base[index - 1][i] = block * 2;
    						block = 0;
    						base[j][i] = 0;
    					}
    					else {
    						block = base[j][i];
    						base[j][i] = 0;
    						base[index][i] = block;
    						index ++;
    					}
    				}
    			}
    		}
    		break;
    	case 1 : // 하
    		for(int i=0; i<N; i++) {
    			int index = N-1;
    			int block = 0;
    			for(int j=N-1; j>=0; j--) {
    				if(base[j][i] != 0) {
    					if(block == base[j][i]) {
    						base[index + 1][i] = block * 2;
    						block = 0;
    						base[j][i] = 0;
    					}
    					else {
    						block = base[j][i];
    						base[j][i] = 0;
    						base[index][i] = block;
    						index --;
    					}
    				}
    			}
    		}
    		break;
    	case 2 : // 좌
    		for(int i=0; i<N; i++) {
    			int index = 0;
    			int block = 0;
    			for(int j=0; j<N; j++) {
    				if(base[i][j] != 0) {
    					if(block == base[i][j]) {
    						base[i][index - 1] = block * 2;
    						block = 0;
    						base[i][j] = 0;
    					}
    					else {
    						block = base[i][j];
    						base[i][j] = 0;
    						base[i][index] = block;
    						index ++;
    					}
    				}
    			}
    		}
    		break;
    	case 3 :
    		for(int i=0; i<N; i++) {
    			int index = N-1;
    			int block = 0;
    			for(int j=N-1; j>=0; j--) {
    				if(base[i][j] != 0) {
    					if(block == base[i][j]) {
    						base[i][index + 1] = block * 2;
    						block = 0;
    						base[i][j] = 0;
    					}
    					else {
    						block = base[i][j];
    						base[i][j] = 0;
    						base[i][index] = block;
    						index --;
    					}
    				}
    			}
    		}
    		break;
    	}
    	return base;
    }
}
