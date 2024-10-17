import java.util.*;

class Solution {
    
    private int h, w;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private boolean[][] v;
    
    public int solution(int[][] maps) {
        h = maps.length;
        w = maps[0].length;
        v = new boolean[h][w];
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, 1));
        v[0][0] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int moving = cur.moving;
            
            if (x == h - 1  && y == w - 1) return moving;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (v[nx][ny] || maps[nx][ny] == 0) continue;
                q.offer(new State(nx, ny, moving + 1));
                v[nx][ny] = true;
            }
        }
        return -1;
    }
    
    private class State {
        int x;
        int y;
        int moving;
        
        public State(int x, int y, int moving) {
            this.x = x;
            this.y = y;
            this.moving = moving;
        }
    }
}