import java.util.*;

class Solution {
    
    private List<List<Integer>> graph = new ArrayList<>();
    private List<Integer> distance = new ArrayList<>();
    private boolean[] v;
    private int[] result;
    private int max = Integer.MIN_VALUE;
    
    public int solution(int n, int[][] edges) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        v = new boolean[n + 1];
        result = new int[n + 1];
        
        bfs();
        
        int answer = 0;
        for (int num : result) {
            if (num == max) answer++;
        }
        return answer;
    }
    
    private void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(1, 0));
        v[1] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            int num = cur.num;
            int count = cur.count;
            
            max = Math.max(max, count);
            result[num] = count;
            
            List<Integer> r = graph.get(num);
            int size = r.size();
            for (int i = 0; i < size; i++) {
                int next = r.get(i);
                if (v[next]) continue;
                v[next] = true;
                q.offer(new State(next, count + 1));
            }
        }
    }
    
    private class State {
        int num;
        int count;
        
        public State (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}