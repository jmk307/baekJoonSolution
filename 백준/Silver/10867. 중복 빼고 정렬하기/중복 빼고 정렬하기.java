import java.util.*;
        import java.io.*;
        import java.lang.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int prev = -1;
        for (int i : list) {
            if (i != prev) {
                sb.append(i).append(" ");
            }

            prev = i;
        }

        System.out.println(sb);
    }
}