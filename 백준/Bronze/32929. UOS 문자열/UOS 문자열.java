import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int x;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[] visited;
    static Map<String, Boolean> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        x = Integer.parseInt(br.readLine());

        String[] a = new String[4];
        a[1] = "U";
        a[2] = "O";
        a[0] = "S";

        System.out.println(a[x % 3]);
    }
}