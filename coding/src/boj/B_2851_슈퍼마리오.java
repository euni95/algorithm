package study_190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2851_슈퍼마리오 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0, sub = 9999;
		for (int i = 0; i < 10; i++) {

			int num = Integer.parseInt(br.readLine());
			sum += num;

			if (sub < Math.abs(100 - sum)) {
				sum -= num;
				break;
			}
			sub = Math.abs(100 - sum);
		}
		System.out.println(sum);
	}

}
