import java.util.*;

class Solution {
    
    private boolean[] v;
    
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        for (String word : words) {
            if (word.equals(target)) count++;
        }
        if (count == 0) return 0;
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(begin, 0));
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            String now = cur.word;
            int moving = cur.moving;
            
            if (now.equals(target)) return moving;
            
            for (String next : words) {
                if (isT(now, next)) {
                    q.offer(new State(next, moving + 1));
                } 
            }
        }
        return 0;
    }
    
    private boolean isT(String a, String b) {
        int count = 0;
        int length = a.length();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count >= 2) return false;
        }
        return true;
    }
    
    private class State {
        String word;
        int moving;
        
        public State(String word, int moving) {
            this.word = word;
            this.moving = moving;
        }
    }
}