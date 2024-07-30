import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int K, N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        long start = 1;
        long end = Collections.max(list);
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += list.get(i) / mid;
            }

            if (sum < N) {
                end = mid - 1;
            } else if (sum >= N) {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}