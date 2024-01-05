import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[8];
        for(int i=0; i<8; i++) {
        	arr[i] = (int) Math.pow(2, i);
        }
        int cnt = 0;
        while(N != 0) {
        	for(int i=7; i>=0; i--) {
        		if(N >= arr[i]) {
        			N -= arr[i];
        			cnt++;
        		}
        		else {
        			continue;
        		}
        	}
        }
        System.out.println(cnt);
    }
}
