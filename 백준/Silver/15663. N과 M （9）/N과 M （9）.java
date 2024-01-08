import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	public static int arr[];
	public static int arr_2[];
	public static boolean flag[];
	public static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");

        arr = new int[M];
        arr_2 = new int[N];
        flag = new boolean[N];
        for(int i=0; i<N; i++) {
        	arr_2[i] = Integer.parseInt(st_2.nextToken());
        }
        Arrays.sort(arr_2);
        int count = 0;
        for(int i=0; i<N-1; i++) {
        	if(arr_2[i+1] > arr_2[i]) {
        		count ++;
        	}
        }
        NandM(N,M,0);
        System.out.println(sb);
	}
    public static void NandM(int N, int M, int depth) {
    	if(depth == M) {
    		for(int val : arr) {
    			sb.append(val).append(' ');
    		}
    		sb.append('\n');
    		return;
    	}
    	int prev = 0;
    	for(int i=0; i<N; i++) {
    		if(!flag[i] && (i == 0 || arr_2[i] != prev)) {
    			flag[i] = true;
    			arr[depth] = arr_2[i];
    			prev = arr_2[i];
    			NandM(N,M, depth+1);
    			flag[i] = false;
    		}
    	}
    }
}