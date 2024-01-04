import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int xa = Integer.parseInt(st.nextToken());
        int ya = Integer.parseInt(st.nextToken());
        int xb = Integer.parseInt(st.nextToken());
        int yb = Integer.parseInt(st.nextToken());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());
        double ablen = Math.sqrt(Math.pow(xa - xb, 2) + Math.pow(ya - yb, 2));
        double bclen = Math.sqrt(Math.pow(xb - xc, 2) + Math.pow(yb - yc, 2));
        double aclen = Math.sqrt(Math.pow(xc - xa, 2) + Math.pow(yc - ya, 2));
        double output = Math.min(ablen, Math.min(bclen, aclen));
        double outputmax = Math.max(ablen, Math.max(bclen, aclen));
        if((xb - xa) * (yc - ya) == (xc-xa) * (yb-ya)) {
        	System.out.println(-1.0);
        }
        else {
        	System.out.println(2 * (outputmax - output));
        }
        
	}
}
