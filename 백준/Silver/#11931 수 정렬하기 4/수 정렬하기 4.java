import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums.sort(Comparator.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(nums.get(i)).append("\n");
        }
        System.out.println(result);
    }
}