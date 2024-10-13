import java.util.*;

class Solution {
    
    private List<Set<Integer>> networks = new ArrayList<>();
    private boolean[] v;
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            networks.add(new HashSet<>());
        }
        
        for (int i = 0; i < n; i++) {
            int[] computer = computers[i];
            for (int j = 1; j < n; j++) {
                if (computer[j] == 1) {
                    networks.get(i).add(j);
                    networks.get(j).add(i);
                }
            }
        }
        
        v = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        v[num] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            Set<Integer> network = networks.get(cur);
            for (int c : network) {
                if (v[c]) continue;
                q.offer(c);
                v[c] = true;
            }
        }
    }
}