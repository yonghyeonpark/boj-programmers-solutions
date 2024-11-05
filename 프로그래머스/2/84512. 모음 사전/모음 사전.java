import java.util.*;

class Solution {
    
    private String[] vowel = {"A", "E", "I", "O", "U"};
    private List<String> words = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return words.indexOf(word);
    }
    
    private void dfs(String s) {
        words.add(s);
        if (s.length() == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(s + vowel[i]);
        }
    }
}