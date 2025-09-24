import java.util.*;

class Solution {
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private boolean[][] v;
    private int[] total;
    
    public int solution(int[][] land) {
        v = new boolean[land.length][land[0].length];
        total = new int[land[0].length];
        
        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 0 || v[j][i]) continue;
                bfs(j, i, land);
            }
        }
        
        Arrays.sort(total);
        return total[total.length - 1];
    }
    
    private void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        v[x][y] = true;
        
        Set<Integer> set = new HashSet<>();
        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) continue;
                if (land[nx][ny] == 0 || v[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
                v[nx][ny] = true;
                count++;
                set.add(ny);
            }
        }
        
        set.add(y);
        for (int col : set) {
            total[col] += count;
        }
    }
}