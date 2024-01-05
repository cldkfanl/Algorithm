import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String a = st.nextToken();
    	String b = st.nextToken();
    	
    	int len = a.length();
    	for(int i=0; i<b.length() - a.length() + 1; i++) {
    		int tmp = 0;
    		for(int j=0; j<a.length(); j++) {
    			if(a.charAt(j) != b.charAt(j+i)) {
    				tmp++;
    			}
    		}
    		
    		len = Math.min(tmp, len);
    	}
    	System.out.println(len);
	}
}
