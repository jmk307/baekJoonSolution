import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] king, stone;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String kingCurrent = st.nextToken();
        king = new int[] {(int) kingCurrent.charAt(0) - 'A', Integer.parseInt(String.valueOf(kingCurrent.charAt(1)))};

        String stoneCurrent = st.nextToken();
        stone = new int[] {(int) stoneCurrent.charAt(0) - 'A', Integer.parseInt(String.valueOf(stoneCurrent.charAt(1)))};

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int[] now = play(br.readLine());

            int nextKingX = king[0] + now[0];
            int nextKingY = king[1] + now[1];

            int nextStoneX = stone[0] + now[0];
            int nextStoneY = stone[1] + now[1];

            if (nextKingX >= 0 && nextKingX <= 7 && nextKingY > 0 && nextKingY < 9) {
                if (nextKingX == stone[0] && nextKingY == stone[1]) {
                    if (nextStoneX >= 0 && nextStoneX <= 7 && nextStoneY > 0 && nextStoneY < 9) {
                        king = new int[] {nextKingX, nextKingY};
                        stone = new int[] {nextStoneX, nextStoneY};
                    }
                } else {
                    king = new int[] {nextKingX, nextKingY};
                }
            }

            /*if (nextKingX >= 0 && nextKingX <= 7 && nextKingY > 0 && nextKingY < 9) {
                if (nextKingX == stone[0] && nextKingY == stone[1]
                        && nextStoneX >= 0 && nextStoneX <= 7 && nextStoneY > 0 && nextStoneY < 9) {
                    king = new int[] {nextKingX, nextKingY};
                    stone = new int[] {nextStoneX, nextStoneY};
                } else if (nextKingX != stone[0] && nextKingY != stone[1]) {
                    king = new int[] {nextKingX, nextKingY};
                }
            }*/
        }

        char kingResult = (char) ((king[0] + 17)  + '0');
        System.out.println(String.valueOf(kingResult) + String.valueOf(king[1]));

        char StoneResult = (char) ((stone[0] + 17)  + '0');
        System.out.println(String.valueOf(StoneResult) + String.valueOf(stone[1]));
    }

    static int[] play(String c) {
        switch (c) {
            case "R":
                return new int[] {1, 0};
            case "L":
                return new int[] {-1, 0};
            case "B":
                return new int[]{0, -1};
            case "T":
                return new int[] {0, 1};
            case "RT":
                return new int[] {1, 1};
            case "LT":
                return new int[] {-1, 1};
            case "RB":
                return new int[] {1, -1};
            case "LB":
                return new int[] {-1, -1};
            default:
                return new int[] {0, 0};
        }
    }
}