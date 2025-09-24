class Solution {
    
    private int[] dh = {0, 0, 1, -1};
    private int[] dw = {1, -1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            if (nh < 0 || nh >= board.length || nw < 0 || nw >= board[0].length) continue;
            if (board[nh][nw].equals(color)) answer++;
        }
        
        return answer;
    }
}