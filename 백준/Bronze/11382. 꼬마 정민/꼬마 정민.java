import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long result = 0L;
        
        for (int i = 0; i < 3; i++) {
            result += Long.parseLong(st.nextToken());
        }      
       
        System.out.println(result);
    }

}