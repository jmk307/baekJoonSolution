import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, m;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix, dp;
    static boolean[][] visited;
    static int[][] dist;
    static ArrayList<Integer>[] list;
    static Set<Integer>[] set;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("    8888888888  888    88888\n" +
                "   88     88   88 88   88  88\n" +
                "    8888  88  88   88  88888\n" +
                "       88 88 888888888 88   88\n" +
                "88888888  88 88     88 88    888888\n" +
                "\n" +
                "88  88  88   888    88888    888888\n" +
                "88  88  88  88 88   88  88  88\n" +
                "88 8888 88 88   88  88888    8888\n" +
                " 888  888 888888888 88  88      88\n" +
                "  88  88  88     88 88   88888888");
    }
}