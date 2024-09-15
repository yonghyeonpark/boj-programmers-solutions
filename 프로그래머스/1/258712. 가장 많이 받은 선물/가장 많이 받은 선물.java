import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int length = friends.length;
        int[][] state = new int[length][length];

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < length; i++) {
            index.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String giver = split[0];
            String receiver = split[1];

            state[index.get(giver)][index.get(receiver)]++;
        }

        int[] giftScore = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                giftScore[i] += state[i][j] - state[j][i];
            }
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            // 같거나 둘 다 0이면 선물 지수 비교
            // 기준인 사람이 더 많이줬으면 +1
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (state[i][j] == state[j][i] || (state[i][j] == 0 && state[j][i] == 0)) {
                    // 선물 지수 비교
                    if (giftScore[i] > giftScore[j]) {
                        result[i]++;
                    }
                    continue;
                }
                if (state[i][j] > state[j][i]) {
                    result[i]++;
                }
            }
        }

        Arrays.sort(result);
        return result[length - 1];
    }
}