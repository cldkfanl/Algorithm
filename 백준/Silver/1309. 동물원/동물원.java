import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[] = new int[a+1];
        arr[0] = 1;
        arr[1] = 3;
        for(int i=2; i<=a; i++) {
        	arr[i] = (arr[i-1]*2 + arr[i-2])%9901;
        }
        System.out.println(arr[a]%9901);
    }
}