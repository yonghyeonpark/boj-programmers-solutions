import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, kor, eng, math));
        }

        students.sort((a, b) -> {
            if (a.kor == b.kor) {
                if (a.eng == b.eng) {
                    if (a.math == b.math) {
                        return a.name.compareTo(b.name);
                    }
                    return Integer.compare(b.math, a.math);
                }
                return Integer.compare(a.eng, b.eng);
            }
            return Integer.compare(b.kor, a.kor);
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(students.get(i).name).append("\n");
        }
        System.out.println(result);
    }

    private static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
}