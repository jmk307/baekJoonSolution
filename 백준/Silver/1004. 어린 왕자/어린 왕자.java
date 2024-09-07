import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, startX, startY, endX, endY, n, cx, cy, r;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            
            n = Integer.parseInt(br.readLine());
            int sum = 0;
            
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                
                int count = 0;
                if ((startX - cx) * (startX - cx) + (startY - cy) * (startY - cy) < r * r) {
                    count++;
                }
                
                if ((endX - cx) * (endX - cx) + (endY - cy) * (endY - cy) < r * r) {
                    count++;
                }
                
                if (count == 1) {
                    sum++;
                }
            }
            
            System.out.println(sum);
        }
    }
}