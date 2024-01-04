import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[][] = new int[a+1][4];
        int arr_2[][] = new int[a+1][4];
        for(int i=0; i<a; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	arr[i+1][1] = Integer.parseInt(st.nextToken());
        	arr[i+1][2] = Integer.parseInt(st.nextToken());
        	arr[i+1][3] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            arr_2[1][i+1] = arr[1][i+1];
        }
        for(int i = 2; i<=a; i++) {
        	arr_2[i][1] = Math.min(arr_2[i-1][2] + arr[i][1], arr_2[i-1][3] + arr[i][1]);
        	arr_2[i][2] = Math.min(arr_2[i-1][1] +arr[i][2], arr_2[i-1][3] +arr[i][2]);
        	arr_2[i][3] = Math.min(arr_2[i-1][1] +arr[i][3], arr_2[i-1][2] +arr[i][3]);
        }
        int min = Math.min(arr_2[a][1], arr_2[a][2]);
        int min_2 = Math.min(min, arr_2[a][3]);
        System.out.println(min_2);
        
        
    }
}
