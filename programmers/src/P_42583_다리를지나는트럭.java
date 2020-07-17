import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_42583_다리를지나는트럭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bridge_length = Integer.parseInt(br.readLine());
		int weight = Integer.parseInt(br.readLine());
		int temp = Integer.parseInt(br.readLine());
		int[] truck_weights = new int[temp];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < temp; i++) truck_weights[i] = Integer.parseInt(st.nextToken());
		Solution solution = new Solution();
		System.out.println(solution.solution(bridge_length, weight, truck_weights));
	}
	
	static class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int time = 0;
	        Queue<Truck> moving = new LinkedList<>();
	        int nowWeight = 0, idx = 0, truckCnt = truck_weights.length;
	        while(idx < truckCnt || !moving.isEmpty()) {
	        	time++;
	        	if(!moving.isEmpty()) {
	        		Truck t = moving.peek();
	        		if(time == t.time) {
	        			nowWeight -= t.weight;
	        			moving.poll();
	        		}
	        	}
	        	if(idx >= truckCnt || truck_weights[idx] + nowWeight > weight) continue;
	        	Truck temp = new Truck(truck_weights[idx++]);
	        	temp.time++;
	        	nowWeight += temp.weight;
	        	temp.time = time + bridge_length;
	        	moving.add(temp);
	        }
	        return time;
	    }
	}
	
	static class Truck {
		int time, weight;
		
		public Truck(int weight) {
			this.weight = weight;
		}
	}
}
