import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int answer = 0;
        for (int i = 0; i < 5; i++) {
            answer += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        
        System.out.println(answer % 10);
    }
}