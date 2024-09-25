import java.util.*;
import java.io.*;

public class Main {
    static int N, L, Q;
    static double[] length;
    static double screenLength;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        length = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            length[i] = Double.parseDouble(br.readLine());
        }
        
        screenLength = Double.parseDouble(br.readLine());
        
        double[] sum = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + length[i];
        }
        
        Q = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int idx = Integer.parseInt(br.readLine());
            
            double target = sum[idx - 1] + length[idx] / 2.0 - screenLength / 2.0;
            
            double leftLimit = 0.0;
            double rightLimit = sum[N] - screenLength;
            
            double result = Math.max(leftLimit, Math.min(target, rightLimit));
            
            sb.append(String.format("%.2f\n", Math.floor(result * 100) / 100.0));
        }
        
        System.out.print(sb);
    }
}