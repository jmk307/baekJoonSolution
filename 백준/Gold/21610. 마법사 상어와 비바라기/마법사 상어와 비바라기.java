import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, d, s;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};*/

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] dx2 = {-1, -1, 1, 1};
    static int[] dy2 = {-1, 1, -1, 1};

    static int[][] matrix;
    static boolean[][] visited;
    static List<int[]> clowns = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        clowns.add(new int[] {N-2, 0});
        clowns.add(new int[] {N-2, 1});
        clowns.add(new int[] {N-1, 0});
        clowns.add(new int[] {N-1, 1});

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            int x = dx[d-1] * s;
            int y = dy[d-1] * s;

            for (int j = 0; j < clowns.size(); j++) {
                int[] now = clowns.get(j);

                int a = (now[0] + x % N + N) % N;
                int b = (now[1] + y % N + N) % N;

                clowns.set(j, new int[] {a, b});
                matrix[a][b]++;
            }

            visited = new boolean[N][N];
            for (int[] j : clowns) {
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int p = j[0] + dx2[k];
                    int q = j[1] + dy2[k];

                    if (p >= 0 && p < N && q >= 0 && q < N) {
                        if (matrix[p][q] > 0) {
                            count++;
                        }
                    }
                }

                visited[j[0]][j[1]] = true;
                matrix[j[0]][j[1]] += count;
            }

            clowns = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && matrix[j][k] >= 2) {
                        matrix[j][k] -= 2;
                        clowns.add(new int[] {j, k});
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(sum);
    }
}