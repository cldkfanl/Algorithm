import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
    public static int arr[];
    public static int arr_2[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        arr_2 = new int[M];
        StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<M; i++) {
        	String token = st_2.nextToken();
        	char ask = token.charAt(0);
        	arr[i] = (int)ask;
        }
        Arrays.sort(arr);
        asdf(N, M, 0, 0);
        System.out.println(sb);
    }
    public static void asdf(int N, int M, int depth, int start) {
    	if(depth == N) {
    		int aeioucount = 0;
    		int elsecount = 0;
    		for(int i=0; i<N; i++) {
    			if(arr_2[i] == 97 || arr_2[i] == 101 || arr_2[i] == 105 || arr_2[i] == 111 || arr_2[i] == 117) {
    				aeioucount ++;
    			}
    			else {
    				elsecount++;
    			}
    		}
    		if(aeioucount >= 1 && elsecount >=2) {
        		for(int i=0; i<N; i++) {
        			sb.append((char)arr_2[i]);
        		}
        		sb.append('\n');
    		}
    	}
    	for(int i=start; i<M; i++) {
    		arr_2[depth] = arr[i];
    		asdf(N, M, depth+1, i+1);
    	}
    }
}
