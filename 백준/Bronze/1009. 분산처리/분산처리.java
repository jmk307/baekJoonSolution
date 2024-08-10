import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, a, b;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int data = 1;
            for (int j = 0; j < b; j++) {
                data *= a;
                data %= 10;
            }
            if (data == 0)
                data = 10;
            list.add(data);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}