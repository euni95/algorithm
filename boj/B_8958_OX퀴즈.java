import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			char[] quiz = br.readLine().toCharArray();
			
			char temp = quiz[0];
			int result = 0, cnt = 1;
			if(temp == 'O') result += cnt++;
			for(int i = 1; i < quiz.length; i++) {
				if(quiz[i] == 'O') {
					result += cnt++;
				}
				else cnt = 1;
				temp = quiz[i];
			}
			System.out.println(result);
		}
	}

}
