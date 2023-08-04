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
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Double [] targetArray = new Double[count];
        for (int i = 0; i < count; i++) {
            targetArray[i] = Double.parseDouble(st.nextToken());
        }
        
        Double maxScore = Arrays.stream(targetArray).mapToDouble(Double::doubleValue).max().getAsDouble();
        Double [] modifiedScore = Arrays.stream(targetArray).map(a -> (a / maxScore) * 100.0).toArray(Double[]::new);
        
        Double newAverage = Arrays.stream(modifiedScore).mapToDouble(i -> i).sum() / (double) count;
        System.out.println(newAverage);
        
    }

}