import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

	public static int count;
	public static int arr[][];
	public static boolean flag[];
	public static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        arr = new int[count][count];
        flag = new boolean[count];
        for(int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            flag[i] = false;
            for(int j=0; j<count; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<count; i++) {
        	flag[i] = true;
        	asdf(i,i,0,0);
        }
        System.out.println(min);

    }
    public static void asdf(int start, int Now, int sum, int cnt) {
    	if(cnt == count-1) {
    		if(arr[Now][0] != 0) {
    			sum += arr[Now][0];
    			min = Math.min(min, sum);
    		}
    		return;
    	}
        for(int i=0; i<count; i++) {
        	if(!flag[i] && arr[Now][i] != 0) {
        		flag[i] = true;
        		asdf(start, i, sum+ arr[Now][i], cnt + 1);
        		flag[i] = false;
        	}
        }
    }
}
