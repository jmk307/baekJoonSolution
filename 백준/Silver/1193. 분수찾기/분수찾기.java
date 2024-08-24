import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int X;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());
        int prevCountSum = 0; // 해당 대각선 직전 대각선까지의 칸 누적합
        int crossCount = 1; // 대각선 칸 개수

        while (true) {
            if (X <= prevCountSum + crossCount) {
                if (crossCount % 2 == 1) {
                    System.out.print((crossCount - (X - prevCountSum - 1)) + "/" + (X - prevCountSum));
                    break;
                } else {
                    System.out.print((X - prevCountSum) + "/" + (crossCount - (X - prevCountSum - 1)));
                    break;
                }
            } else {
                prevCountSum += crossCount;
                crossCount++;
            }
        }
    }
}