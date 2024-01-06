import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String arr[] = new String[1001];
        arr[1] = "SK";
        arr[2] = "CY";
        arr[3] = "SK";
        for(int i=4; i<=1000; i++) {
        	if(arr[i-3] == "SK") {
        		arr[i] = "CY";
        	}
        	else {
        		arr[i] = "SK";
        	}
        }
        System.out.println(arr[N]);
    }
}
