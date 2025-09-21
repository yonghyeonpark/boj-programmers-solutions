class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] v = video_len.split(":");
        int v_m = Integer.parseInt(v[0]);
        int v_s = Integer.parseInt(v[1]);
        int v_time = (v_m * 60) + v_s;
        
        String[] p = pos.split(":");
        int p_m = Integer.parseInt(p[0]);
        int p_s = Integer.parseInt(p[1]);
        int p_time = (p_m * 60) + p_s;
        
        String[] os = op_start.split(":");
        int os_m = Integer.parseInt(os[0]);
        int os_s = Integer.parseInt(os[1]);
        int os_time = (os_m * 60) + os_s;
        
        String[] oe = op_end.split(":");
        int oe_m = Integer.parseInt(oe[0]);
        int oe_s = Integer.parseInt(oe[1]);
        int oe_time = (oe_m * 60) + oe_s;
        
        for (String command : commands) {
            if (p_time >= os_time && p_time <= oe_time) {
                p_time = oe_time;
            }
            if (command.equals("prev")) {
                p_time -= 10;
                if (p_time < 0) {
                    p_time = 0;
                }
            }
            if (command.equals("next")) {
                p_time += 10;
                if (p_time > v_time) {
                    p_time = v_time;
                }
            }
        }
        if (p_time >= os_time && p_time <= oe_time) {
            p_time = oe_time;
        }
        
        int m = p_time / 60;
        int s = p_time % 60;
        
        String result_m = String.valueOf(m);
        String result_s = String.valueOf(s);
        if (m / 10 == 0) {
            result_m = "0" + m;
        }
        if (s / 10 == 0) {
            result_s = "0" + s;
        }
        return result_m + ":" + result_s;
    }
}