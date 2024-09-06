import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(br.readLine());
        }

        list.retainAll(S);

        System.out.println(list.size());
    }
}