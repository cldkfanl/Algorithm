import java.io.*;
import java.util.*;

public class Main {
	static boolean arr[];
    public static void main(String[] args) throws IOException {
    	arr = new boolean[10001];
    	arr[0] = arr[1] = true;
    	for(int i=2 ; i*i <= 10000; i++) {
    		if(!arr[i]) {
    			for(int j = i*i; j<=10000; j+= i) {
    				arr[j] = true;
    			}
    		}
    	}
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int fir = N/2;
        	int sec = N/2;
        	check(fir,sec);
        }
    }
    static void check(int fir, int sec) {
    	if(!arr[fir] && !arr[sec]) {
    		System.out.println(fir + " " + sec);
    	}
    	else {
    		check(fir-1 , sec+1);
    	}
    }
}
