package answer;
import java.util.Scanner;
// 백준 1436 영화감독 숌
public class B_1436_영화감독숌_answer {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int i = 665;
		for(; i <= 10000666; i++) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}
			if(cnt == n) {
				break;
			}
		}
		System.out.println(i);
	}
}
