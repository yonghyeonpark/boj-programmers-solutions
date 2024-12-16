import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int result = 0;
        int start = 0;
        int length = doc.length();
        for (int i = 0; i < length; i++) {
            String compare = doc.substring(start, i + 1);
            if (!compare.contains(word)) continue;
            result++;
            start = i + 1;
        }
        System.out.println(result);
    }
}