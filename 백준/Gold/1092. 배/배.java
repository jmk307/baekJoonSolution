import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> crane = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        boolean isAnswer = true;
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));

            if (list.get(i) > crane.get(0)) {
                isAnswer = false;
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        if (isAnswer) {
            int count = 0;

            while (!list.isEmpty()) {
                int listIndex = 0;
                int craneIndex = 0;

                while (craneIndex < N) {
                    if (listIndex == list.size()) {
                        break;
                    } else if (crane.get(craneIndex) >= list.get(listIndex)) {
                        list.remove(listIndex);
                        craneIndex++;
                    } else {
                        listIndex++;
                    }
                }

                count++;
            }

            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }
}