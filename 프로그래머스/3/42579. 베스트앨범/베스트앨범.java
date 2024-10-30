import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Map<Integer, Integer>> songs = new HashMap<>(); 
        
        int length = genres.length;
        for (int i = 0; i < length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            count.put(genre, count.getOrDefault(genre, 0) + play);
            songs.computeIfAbsent(genre, g -> new HashMap<>()).put(i, play);
        }
        
        List<String> genreList = new ArrayList<>(count.keySet());
        Collections.sort(genreList, (g1, g2) -> count.get(g2) - count.get(g1));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            Map<Integer, Integer> song = songs.get(genre);
            
            List<Integer> songList = new ArrayList<>(song.keySet());
            Collections.sort(songList, (s1, s2) -> song.get(s2) - song.get(s1));
        
            if (songList.size() == 1) {
                result.add(songList.get(0));
                continue;
            }
            
            for (int i = 0; i < 2; i++) {
                result.add(songList.get(i));
            }
        }
        
        int size = result.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}