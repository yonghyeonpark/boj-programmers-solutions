import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();
        List<String> suffixes = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            suffixes.add(s.substring(i, length));
        }

        suffixes.sort(Comparator.naturalOrder());
        int size = suffixes.size();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(suffixes.get(i)).append("\n");
        }
        System.out.println(result);
    }
}