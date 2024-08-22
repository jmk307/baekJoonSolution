import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((m1, m2) -> {
            if (m1.abs.equals(m2.abs)) {
                return Math.toIntExact(m1.origin - m2.origin);
            } else {
                return Math.toIntExact(m1.abs - m2.abs);
            }
        });

        for (int i = 0; i < N; i++) {
            Long x = Long.parseLong(br.readLine());

            if (x != 0L) {
                pq.add(new Node(Math.abs(x), x));
            } else {
                if (pq.peek() == null) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().origin);
                }
            }
        }
    }
}

class Node {
    Long abs;

    Long origin;

    public Node(Long abs, Long origin) {
        this.abs = abs;
        this.origin = origin;
    }
}