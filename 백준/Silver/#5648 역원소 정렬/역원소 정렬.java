import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s)
                    .append(" ");
        }

        st = new StringTokenizer(sb.toString());
        int n = Integer.parseInt(st.nextToken());
        long[] elements = new long[n];

        for (int i = 0; i < n; i++) {
            String element = st.nextToken();
            int startIndex = 0;
            for (int j = 0; j < element.length(); j++) {
                if (element.charAt(j) == '0') startIndex++;
                else break;
            }
            elements[i] = Long.parseLong(new StringBuilder(element.substring(startIndex)).reverse().toString());
        }
        Arrays.sort(elements);

        for (long element : elements) {
            System.out.println(element);
        }
    }
}

