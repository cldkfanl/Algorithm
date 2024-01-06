import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hash = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	String Name = st.nextToken();
        	String state = st.nextToken();
        	if(state.equals("enter")) {
        		hash.add(Name);
        	}
        	else {
        		if(hash.contains(Name)) {
        			hash.remove(Name);
        		}
        	}
        }
        String arr[] = hash.toArray(new String[hash.size()]);
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--) {
        	System.out.println(arr[i]);
        }
    }
}
