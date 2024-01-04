import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            // Calculate N! / (M! * (N - M)!)
            for (int j = 1; j <= N; j++) {
                numerator = numerator.multiply(BigInteger.valueOf(j));
            }
            for (int j = 1; j <= M; j++) {
                denominator = denominator.multiply(BigInteger.valueOf(j));
            }
            for (int j = 1; j <= (N - M); j++) {
                denominator = denominator.multiply(BigInteger.valueOf(j));
            }

            BigInteger output = numerator.divide(denominator);
            System.out.println(output);
        }
    }
}