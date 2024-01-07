import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        long x = 0;
        for(int i=0; i<N; i++) {
        	Long tmp = Long.parseLong(br.readLine());
        	map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        	if(map.get(tmp) > max) {
        		max = map.get(tmp);
        		x = tmp;
        	}
        	else if(map.get(tmp) == max){
        		x = Math.min(x, tmp);
        	}
        }
        System.out.println(x);
	}
}
