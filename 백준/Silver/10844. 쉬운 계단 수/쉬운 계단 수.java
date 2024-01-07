import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        long arr_Int[][] = new long[a+1][10];
        arr_Int[1][0] = 0;
        for(int i=1; i<=9; i++) {
        	arr_Int[1][i] = 1;
        }
        for(int i=2; i<=a; i++) {
        	arr_Int[i][0] = arr_Int[i-1][1];
        	arr_Int[i][9] = arr_Int[i-1][8];
        	for(int j=1; j<=8; j++) {
        		arr_Int[i][j] = (arr_Int[i-1][j-1] + arr_Int[i-1][j+1])%1000000000;
        	}
        }
        long output = 0;
        for(int i=0; i<=9; i++) {
        	output += arr_Int[a][i];
        }
        System.out.println(output%1000000000);
    }
}
