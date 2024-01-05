import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        if(n == 0) {
        	System.out.println(0);
        }
        else {
        	while(n != 1) {
                if(Math.abs(n) % 2 == 1) {
                	n = (n-1) /(-2);
                	sb.append(1);
                }
                else {
                	n /= -2;
                	sb.append(0);
                }
        	}
        	sb.append(1);
        }
        for(int i = sb.length(); i>0; i--) {
        	System.out.print(sb.substring(i-1,i));
        }
    }
}