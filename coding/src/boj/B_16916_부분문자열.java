import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_16916_부분문자열 { // kmp 알고리즘

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		String part = br.readLine();
		int len = part.length();
		boolean check = false;
		
		for(int i = 0; i < text.length() - len + 1; i++) {
			String temp = text.substring(i, i + len);
			if(part.equals(temp)) {
				System.out.println(1);
				check = true;
				break;
			}
		}
		if(!check) System.out.println(0);
	}

}
