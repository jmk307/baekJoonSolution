import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, r, c;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        if (N == 1) {
            if (c == 0 && r == 0) {
                System.out.println(0);
            } else if (c == 1 && r == 0) {
                System.out.println(1);
            } else if (c == 0 && r == 1) {
                System.out.println(2);
            } else if (c == 1 && r == 1) {
                System.out.println(3);
            }
        } else {
            recursiveCall(size, 0, 0, 0);
        }


    }

    static void recursiveCall(int size, int startX, int startY, int startCount) {
        if (size == 2) {
            int x = c - startX;
            int y = r - startY;

            if (x == 0 && y == 0) {
                System.out.println(startCount);
            } else if (x == 1 && y == 0) {
                System.out.println(startCount + 1);
            } else if (x == 0 && y == 1) {
                System.out.println(startCount + 2);
            } else if (x == 1 && y == 1) {
                System.out.println(startCount + 3);
            }

            return;
        }

        int recursiveSize = size / 2;

        if (startX <= c && c < startX + recursiveSize && startY <= r && r < startY + recursiveSize) {
            recursiveCall(recursiveSize, startX, startY, startCount);
        }

        if (startX + recursiveSize <= c && c < startX + 2*recursiveSize && startY <= r && r < startY + recursiveSize) {
            recursiveCall(recursiveSize, startX + recursiveSize, startY, startCount + recursiveSize * recursiveSize);
        }

        if (startX <= c && c < startX + recursiveSize && startY + recursiveSize <= r && r < startY + 2*recursiveSize) {
            recursiveCall(recursiveSize, startX, startY + recursiveSize, startCount + 2 * recursiveSize * recursiveSize);
        }

        if (startX + recursiveSize <= c && c < startX + 2*recursiveSize && startY + recursiveSize <= r && r < startY + 2*recursiveSize) {
            recursiveCall(recursiveSize, startX + recursiveSize, startY + recursiveSize, startCount + 3 * recursiveSize * recursiveSize);
        }
    }
}