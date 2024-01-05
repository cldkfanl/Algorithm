import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[] = new int[a+3];
        int max[] = new int[a+3];
        for(int i=1; i<=a; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        max[1] = arr[1];
        if(a>1) {
        	max[2] = arr[1] + arr[2];
        }
        for(int i = 3; i<=a; i++) {
        	max[i] = Math.max(Math.max(max[i-1], max[i-2] + arr[i]), max[i-3] + arr[i-1]+ arr[i]);
        }
        System.out.println(max[a]);
    }
}
