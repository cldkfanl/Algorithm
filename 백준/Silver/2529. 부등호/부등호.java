import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean flag[];
	public static StringBuilder sb = new StringBuilder();
	public static int count;
	public static int[] arr_2;
	public static char[] arr;
	public static long max = Long.MIN_VALUE;
	public static long min = Long.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        arr_2 = new int[count+1];
        flag = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr= new char[count];
        for(int i=0; i<count; i++) {
        	String token = st.nextToken();
        	arr[i] = token.charAt(0);
        }
        for(int i=0; i<=9; i++) {
        	flag[i] = false;
        }
        for(int i=0; i<=9; i++) {
        	flag[i] = true;
        	arr_2[0] = i;
            asdf(1);
            flag[i] = false;
        }
        System.out.println(max);
        if(min < Math.pow(10, count)) {
            System.out.println("0" + min);
        }
        else {
            System.out.println(min);
        }
    }
    
    public static void asdf(int depth) {
    	if(depth == count + 1) {
    		String comp = "";
    		for(int i=0; i<=count; i++) {
    			comp += arr_2[i];
    		}
    		max = Math.max(max, Long.parseLong(comp));
    		min = Math.min(min, Long.parseLong(comp));
    		
    		return;
    	}
    	for(int i=0; i<10; i++) {
    		if(!flag[i]) {
    			if(arr[depth-1] == '<') {
        			if(i > arr_2[depth-1]) {
        				flag[i] = true;
        				arr_2[depth] = i;
        				asdf(depth+1);
        				flag[i] = false;
        			}
    			}
    			else if(arr[depth-1] == '>') {
        			if(i < arr_2[depth-1]) {
        				flag[i] = true;
        				arr_2[depth] = i;
        				asdf(depth+1);
        				flag[i] = false;
        			}
    			}
    		}
    	}
	}
}
