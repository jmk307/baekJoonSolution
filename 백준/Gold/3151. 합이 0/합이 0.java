import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static List<Long> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long now = Long.parseLong(st.nextToken());
            list.add(now);
        }
        Collections.sort(list);
        
        long count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int start = j + 1;
                long target = -(list.get(i) + list.get(j));

                int upperBound = upperBound(list, start, target);
                int lowerBound = lowerBound(list, start, target);

                count += (upperBound - lowerBound);
            }
        }

        System.out.println(count);
    }

    public static int upperBound(List<Long> list, int s, long target) {
        int start = s - 1;
        int end = N;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (!(list.get(mid) > target)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public static int lowerBound(List<Long> list, int s, long target) {
        int start = s - 1;
        int end = N;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (!(list.get(mid) >= target)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }
}