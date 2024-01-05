import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int min = 100001;
	public static int arr[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        arr= new int[a + 1];
        for(int i=1; i*i <= a; i++) {
        	arr[i*i] = 1;
        }
        System.out.println(asdf(a));
    }
    
    public static int asdf(int number) {
    	if(arr[number] == 0) {
    		arr[number] = min;
        	for(int i=(int)Math.sqrt(number); i>=0; i--) {
        		int pow = (int)Math.pow(i, 2);
        		arr[number] = Math.min(asdf(number-pow) + 1, arr[number]);
        	}
    	}
    	
    	return arr[number];
    }
}
