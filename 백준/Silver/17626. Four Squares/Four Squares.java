import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[50001];
        for(int i=0; i<=50000; i++) {
        	arr[i] = Integer.MAX_VALUE;
        }
        arr[1] = 1;
        for(int i=2; i<=50000; i++) {
        	for(int j=1; j<=Math.sqrt(i); j++) {
        		arr[i] = Math.min(arr[i], arr[i-(j*j)]+1);
        		if(Math.sqrt(i) == j) {
        			arr[i] = 1;
        		}
        	}
        }
        System.out.println(arr[n]);
    }
}