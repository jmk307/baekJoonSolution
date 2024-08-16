import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();

        String a = input.replace("dz=", "0");
        String b = a.replace("c=", "0");
        String c = b.replace("d-", "0");
        String d = c.replace("lj", "0");
        String e = d.replace("nj", "0");
        String f = e.replace("c-", "0");
        String g = f.replace("s=", "0");
        String h = g.replace("z=", "0");

        System.out.println(h.length());
    }
}