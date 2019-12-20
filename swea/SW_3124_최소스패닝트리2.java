import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class SW_3124_최소스패닝트리2 { // Prim's algorithm
    static ArrayList<Node>[] vertexList;
    static long result;
    static int cnt;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            result = 0;
            cnt = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            vertexList = new ArrayList[V + 1];
            for(int i = 0; i < V + 1; i++) {
                vertexList[i] = new ArrayList<>();
            }
             
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                 
                Node v1 = new Node(start, weight);
                Node v2 = new Node(end, weight);
                vertexList[start].add(v2);
                vertexList[end].add(v1);
            }
             
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[V + 1];
            int begin = 1;
            visited[begin] = true;
            Iterator<Node> it = vertexList[begin].iterator();
             
            while(it.hasNext()) {
                pq.offer(it.next());
            }
             
            Node temp;
            while(!pq.isEmpty()) {
                temp = pq.poll();
                int idx = temp.vertex;
                if(visited[idx]) continue;
                 
                result += temp.weight;
                visited[idx] = true;
                 
                if(cnt == V - 1) break;
                it = vertexList[idx].iterator();
                while(it.hasNext()) {
                    pq.offer(it.next());
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
 
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;
 
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node o) {
            return this.weight > o.weight ? 1 : -1;
        }
 
    }
 
}