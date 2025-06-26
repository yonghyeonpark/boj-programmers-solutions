import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static List<Member> members = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members.add(new Member(age, name));
        }

        Comparator<Member> c = Comparator.comparing(Member::getAge);
        members.sort(c);

        for (Member m : members) {
            System.out.println(m);
        }
    }

    private static class Member {

        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}