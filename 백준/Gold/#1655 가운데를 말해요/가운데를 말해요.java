import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (min.size() == max.size()) {
                min.offer(num);
            } else {
                max.offer(num);
            }
            if (!max.isEmpty() && min.peek() > max.peek()) {
                max.offer(min.poll());
                min.offer(max.poll());
            }
            
            result.append(min.peek()).append("\n");
        }
        System.out.println(result);
    }
}