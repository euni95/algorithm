import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		int cnt = 0;
		
		for(int i = 0; i < len; i++) {
			if(i < len - 1 && input[i] == 'c') {
				if(input[i + 1] == '=' || input[i + 1] == '-') {
					cnt++;
					i++;
					continue;
				}
			}
			if(i < len - 2 && input[i] == 'd' && input[i + 1] == 'z' && input[i + 2] == '=') {
				cnt++;
				i += 2;
				continue;
			}
			if(i < len - 1 && input [i] == 'd' && input[i + 1] == '-') {
				cnt++;
				i++;
				continue;
			}
			if(i < len - 1 && input [i] == 'l' && input[i + 1] == 'j') {
				cnt++;
				i++;
				continue;
			}
			if(i < len - 1 && input [i] == 'n' && input[i + 1] == 'j') {
				cnt++;
				i++;
				continue;
			}
			if(i < len - 1 && input [i] == 's' && input[i + 1] == '=') {
				cnt++;
				i++;
				continue;
			}
			if(i < len - 1 && input [i] == 'z' && input[i + 1] == '=') {
				cnt++;
				i++;
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
