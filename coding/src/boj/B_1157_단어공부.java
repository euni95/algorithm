import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1157_단어공부 { // 과제

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toUpperCase().toCharArray();
		int[] al = new int[26];
		int max = 0;
		int cnt = 0;
		char result = ' ';
		
		for(int i = 0; i < word.length; i++) {
			int temp = word[i] - 'A';
			al[temp]++;
			if(max < al[temp]) max = al[temp];
		}
		for(int i = 0; i < 26; i++) {
			if(max == al[i]) {
				cnt++;
				result = (char) (i + 'A');
				if(cnt > 1) {
					System.out.println("?");
					break;
				}
			}
		}
		if(cnt == 1) System.out.println(result);
	}
}
