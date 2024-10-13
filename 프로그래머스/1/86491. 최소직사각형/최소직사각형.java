class Solution {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            max = Math.max(max, Math.max(size[1], size[0]));
        }
        
        int min = 0;
        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            
            if (w >= h) {
                min = Math.max(min, h);
                continue;
            }
            min = Math.max(min, w);
        }
        return max * min;
    }
}