import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int count;
	public static boolean flag[];
	public static StringBuilder sb;
	public static int arr[];
	public static int arr_2[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        count = Integer.parseInt(br.readLine());
        flag = new boolean[count];
        arr = new int[count];
        arr_2 = new int[count];
        for(int i=0; i<count; i++) {
        	flag[i] = false;
        	arr[i] = i+1;
        }
        asdf(0);
        System.out.println(sb);
    }
    public static void asdf(int depth) {
    	if(depth == count) {
    		for(int i=0; i<count; i++) {
    			sb.append(arr_2[i]).append(' ');
    		}
    		sb.append('\n');
    	}
    	
    	
    	for(int i=0; i<count; i++) {
    		if(!flag[i]) {
    			flag[i] = true;
    			arr_2[depth] = arr[i];
    			asdf(depth + 1);
    			flag[i] = false;
    		}
    	}
    }
}
