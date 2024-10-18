import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;
    static long T;

    static List<Integer> list = new ArrayList<>();

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());
        
        matrix = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[N];
        int[] visitOrder = new int[N];
        int position = 0;
        
        int current = 0;
        
        while (!visited[current]) {
            visited[current] = true;
            visitOrder[position++] = current;
            current = matrix[current] - 1;
        }
        
        int cycleStart = -1;
        for (int i = 0; i < position; i++) {
            if (visitOrder[i] == current) {
                cycleStart = i;
                break;
            }
        }
        
        int cycleLength = position - cycleStart;
        
        if (T < position) {
            System.out.println(visitOrder[(int) T] + 1);
        } else {
            T = (T - cycleStart) % cycleLength + cycleStart;
            System.out.println(visitOrder[(int) T] + 1);
        }
    }
}