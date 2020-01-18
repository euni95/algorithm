
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_2607_비슷한단어 { // 비슷한 단어

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());
		String[] word = br.readLine().split("");

		ArrayList<String> origin = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();

		for (int i = 0; i < word.length; i++) {
			origin.add(word[i]);
		}
		int result = 0;
		int originSize = origin.size();
		for (int i = 0; i < cnt - 1; i++) {
			temp.clear();
			word = br.readLine().split("");

			int tempSize = word.length;
			if (Math.abs(originSize - tempSize) > 1)
				continue;

			for (int j = 0; j < word.length; j++) {
				temp.add(word[j]);
			}

			if (originSize > tempSize) {
				for (String c : origin) {
					temp.remove(c);
				}

				if (temp.isEmpty())
					result++;
			}
			else if(originSize == tempSize) {
				for (String c : origin) {
					temp.remove(c);
				}

				if (temp.isEmpty() || temp.size() == 1)
					result++;
			}
			else {
				for (String c : origin) {
					temp.remove(c);
				}

				if (temp.size() == 1)
					result++;
			}

		}
		System.out.println(result);
	}

}
