import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	public static int arr[];
	public static boolean flag[];
	public static int count;
	public static int select[];
	public static int max = 0;
	public static int com = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        arr = new int[count];
        flag = new boolean[count];
        select = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<count; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	flag[i] = false;
        }
        asdf(0);
        System.out.println(com);


    }
    public static void asdf(int depth) {
    	if(depth == count) {
    		com = Math.max(com, getresult());
    		return;
    	}
    	for(int i=0; i<count; i++) {
			if(!flag[i]) {
    			flag[i] = true;
    			select[depth] = arr[i];
    			asdf(depth +1);
    			flag[i] = false;
    		}
    	}
    }
    public static int getresult() {
    	int sum = 0;
    	for(int i=0; i<count-1; i++) {
    		sum += Math.abs(select[i] - select[i+1]);
    	}
    	return sum;
    }
}
