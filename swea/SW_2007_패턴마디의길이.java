import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String line = br.readLine();
			String result = "";
			boolean check = false;
			for (int i = 1; i <= 10; i++) {
				String temp = line.substring(0, i);

				int len = line.length() - line.length() % i;
				for (int j = i; j < len; j += i) {
					check = false;
					if (temp.equals(line.substring(j, j + i))) {

						result = temp;
						check = true;
					} else {
						break;
					}
				}
				if (check)
					break;
			}
			
			if(result.length() == 0) result = line;
			System.out.println("#" + t + " " + result.length());
		}
	}

}
