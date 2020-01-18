import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW_4408_자기방으로돌아가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().replace(" ", ""));
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().replace(" ", ""));
			ArrayList<Node> stu = new ArrayList<>();
			
			StringTokenizer st = null;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if(start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				
				if(start % 2 == 0) start /= 2;
				else {
					if(start != 1) start = start / 2 + 1;
				}
				
				if(end % 2 == 0) end /= 2;
				else end = end / 2 + 1;
				
				stu.add(new Node(start, end));
			}
			
			stu.sort(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.start - o2.start;
				}
			});
			
			int cnt = 0;
			while(stu.size() > 0) {
				int start, end = 0;
				for(int i = 0; i < stu.size(); i++) {
					start = stu.get(i).start;
					
					if(start > end) {
						end = stu.get(i).end;
						stu.remove(i);
						i--;
					}
				}
				cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	static class Node {
		int start, end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + "]";
		}
	}
}
