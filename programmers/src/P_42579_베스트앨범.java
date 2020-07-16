import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class P_42579_베스트앨범 {
	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
		int[] plays = {500, 600, 150, 800, 2500, 500000};
		solution.solution(genres, plays);
	}

	static class Solution {
		public int[] solution(String[] genres, int[] plays) {
			int[] answer = {};
			int size = genres.length;
			
			HashMap<String, Genre> map = new HashMap<>();
			for(int i = 0; i < size; i++) {
				String temp = genres[i];
				
				if(map.containsKey(temp)) {
					Genre get = map.get(temp);
					get.setTotalPlay(plays[i]);
					get.setList(i, plays);
				}
				else map.put(temp, new Genre(plays[i], i));
			}
			ArrayList<String> list = new ArrayList<>();
			list.addAll(map.keySet());
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int n1 = map.get(o1).getTotalPlay();
					int n2 = map.get(o2).getTotalPlay();
					return n2 - n1;
				}
			});
			
			int len = 0;
			for(int i = 0; i < list.size(); i++) {
				len += map.get(list.get(i)).getListSize();
			}
			answer = new int[len];
			int idx = 0;
			for(int i = 0; i < list.size(); i++) {
				ArrayList<Integer> temp = map.get(list.get(i)).getList();
				if(temp.size() == 1) {
					answer[idx++] = temp.get(0);
					continue;
				}
				for(int j = 0; j < 2; j++) {
					answer[idx++] = temp.get(j);
				}
			}
			return answer;
		}
	}

	static class Genre {
		int totalPlay;
		ArrayList<Integer> list = new ArrayList<>();

		public Genre(int totalPlay, int number) {
			this.totalPlay = totalPlay;
			this.list.add(number);
		}

		public int getTotalPlay() {
			return totalPlay;
		}

		public void setTotalPlay(int totalPlay) {
			this.totalPlay += totalPlay;
		}
		
		public ArrayList<Integer> getList() {
			return list;
		}
		
		public int getListSize() {
			return list.size();
		}

		public void setList(int number, int[] plays) {
			int playCnt = plays[number];
			boolean flag = false;
			for(int i = list.size() - 1; i >= 0; i--) {
				int temp = plays[list.get(i)];
				if(temp > playCnt || temp == playCnt) {
					flag = true;
					list.add(i + 1, number);
					break;
				}
			}
			if(!flag) list.add(0, number);
			if(list.size() > 2) list.remove(2);
		}
	}
}
