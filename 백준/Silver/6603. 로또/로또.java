import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static StringBuilder sb;
	public static int arr[];
	public static int arr_2[];
	public static int count;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	count = Integer.parseInt(st.nextToken());
            if(count == 0) {
            	break;
            }
            else {
                sb = new StringBuilder();
            	arr = new int[count];
            	arr_2 = new int[count];
            	for(int i=0; i<count; i++) {
            		arr[i] = Integer.parseInt(st.nextToken());
            	}
            	asdf(0,0);
            	System.out.println(sb);
            }
        }
    }
    public static void asdf(int depth, int startnum) {
    	if(depth == 6) {
    		for(int i=0; i<6; i++) {
    			sb.append(arr_2[i]).append(' ');
    		}
    		sb.append('\n');
    	}
    	for(int i=startnum; i<count; i++) {
    			arr_2[depth] = arr[i];
    			asdf(depth + 1, startnum+1);
    			startnum++;
    	}
    }
}
