import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J_2247_도서관 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> student = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			student.add(new Point(S, E));
		}
		Collections.sort(student, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.start == o2.start) return o1.end < o2.end ? -1 : 1;
				else return o1.start < o2.start ? -1 : 1;
			}
		});
		int tempS = student.get(0).start;
		int tempE = student.get(0).end;
		
		int full = 0;
		int empty = 0;
		for(Point p : student) {
			if(tempE < p.start) {
				if(p.start - tempE > empty) empty = p.start - tempE;
				tempS = p.start;
				tempE = p.end;
			}
			else {
				if(tempE < p.end) tempE = p.end;
				if(tempE - tempS > full) full = tempE - tempS;
			}
		}
		System.out.println(full + " " + empty);
	}

	static class Point {
		int start;
		int end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "(" + start + ", " + end + ")";
		}

	}
}
