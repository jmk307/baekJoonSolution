import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new HashMap<>();
        map.put("Algorithm", "204");
        map.put("DataAnalysis", "207");
        map.put("ArtificialIntelligence", "302");
        map.put("CyberSecurity", "B101");
        map.put("Network", "303");
        map.put("Startup", "501");
        map.put("TestStrategy", "105");

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}