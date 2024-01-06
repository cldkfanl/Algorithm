import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	boolean arr[] = new boolean[246913];
    	
    	arr[0] = arr[1] = true;
    	
    	for(int i=2 ; i*i <= 246912; i++) {
    		if(!arr[i]) {
    			for(int j = i*i; j<=246912; j+= i) {
    				arr[j] = true;
    			}
    		}
    	}
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	int n = Integer.parseInt(br.readLine());
        	if(n == 0) {
        		break;
        	}
        	else {
        		int cnt = 0;
        		for(int i=n+1; i<=2*n; i++) {
        			if(!arr[i]) {
        				cnt++;
        			}
        		}
        		System.out.println(cnt);
        	}
        }
    }
}