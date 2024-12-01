import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static List<Integer> plus, minus;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        plus = new ArrayList<>();
        minus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now > 0) {
                plus.add(now);
            } else {
                minus.add(now);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int sum = 0;
        if (minus.size() % 2 == 0) {
            for (int i = 0; i < minus.size(); i+=2) {
                sum += minus.get(i) * minus.get(i+1);
            }

            if (plus.size() % 2 == 0) {
                for (int i = 0; i < plus.size(); i+=2) {
                    if (plus.get(i) * plus.get(i+1) > plus.get(i) + plus.get(i+1)) {
                        sum += plus.get(i) * plus.get(i+1);
                    } else {
                        sum += plus.get(i) + plus.get(i+1);
                    }
                }
            } else {
                for (int i = 0; i < plus.size() - 1; i+=2) {
                    if (plus.get(i) * plus.get(i+1) > plus.get(i) + plus.get(i+1)) {
                        sum += plus.get(i) * plus.get(i+1);
                    } else {
                        sum += plus.get(i) + plus.get(i+1);
                    }
                }
                sum += plus.get(plus.size() - 1);
            }
        } else {
            if (plus.size() % 2 == 0) {
                for (int i = 0; i < plus.size(); i+=2) {
                    if (plus.get(i) * plus.get(i+1) > plus.get(i) + plus.get(i+1)) {
                        sum += plus.get(i) * plus.get(i+1);
                    } else {
                        sum += plus.get(i) + plus.get(i+1);
                    }
                }

                for (int i = 0; i < minus.size() - 1; i+=2) {
                    sum += minus.get(i) * minus.get(i+1);
                }
                sum += minus.get(minus.size() - 1);
            } else {
                for (int i = 0; i < plus.size() - 1; i+=2) {
                    if (plus.get(i) * plus.get(i+1) > plus.get(i) + plus.get(i+1)) {
                        sum += plus.get(i) * plus.get(i+1);
                    } else {
                        sum += plus.get(i) + plus.get(i+1);
                    }
                }

                for (int i = 0; i < minus.size() - 1; i+=2) {
                    sum += minus.get(i) * minus.get(i+1);
                }

                int a = plus.get(plus.size() - 1);
                int b = minus.get(minus.size() - 1);

                if (a * b >= a + b) {
                    sum += a * b;
                } else {
                    sum += a + b;
                }
            }
        }

        System.out.println(sum);
    }
}