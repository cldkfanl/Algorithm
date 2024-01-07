import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        
        if(N == 1 || N == 0) {
        	System.out.println(N);
        }
        else {
        	
        	N -- ;
        	
            long arr[][] = {{1,1} , {1,0}};
        	long A[][] = {{1,0} , {0,1}};
        	
        	while(N > 0) {
        		if(N % 2 == 1) {
        			A = multiply(A, arr);
        		}
        		arr = multiply(arr , arr);
        		
        		N/= 2;
        	}
        	System.out.println(A[0][0]);
        }
    }
    static long[][] multiply(long[][] o1 , long[][] o2){
    	
    	long ret[][] = new long[2][2];
    	
    	ret[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % 1000000007;
    	ret[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % 1000000007;
    	ret[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % 1000000007;
    	ret[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % 1000000007;
    	
    	return ret;
    }
}
