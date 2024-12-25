import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int L, R, C;
    static int[] start, end;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static int[][][] matrix;
    static boolean[][][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("0 0 0")) {
                break;
            }

            st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            matrix = new int[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] arrays = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        if (arrays[k].equals("S")) {
                            start = new int[] {i, j, k};
                        } else if (arrays[k].equals("E")) {
                            matrix[i][j][k] = 2;
                            end = new int[] {i, j, k};
                        } else if (arrays[k].equals(".")) {
                            matrix[i][j][k] = 0;
                        } else if (arrays[k].equals("#")) {
                            matrix[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }

            answer = -1;
            BFS(new Node(start, 0));

            if (answer != -1) {
                sb.append("Escaped in " + answer + " minute(s).").append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }
        }

        System.out.println(sb);
    }

    static void BFS(Node v) {
        visited[v.node[0]][v.node[1]][v.node[2]] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (Arrays.equals(now.node, end)) {
                answer = now.count;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int z = now.node[0] + dz[i];
                int x = now.node[1] + dx[i];
                int y = now.node[2] + dy[i];

                if (z >= 0 && x >= 0 && y >= 0 && z < L && x < R && y < C) {
                    if (!visited[z][x][y] && matrix[z][x][y] != 1) {
                        visited[z][x][y] = true;
                        que.add(new Node(new int[] {z, x, y}, now.count + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int[] node;

    int count;

    public Node(int[] node, int count) {
        this.node = node;
        this.count = count;
    }
}