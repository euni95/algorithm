import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		int[] test = {0, 1, 2, 3, 4, 5};
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for(int i = 0; i < 6; i++) pq.add(test[i]);
		Iterator<Integer> it = pq.iterator();
		while(!pq.isEmpty()) System.out.println(pq.poll());
	}

}
