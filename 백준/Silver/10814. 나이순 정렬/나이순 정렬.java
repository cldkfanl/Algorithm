import java.util.*;

public class Main {
		public static void main(String[] args)  {
			Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        String arr[][] = new String[a][2];
	        
	        for(int i=0; i<a; i++) {
	        	arr[i][0] = sc.next();
	        	arr[i][1] = sc.next();
	        }
	        Arrays.sort(arr, new Comparator<String[]>(){
	        	@Override
	        	public int compare(String[] s1, String[] s2) {
	        		if(s1[0] == s2[0] ) {
	        			return 1;
	        		}
	        		else {
	        			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
	        		}
	        	}
	        });
	        
	        for(int i=0; i<a; i++) {
	        	System.out.println(arr[i][0] + " " + arr[i][1]);
	        }
	    }
	}