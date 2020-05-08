import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/*
TC

{{2},{2,1},{2,1,3},{2,1,3,4}}
{{1,2,3},{2,1},{1,2,4,3},{2}}
{{20,111},{111}}
{{123}}
{{4,2,3},{3},{2,3,4,1},{2,3}}

*/

public class P_64065_튜플 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] result = solution(input);
		System.out.println("\n-------------- result --------------");
		System.out.println(Arrays.toString(result));
	}

	static public int[] solution(String s) {
		ArrayList<int[]> list = new ArrayList<>();
		s = s.substring(2, s.length() - 2);
		s = s.replace("},{", ":");
		String[] strings = s.split(":");
		
		for(String str : strings) {
			String[] string = str.split(",");
			int[] input = new int[string.length];
			for(int j = 0; j < string.length; j++) {
				input[j] = Integer.parseInt(string[j]);
			}
			list.add(input);
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1.length - o2.length;
			}
		});

		int[] answer = new int[list.size()];
		answer[0] = list.get(0)[0];
		for(int i = 1; i < list.size(); i++) {
			
			int[] temp = list.get(i);
			for(int j = 0; j < i; j++) {
				for(int k = 0; k < i+1; k++) {
					if(answer[j] == temp[k]) {
						temp[k] = 0;
					}
				}
				for(int k = 0; k < i+1; k++) {
					if(temp[k] != 0) answer[i] = temp[k];
				}
			}
		}
		return answer;
	}
}
