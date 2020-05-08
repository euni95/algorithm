import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
TC

frodo fradi crodo abc123 frodoc
fr*d* abc1**

frodo fradi crodo abc123 frodoc
*rodo *rodo ******

frodo fradi crodo abc123 frodoc
fr*d* *rodo ****** ******

*/

public class P_64064_불량사용자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] user_id = br.readLine().split(" ");
		String[] banned_id = br.readLine().split(" ");

		int result = solution(user_id, banned_id);
		System.out.println("\n-------------- result --------------");
		System.out.println(result);
	}
	
	static public int solution(String[] user_id, String[] banned_id) {
		ArrayList<Integer>[] banned_list = new ArrayList[banned_id.length];

		for (int i = 0; i < banned_id.length; i++) {
			String temp = banned_id[i];
			banned_list[i] = new ArrayList<>();

			for (int j = 0; j < user_id.length; j++) {
				String user = user_id[j];
				if (user.length() != temp.length())
					continue;

				boolean check = true;
				for (int k = 0; k < user.length(); k++) {
					if (temp.charAt(k) == '*')
						continue;
					if (temp.charAt(k) != user.charAt(k)) {
						check = false;
						break;
					}
				}
				if (check) banned_list[i].add(j);
			}
		}
		visited = new ArrayList<>();
		for(int i = 0; i < banned_list[0].size(); i++) {
			int temp = banned_list[0].get(i);
			dfs(banned_list, temp, 1, 1 << temp);
		}
		return visited.size();
	}
	
	static ArrayList<Integer> visited;
	private static void dfs(ArrayList<Integer>[] banned_list, int num, int idx, int v) {
		if(idx == banned_list.length) {
			for(int visit : visited) {
				if(visit == v) return;
			}
			return;
		}
		
		for(int i = 0; i < banned_list[idx].size(); i++) {
			int temp = banned_list[idx].get(i);
			if((v & (1 << temp)) > 0) continue; 
			dfs(banned_list, temp, idx + 1, v | (1 << temp));
		}
	}

}
