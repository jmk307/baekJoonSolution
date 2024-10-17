import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int t, n, k, a, b, m, u, v;

    static int[] parent;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int x = 1; x <= t; x++) {
            sb.append("Scenario ").append(x).append(":").append("\n");
            n = Integer.parseInt(br.readLine());

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st =  new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                if (find(u) != find(v)) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}