import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int L;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix;
    static boolean[] visited;
    static LinkedList<Character> list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            char[] arrays = br.readLine().toCharArray();

            list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();

            for (char now : arrays) {
                switch (now) {
                    case '>':
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '<':
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        break;
                    case '-':
                        if (it.hasPrevious()) {
                            it.previous();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(now);
                }
            }

            sb = new StringBuilder();
            for (char j : list) {
                sb.append(j);
            }
            System.out.println(sb.toString());
        }
    }
}