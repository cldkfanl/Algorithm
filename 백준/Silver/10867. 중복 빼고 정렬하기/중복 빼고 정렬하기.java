import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	HashSet<Integer> hash = new HashSet<>();
    	for(int i=0; i< N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(!hash.contains(num)) {
    			hash.add(num);
    		}
    	}
    	int arr[] = new int[hash.size()];
    	int index = 0;
        for (int element : hash) {
            arr[index++] = element;
        }
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
        	System.out.print(arr[i] + " ");
        }
	}
}
