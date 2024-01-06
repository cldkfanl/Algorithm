import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int arr[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N-1];
        int input = Integer.parseInt(br.readLine());
        for(int i=0; i<N-1; i++){
            int j = Integer.parseInt(br.readLine());
            arr[i] = j-input;
            input = j;
        }
        int gcd2 = gcd2();
        int output = 0;
        for(int i=0; i<N-1; i++){
            output += arr[i]/gcd2-1;
        }
      System.out.println(output);
    }
    static int gcd2(){
        int result = arr[0];
        for(int i=1; i<N-1; i++){
            result = gcd(result, arr[i]);
        }
        return result;
    }
    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}