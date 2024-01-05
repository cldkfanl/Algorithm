import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        long sum = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];
        }
        Arrays.sort(arr);
        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;
        
        for(int i=0; i<N; i++) {
        	int jump = 0;
        	int count = 1;
        	int i_val = arr[i];
        	for(int j= i+1; j<N; j++) {
        		if(i_val != arr[j]) {
        			break;
        		}
        		count++;
        		jump++;
        	}
        	if(count > mode_max) {
        		mode_max = count;
        		mode = i_val;
        		flag = true;
        	}
        	else if(count == mode_max && flag) {
        		mode = i_val;
        		flag = false;
        	}
        	i+= jump;
        }


        
        double avg = (double)sum / N;
        int cen = arr[N/2];
        int lod = arr[N-1] - arr[0];
        System.out.println(Math.round(avg));
        System.out.println(cen);
        System.out.println(mode);
        System.out.println(lod);
    }
}
