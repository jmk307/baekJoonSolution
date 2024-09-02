import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    static int count = 0;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < N; k++) {
            String input = br.readLine();
            
            String[] arrays = input.split("");
            
            String output = "";
            for (int i = 0; i < arrays.length; i++) {
                if (i == 0) {
                    output += arrays[i];
                } else if (!arrays[i].equals(arrays[i-1])) {
                    output += arrays[i];
                }
            }
            
            String[] outputs = output.split("");
            
            boolean isSame = false;
            for (int i = 0; i < outputs.length; i++) {
                for (int j = i + 1; j < outputs.length; j++) {
                    if (outputs[i].equals(outputs[j])) {
                        isSame = true;
                        break;
                    }
                }
            }
            
            if (!isSame) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}