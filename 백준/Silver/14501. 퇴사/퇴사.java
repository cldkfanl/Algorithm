import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int arr[][] = new int[count][2];
        for(int i=0; i<count; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st2.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        int max[] = new int[count+1];
        for(int i=0; i<count; i++) {
        	if(i + arr[i][0] <=count) {
        		max[i + arr[i][0]] = Math.max(max[i + arr[i][0]], max[i]+arr[i][1]);
        	}
        	max[i+1] = Math.max(max[i+1], max[i]);
        }
        Arrays.sort(max);
        System.out.println(max[count]);
    }
}
