import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int[] result = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) result[arr[i] - '0'] += 1;
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            result[arr[i - 1] - '0'] += 1;
        }

        System.out.println(Math.min(result[0], result[1]));
    }
}