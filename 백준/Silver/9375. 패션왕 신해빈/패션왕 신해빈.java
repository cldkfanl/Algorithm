import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
        	int count2 = Integer.parseInt(br.readLine());
            	HashMap<String, Integer> names = new HashMap<>();
            	while(count2 -- >0) {
            		StringTokenizer st = new StringTokenizer(br.readLine());
            		st.nextToken();
            		String key = st.nextToken();
            		if(!names.containsKey(key)) {
            			names.put(key, 1);
            		}
            		else {
            			int val = names.get(key);
            			names.put(key, val + 1);
            		}
            	}
            	int result = 1;
            	for(int val : names.values()) {
            		result *=(val+1);
            	}
                 sb.append(result-1).append('\n');
        	}
        System.out.println(sb);
	}
}
