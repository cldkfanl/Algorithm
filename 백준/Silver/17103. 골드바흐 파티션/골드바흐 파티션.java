import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[1000001];
        for(int i=2; i<= 1000000; i++) {
        	arr[i] = true;
        }
        for(int i=2; i*i <= 1000000; i++) {
        	if(arr[i]) {
        		for(int j=i*i; j<=1000000; j+=i) {
        			arr[j] = false;
        		}
        	}
        }
        for(int i=0; i<n; i++) {
        	int a = Integer.parseInt(br.readLine());
    		int count = 0;
        	for(int j = 2; j<=a/2; j++) {
        		if(arr[j]&& arr[a-j]) {
        			count++;
        		}
        	}
        	System.out.println(count);
        }
    }
}