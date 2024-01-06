import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int arr[][];
	static int blue = 0;
	static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        check(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
    static void check(int x, int y, int size) {
    	int cmp = arr[x][y];
    	boolean state = true;
    	for(int i = x; i<x + size; i++) {
    		for(int j=y; j<y + size; j++) {
    			if(cmp != arr[i][j]) {
    				state = false;
    			}
    		}
    	}
    	if(state) {
    		if(cmp == 1) {
    			blue++;
    		}
    		else {
    			white++;
    		}
    	}
    	else {
    		size /= 2;
    		check(x, y, size);
    		check(x + size , y , size);
    		check(x , y + size , size);
    		check(x + size , y + size , size);
    	}
    }
}
