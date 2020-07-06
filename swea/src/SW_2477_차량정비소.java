import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2477_차량정비소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
		int N, M, K, A, B;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접수 창구 개수
		M = Integer.parseInt(st.nextToken()); // 정비 창구 개수
		K = Integer.parseInt(st.nextToken()); // 차량 정비소를 방문한 고객의 수
		A = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 접수 창구 번호
		B = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 정비 창구 번호

		int[] aList = new int[N + 1];
		int[] bList = new int[M + 1];
		int[] tList = new int[K + 1];
		int[] tUse = new int[K + 1];

		Queue<Integer> aQ = new LinkedList<>();
		Queue<Integer> bQ = new LinkedList<>();

		int[] aState = new int[N + 1];
		int[] bState = new int[M + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) aList[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) bList[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= K; i++) tList[i] = Integer.parseInt(st.nextToken());

		int time = 0;
		int idx = 1;
		
		int[] aStart = new int[K + 1];
		int[] bStart = new int[K + 1];
		
		int result = 0;
		int cnt = 0;
		while(true) {
			if(cnt == K) break;
			for(int i = idx; i <= K; i++) {
				if(tList[i] > time) {
					idx = i;
					break;
				}
				if(time == tList[i]) {
					aQ.add(i);
				}
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return tUse[o1] - tUse[o2];
				}
			});
			for(int i = 1; i <= N; i++) {
				
				if(aState[i] != 0 && ((time - aStart[aState[i]]) == aList[i])) {
					pq.add(aState[i]);
//					System.out.println(aState[i]);
					aStart[aState[i]] = 0;
					aState[i] = 0;
				}
				if(!aQ.isEmpty() && aState[i] == 0) {
					aState[i] = aQ.poll();
					tUse[aState[i]] = i;
					aStart[aState[i]] = time;
					
				}
			}
			while(!pq.isEmpty()) bQ.add(pq.poll());
			for(int i = 1; i <= M; i++) {
				if(bState[i] != 0 && ((time - bStart[bState[i]]) == bList[i])) {
					bStart[bState[i]] = 0;
					bState[i] = 0;
					cnt++;
//					System.out.println(cnt);
//					System.out.printf("time : %d, bStart[%d] = %d, bList[%d] = %d\n", time, i, bStart[i], i, bList[i]);
				}
				if(!bQ.isEmpty() && bState[i] == 0) {
					bState[i] = bQ.poll();
					if(tUse[bState[i]] == A && i == B) result += bState[i];
					bStart[bState[i]] = time;
//					System.out.printf("%dt _ 정비 || [1] %d , [2] %d\n", time, bState[1], bState[2]);
				}
			}
			time++;
		}
//			System.out.println(t + " " + result);
			sb.append("#").append(t).append(" ").append(result == 0 ? -1 : result).append("\n");
		}
		System.out.println(sb);
	}
}
