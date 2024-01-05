import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int arr[] = new int[10];
        for(int i=0; i<N.length(); i++) {
        	int tmp = Integer.parseInt(N.substring(i,i+1));
        	arr[tmp] ++;
        }
        int max;
        if((arr[6] + arr[9])% 2 == 0) {
        	max = (arr[6] + arr[9]) / 2;
        }
        else {
        	max = (arr[6] + arr[9]) / 2 + 1;
        }
        for(int i=0; i<10; i++) {
        	if(i == 6 || i == 9) {
        		continue;
        	}
        	else {
            	max = Math.max(arr[i], max);
        	}
        }
        System.out.println(max);
    }
}
