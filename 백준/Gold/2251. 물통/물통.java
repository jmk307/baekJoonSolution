import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B, C;

    static boolean[][][] visited;

    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];

        BFS(new Node(0, 0, C));

        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void BFS(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, node.c));

        visited[0][0][node.c] = true;

        while (!que.isEmpty()) {
            Node now = que.poll();

            int nowA = now.a;
            int nowB = now.b;
            int nowC = now.c;

            if (nowA == 0) {
                list.add(nowC);
            }

            if (nowA != 0) {
                if (nowA + nowB >= B) {
                    int nextA = nowA + nowB - B;
                    int nextB = B;
                    int nextC = nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = 0;
                    int nextB = nowA + nowB;
                    int nextC = nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }

                if (nowA + nowC >= C) {
                    int nextA = nowA + nowC - C;
                    int nextB = nowB;
                    int nextC = C;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = 0;
                    int nextB = nowB;
                    int nextC = nowA + nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }
            }

            if (nowB != 0) {
                if (nowB + nowA >= A) {
                    int nextA = A;
                    int nextB = nowB + nowA - A;
                    int nextC = nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = nowB + nowA;
                    int nextB = 0;
                    int nextC = nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }

                if (nowB + nowC >= C) {
                    int nextA = nowA;
                    int nextB = nowB + nowC - C;
                    int nextC = C;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = nowA;
                    int nextB = 0;
                    int nextC = nowB + nowC;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }
            }

            if (nowC != 0) {
                if (nowB + nowC >= B) {
                    int nextA = nowA;
                    int nextB = B;
                    int nextC = nowB + nowC - B;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = nowA;
                    int nextB = nowB + nowC;
                    int nextC = 0;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }

                if (nowA + nowC >= A) {
                    int nextA = A;
                    int nextB = nowB;
                    int nextC = nowA + nowC - A;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                } else {
                    int nextA = nowA + nowC;
                    int nextB = nowB;
                    int nextC = 0;

                    if (!visited[nextA][nextB][nextC]) {
                        visited[nextA][nextB][nextC] = true;
                        que.add(new Node(nextA, nextB, nextC));
                    }
                }
            }
        }
    }
}

class Node {
    int a;

    int b;

    int c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}