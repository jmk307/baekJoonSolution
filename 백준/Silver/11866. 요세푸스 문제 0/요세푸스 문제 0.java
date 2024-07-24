import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Integer> list = new ArrayList<>();
    static int N, K;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            que.add(i);
        }

        while (!que.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                que.add(que.poll());
            }
            list.add(que.poll());
        }
        
        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i)).append(">");
            } else {
                sb.append(list.get(i)).append(", ");
            }
        }
        System.out.println(sb);
    }
}