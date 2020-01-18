import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2606_바이러스 { // 바이러스
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comNum = sc.nextInt();
		int pairNum = sc.nextInt();
		int checkCom = 1;
		
		LinkedList<Integer>[] com = new LinkedList[comNum + 1];
		
		for(int i = 0; i < com.length; i++) {
			com[i] = new LinkedList<>();
		}
		int a, b;
		for(int i = 0; i < pairNum; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			com[a].add(b);
			com[b].add(a);
		}
		
		int cnt = 0;
		boolean[] visited = new boolean[com.length];
		Queue<Integer> q = new LinkedList<>();
		q.offer(checkCom);
		visited[checkCom] = true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			
			int temp;
			Iterator<Integer> iterator = com[idx].iterator();
			while(iterator.hasNext()) {
				temp = iterator.next();
				if(!visited[temp]) {
					q.offer(temp);
					visited[temp] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
