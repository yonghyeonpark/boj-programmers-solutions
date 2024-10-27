class Solution {
    
    private boolean[] v;
    private int length;
    private int answer;
    
    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        v = new boolean[length];
        answer = Integer.MIN_VALUE;
        
        backTracking(0, k, dungeons);
        
        return answer;
    }
    
    private void backTracking(int count, int k, int[][] dungeons) {
        for (int i = 0; i < length; i++) {
            int[] dungeon = dungeons[i];
            if (v[i] == true || dungeon[0] > k) continue;
            v[i] = true;
            backTracking(count + 1, k - dungeon[1], dungeons);
            v[i] = false;
        }
        answer = Math.max(answer, count);
    }
}