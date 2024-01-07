import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[] = new int[a];
        int count[] = new int[a];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<a; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	count[i] = arr[i]; 
        }
        for(int i=1; i<a; i++) {
        	for(int j=i-1; j>=0; j--) {
        		if(arr[i] > arr[j]) {
        			count[i] = Math.max(count[i], arr[i] + count[j]);
        		}
        	}
        }
        Arrays.sort(count);
        System.out.println(count[a-1]);
    }
}

