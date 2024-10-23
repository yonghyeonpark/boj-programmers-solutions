import java.util.*;

class Solution {
    
    private int xMax, yMax;
    private int[][] map;
    private boolean[][] v;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
        
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        xMax = Integer.MIN_VALUE;
        yMax = Integer.MIN_VALUE;
        
        // x, y의 최댓값으로 map의 크기 정하기
        // 길을 제대로 찾기 위해 map의 크기를 2배로 설정
        for (int[] rectangle : rectangles) {
            xMax = Math.max(xMax, Math.max(rectangle[0], rectangle[2]));
            yMax = Math.max(yMax, Math.max(rectangle[1], rectangle[3]));
        }
        xMax = 2 * xMax;
        yMax = 2 * yMax;
        map = new int[yMax + 1][xMax + 1];
        v = new boolean[yMax + 1][xMax + 1];
        
        // 길 채우기
        for (int[] rectangle : rectangles) {
            int x1 = 2 * rectangle[0];
            int y1 = 2 * rectangle[1];
            int x2 = 2 * rectangle[2];
            int y2 = 2 * rectangle[3];
            
            for (int i = x1; i <= x2; i++) {
                map[y1][i] = 1;
                map[y2][i] = 1;
            }
            for (int i = y1; i <= y2; i++) {
                map[i][x1] = 1;
                map[i][x2] = 1;
            }
        }
        for (int[] rectangle : rectangles) {
            int x1 = 2 * rectangle[0];
            int y1 = 2 * rectangle[1];
            int x2 = 2 * rectangle[2];
            int y2 = 2 * rectangle[3];
            
            for (int j = 0; j < yMax; j++) {
                for (int k = 0; k < xMax; k++) {
                    if (map[j][k] == 1) {
                        if ((j > y1 && j < y2) && (k > x1 && k < x2)) {
                            map[j][k] = 0;
                        }
                    }
                }
            }
        }
        return bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
    }
    
    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(characterY, characterX, 0));
        v[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int moving = cur.moving;
            
            if (x == itemY && y == itemX) return moving / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx > yMax || ny > xMax) continue;
                if (map[nx][ny] == 0 || v[nx][ny]) continue;
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
        
        public State (int x, int y, int moving) {
            this.x = x;
            this.y = y;
            this.moving = moving;
        }
    }
}