import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	boolean arr[] = new boolean[10001];
    	
    	for(int i=1; i<=10000; i++) {
    		String tmp = "" + i;
    		int cmp = i;
    		for(int j=0; j<tmp.length(); j++) {
    			cmp += Integer.parseInt(tmp.substring(j,j+1));
    		}
    		if(cmp <= 10000) {
        		arr[cmp] = true;
    		}
    	}
    	for(int i=1; i<=10000; i++) {
    		if(!arr[i]) {
    			System.out.println(i);
    		}
    	}
    }
}
