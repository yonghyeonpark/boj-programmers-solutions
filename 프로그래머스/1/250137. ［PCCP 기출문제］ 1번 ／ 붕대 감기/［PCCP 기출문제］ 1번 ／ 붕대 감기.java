import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int recover = bandage[1];
        int plus = bandage[2];
        int max = health;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] attack : attacks) {
            map.put(attack[0], attack[1]);
        }
        
        int total = 0;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {         
            int damage = map.getOrDefault(i, -1);
            if (damage == -1) {
                total++;
                if (total == time) {
                    health = Math.min(max, health + recover + plus);
                    total = 0;
                    continue;
                }
                health = Math.min(max, health + recover);
            }
            if (damage != -1) {
                health -= damage;
                if (health <= 0) {
                    return -1;
                }
                total = 0;
            }
        }
        
        return health;
    }
}