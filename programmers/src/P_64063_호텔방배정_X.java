import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_64063_호텔방배정_X {

	public static void main(String[] args) {
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		System.out.println(Arrays.toString(solution(k, room_number)));
	}

	public static long[] solution(long k, long[] room_number) {
		int length = room_number.length;
		long[] answer = new long[length];
		Map<Long, Long> map = new HashMap<Long, Long>();

		for (int i = 0; i < length; ++i) {
			long room = room_number[i];
			if (map.containsKey(room)) {
				long next = map.get(room);
				ArrayList<Long> list = new ArrayList<Long>();
				list.add(next);
				while (map.containsKey(next)) {
					next = map.get(next);
					list.add(next);
				}
				answer[i] = next;
				long nextOfNext = next + 1;
				while (map.containsKey(nextOfNext)) {
					nextOfNext = map.get(nextOfNext);
				}
				map.put(room, nextOfNext);
				for (int j = 0; j < list.size(); ++j) {
					map.put(list.get(j), nextOfNext);
				}
			} else {
				long next = room + 1;
				while (map.containsKey(next)) {
					next = map.get(next);
				}
				map.put(room, next);
				answer[i] = room;
			}
            System.out.println(map);
		}

		return answer;
	}

}