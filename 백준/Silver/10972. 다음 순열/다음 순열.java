import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[count];
        for(int i=0; i<count; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = count-1;
        while(len>0 && arr[len-1] >= arr[len]) {
        	len --;
        }
        if(len == 0) {
        	System.out.println(-1);
        }
        else {
        	int b = len;
        	int min = arr[len];
        	for(int i = len+1; i<count; i++) {
        		if(arr[len-1] < arr[i] && min > arr[i]) {
        			min = arr[i];
        			b=i;
        		}
        	}
        	int temp = arr[b];
        	arr[b] = arr[len-1];
        	arr[len-1] = temp;
        	for(int i=0; i<len; i++) {
        		sb.append(arr[i]).append(' ');
        	}
        	for(int i=count-1; i>=len; i--) {
        		sb.append(arr[i]).append(' ');
        	}
        	
        }
        System.out.println(sb);
    }

}