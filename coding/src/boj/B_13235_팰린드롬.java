import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_13235_팰린드롬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		boolean check = true;
		for(int i = 0; i < word.length / 2; i++) {
			if(word[i] != word[word.length - 1 - i]) {
				check = false;
				break;
			}
		}
		System.out.println(check);
	}

}
