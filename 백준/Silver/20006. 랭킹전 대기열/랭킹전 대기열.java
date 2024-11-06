import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int p, m, l;
    static String n;

    static LinkedHashMap<Player, List<Player>> map = new LinkedHashMap<>();

    static int[][] matrix, dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();

            if (map.isEmpty()) {
                List<Player> list = new ArrayList<>();
                Player p = new Player(l, n);
                list.add(p);

                map.put(p, list);
            } else {
                boolean isInput = false;
                for (Player p : map.keySet()) {
                    if (l >= p.level - 10 && l <= p.level + 10 && map.get(p).size() < m) {
                        map.get(p).add(new Player(l, n));
                        isInput = true;
                        break;
                    }
                }

                if (!isInput) {
                    List<Player> list = new ArrayList<>();
                    Player p = new Player(l, n);
                    list.add(p);

                    map.put(p, list);
                }
            }
        }

        for (Player p : map.keySet()) {
            if (map.get(p).size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            List<Player> now = map.get(p);
            Collections.sort(now, (e1, e2) -> {
                return e1.nickname.compareTo(e2.nickname);
            });

            for (Player p1 : now) {
                sb.append(p1.level).append(" ").append(p1.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }
}

class Player {
    int level;

    String nickname;

    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}