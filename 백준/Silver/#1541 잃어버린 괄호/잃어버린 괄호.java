import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] subtractionParts = br.readLine().split("-");
        List<Integer> additionResults = new ArrayList<>();
        for (String subtractionPart : subtractionParts) {
            int sum = 0;
            for (String additionPart : subtractionPart.split("\\+")) {
                sum += Integer.parseInt(additionPart);
            }
            additionResults.add(sum);
        }

        int result = additionResults.get(0);
        for (int i = 1; i < additionResults.size(); i++) {
            result -= additionResults.get(i);
        }

        System.out.println(result);
    }
}