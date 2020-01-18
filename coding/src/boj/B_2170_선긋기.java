import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.StringTokenizer;

public class B_2170_선긋기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> line = new ArrayList<>();
	
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			line.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(line);
		
		int start = line.get(0).start;
		int end = line.get(0).end;
		int sum = 0;
		for(int i = 1; i < N; i++) {
			int tempS = line.get(i).start;
			int tempE = line.get(i).end;
			
			if(tempS <= end) {
				if(tempE > end) end = tempE;
			}
			else {
				sum += end - start;
				start = tempS;
				end = tempE;
			}
		}
		sum += end - start;
		System.out.println(sum);
	}

	static class Point implements Comparable<Point> {
		int start;
		int end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Point o) {
			return this.start < o.start ? -1 : 1;
		}
	}
}
