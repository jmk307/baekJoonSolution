import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int count = Integer.parseInt(br.readLine());
        int[] seq = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < count; i++) {
            if (map.containsKey(seq[i])) {
                int result = map.get(seq[i]) + 1;
                map.put(seq[i], result);
            } else {
                map.put(seq[i], 1);
            }
        }

        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty() && (map.get(seq[stack.peek()]) < map.get(seq[i]))) {
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(seq[i]).append(' ');
        }
        System.out.println(sb);
    }
}