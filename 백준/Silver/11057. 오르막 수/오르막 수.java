import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[][] = new int[a+1][10];
        for(int i=0; i<10; i++) {
        	arr[0][i] = 1;
        }
        for(int i=1; i<=a; i++) {
        	for(int j=0; j<10; j++) {
        		for(int j1=0; j1<=j; j1++) {
        			arr[i][j] = (arr[i][j]+ arr[i-1][j1])%10007;
        		}
        	}
        }
        System.out.println(arr[a][9]%10007);
    }
}
