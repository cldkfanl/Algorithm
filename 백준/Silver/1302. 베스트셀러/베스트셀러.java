import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hash = new HashMap<>();
        int max = 0;
        for(int i=0; i<N; i++) {
        	String tmp = br.readLine();
        	if(hash.get(tmp) == null) {
        		hash.put(tmp, 1);
        	}
        	else {
        		hash.put(tmp, hash.get(tmp) + 1);
        	}
        }
        String arr[] = new String[2];
        String ans = "";
        for(String s:hash.keySet()) {
        	if(max < hash.get(s)) {
        		ans = s;
        		max = hash.get(s);
        	}
        	else if(ans != null && max == hash.get(s)) {
        		arr[0] = ans;
        		arr[1] = s;
        		Arrays.sort(arr);
        		ans = arr[0];
        	}
        }
        System.out.println(ans);
	}
}
