import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               
        while (true) {
            String x = br.readLine();
            if (x.equals("0")) break;
            
            boolean isFelindrom = true;
            for (int i = 0; i < x.length() / 2; i++) {
                if (x.charAt(i) != x.charAt(x.length() - 1 - i)) {
                    isFelindrom = false;
                }
            }
            if (isFelindrom == false) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
        
    }

}