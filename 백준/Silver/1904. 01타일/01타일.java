import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=1000000; i++) {
        	arr[i] = arr[i-2] + arr[i-1];
        	arr[i] %= 15746;
        }
        System.out.println(arr[N]);
    }
}
