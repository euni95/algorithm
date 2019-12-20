import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class B_1931_회의실배정 {

	public static void main(String[] args) {
		int[][] conferences = { { 3, 5 }, { 1, 6 }, { 5, 7 }, { 5, 9 }, { 1, 4 }, { 6, 10 }, { 8, 11 }, { 2, 13 },
				{ 3, 8 }, { 12, 14 } };

		Arrays.sort(conferences, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int end = -1;
		int cnt = 0;
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < conferences.length; i++) {
			if (conferences[i][0] > end) {
				cnt++;
				list.add(conferences[i]);
				end = conferences[i][1];
			}
		}
		for(int[] a : list) {
			System.out.print(Arrays.toString(a) + " ");
		}
		System.out.println(cnt);
	}

}
