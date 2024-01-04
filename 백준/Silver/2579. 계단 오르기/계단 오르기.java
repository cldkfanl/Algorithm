import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Integer sum[];
	static int arr[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        sum = new Integer[count+1];
        arr = new int[count+1];
        for(int i=1; i<=count; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        sum[0] = arr[0];
        sum[1] = arr[1];
        if(count >= 2) {
			sum[2] = arr[1] + arr[2];
		}
        System.out.println(find(count));
	}
	static int find(int count) {
		if(sum[count] == null) {
			sum[count] = Math.max(find(count - 2), find(count - 3) + arr[count - 1]) + arr[count];
		}
		
		return sum[count];
	}
}
