import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = (int) Math.round((double)n * 0.15);
        double sum = 0;
        for(int i=min; i<n-min; i++) {
        	sum += arr[i];
        }
        System.out.println(Math.round(sum / (n-min*2)));
    }
}
