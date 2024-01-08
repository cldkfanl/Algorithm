import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static StringBuilder sb = new StringBuilder();
	public static int score_min = Integer.MAX_VALUE;
	public static int score[][];
	public static int team1[];
	public static int team2[];
	public static boolean flag_2[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        score = new int[count][count];
        flag_2 = new boolean[count];
        for(int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<count; j++) {
            	score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=count/2; i++) {
        	team1 = new int[i];
        	team2 = new int[count-i];
            asdf(0, 0, i);
        }
        System.out.println(score_min);
        System.out.println(sb);


	}
	public static void teams() {
		int cnt = 0;
		for(int i=0; i<count; i++) {
			boolean is = true;
			for(int j=0; j<team1.length; j++) {
				if(i == team1[j]) {
					is = false;
					break;
				}
			}
			if(is) {
				team2[cnt++] = i;
			}
		}
	}
	public static void asdf(int depth, int start, int k) {
		if(depth == k) {
			
			int score_true = 0;
			for(int i=0; i<team1.length; i++) {
				for(int j=i; j<team1.length; j++) {
					if(i ==j) {
						continue;
					}
					score_true += score[team1[i]][team1[j]] + score[team1[j]][team1[i]];
				}
			}
			teams();
			int score_false = 0;
			for(int i=0; i<team2.length; i++) {
				for(int j=i; j<team2.length; j++) {
					if(i ==j) {
						continue;
					}
					score_false += score[team2[i]][team2[j]] + score[team2[j]][team2[i]];
				}
			}
			score_min = Math.min(Math.abs(score_false -score_true),score_min);
			return;
		}
		
		for(int i=start; i<count; i++) {
			team1[depth] = i;
				asdf(depth+1, i + 1, k);
			}
		}
}
