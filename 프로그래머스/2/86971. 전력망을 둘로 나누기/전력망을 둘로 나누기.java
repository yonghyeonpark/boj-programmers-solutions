import java.util.*;

class Solution {
    
    private List<List<Integer>> networks;
    private boolean[] v;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int length = wires.length;
        int index = 0;
        while (index < length) {
            networks = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                networks.add(new ArrayList<>());
            }
            v = new boolean[n + 1];
            
            for (int i = 0; i < length; i++) {
                if (i == index) continue;
                int[] wire = wires[i];
                int a = wire[0];
                int b = wire[1];
                
                networks.get(a).add(b);
                networks.get(b).add(a);
            }
            
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (v[i]) continue;
                result.add(bfs(i));
            }
            answer = Math.min(answer, Math.abs(result.get(0) - result.get(1)));
            index++;
        }
        return answer;
    }
    
    private int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        
        int count = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            List<Integer> network = networks.get(cur);
            int size = network.size();
            for (int i = 0; i < size; i++) {
                int num = network.get(i);
                
                if (v[num]) continue;
                q.offer(num);
                v[num] = true;
                count++;
            }
        }
        return count;
    }
}