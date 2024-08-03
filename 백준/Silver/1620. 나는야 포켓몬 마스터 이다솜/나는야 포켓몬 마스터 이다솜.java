import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> pokemons;

    static int N, M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pokemons = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            pokemons.put(String.valueOf(i), pokemon);
            pokemons.put(pokemon, String.valueOf(i));

        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            sb.append(pokemons.get(input)).append("\n");
        }

        System.out.println(sb);
    }
}