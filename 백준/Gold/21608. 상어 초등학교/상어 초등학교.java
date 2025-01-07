import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[][] matrix;
    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            map.put(student, list);
        }

        for (int current : map.keySet()) {
            PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> {
                if (e1.favorite == e2.favorite) {
                    if (e1.empty == e2.empty) {
                        if (e1.node[0] == e2.node[0]) {
                            return e1.node[1] - e2.node[1];
                        } else {
                            return e1.node[0] - e2.node[0];
                        }
                    } else {
                        return e2.empty - e1.empty;
                    }
                } else {
                    return e2.favorite - e1.favorite;
                }
            });

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (matrix[i][j] == 0) {
                        int fCount = 0;
                        int eCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x >= 1 && y >= 1 && x <= N && y <= N) {
                                if (map.get(current).contains(matrix[x][y])) {
                                    fCount++;
                                } else if (matrix[x][y] == 0) {
                                    eCount++;
                                }
                            }
                        }

                        pq.add(new Node(new int[] {i, j}, fCount, eCount));
                    }
                }
            }

            int[] result = pq.poll().node;

            matrix[result[0]][result[1]] = current;
        }

        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int fCount = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 1 && y >= 1 && x <= N && y <= N) {
                        if (map.get(matrix[i][j]).contains(matrix[x][y])) {
                            fCount++;
                        }
                    }
                }

                if (fCount == 1) {
                    sum += 1;
                } else if (fCount == 2) {
                    sum += 10;
                } else if (fCount == 3) {
                    sum += 100;
                } else if (fCount == 4) {
                    sum += 1000;
                }
            }
        }

        System.out.println(sum);
    }
}

class Node {
    int[] node;

    int favorite;

    int empty;

    public Node(int[] node, int favorite, int empty) {
        this.node = node;
        this.favorite = favorite;
        this.empty = empty;
    }
}