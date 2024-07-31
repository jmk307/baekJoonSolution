import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> nonListened = new HashSet<>();
        Set<String> nonFound = new HashSet<>();

        for (int i = 0; i < N; i++) {
            nonListened.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            nonFound.add(br.readLine());
        }

        nonListened.retainAll(nonFound);
        ArrayList<String> al = new ArrayList<>(nonListened);
        Collections.sort(al);

        sb.append(al.size()).append("\n");
        for (String name : al) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}