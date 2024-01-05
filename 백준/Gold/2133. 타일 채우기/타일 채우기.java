import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int output = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[]=new int[31];
        arr[0] = 1;
        arr[2] = 3;
        for(int i=4; i<=30; i+=2) {
        	arr[i] = arr[i-2] *3;
        	for(int j=0; j<=i-4; j+=2) {
        		arr[i] += arr[j]*2;
        		}

        	}
    	System.out.println(arr[a]);
    }
}