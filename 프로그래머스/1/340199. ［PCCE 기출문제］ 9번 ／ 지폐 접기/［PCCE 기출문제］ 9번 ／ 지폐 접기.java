class Solution {
    public int solution(int[] wallet, int[] bill) {
        int wl = 0;
        int ws = 0;
        if (wallet[0] >= wallet[1]) {
            wl = wallet[0];
            ws = wallet[1];
        } else {
            wl = wallet[1];
            ws = wallet[0];
        }
        
        int bl = 0;
        int bs = 0;
        if (bill[0] >= bill[1]) {
            bl = bill[0];
            bs = bill[1];
        } else {
            bl = bill[1];
            bs = bill[0];
        }
        
        int answer = 0;
        while (true) {
            if (wl >= bl && ws >= bs) {
                break;
            }        
            bl /= 2;
            if (bl < bs) {
                int tem = bs;
                bs = bl;
                bl = tem;
            }
            answer++;
        }
        return answer;
    }
}