import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<N; j++) {
        		arr[i][j] = input.charAt(j) - '0';
        	}
        }
        qTree(0,0,N);
        
        System.out.println(sb);
    }
    static void qTree(int x, int y, int size) {
    	if(checkSize(x,y,size)) {
    		sb.append(arr[x][y]);
    	}
    	else {
    		sb.append("(");
    		qTree(x, y, size/2);
    		qTree(x, y + size/2 , size/2);
    		qTree(x + size/2 , y, size/2);
    		qTree(x + size/2 , y + size/2 , size/2);
    		sb.append(")");
    	}
    }
    static boolean checkSize(int x, int y, int size) {
    	int start = arr[x][y];
    	for(int i=x; i< x + size; i++) {
    		for(int j=y; j<y + size; j++) {
    			if(arr[i][j] != arr[x][y]) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
}
