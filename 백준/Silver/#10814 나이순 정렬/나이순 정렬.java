import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<User> users = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            users.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        users.sort(Comparator.comparingInt(u -> u.age));

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.println(sb);
    }

    private static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
