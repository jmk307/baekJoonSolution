import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] P;
    static int[][] A, B;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        
        if (input.contains("D2") || input.contains("d2")) {
            System.out.println("D2");
        } else {
            System.out.println("unrated");
        }
    }
}