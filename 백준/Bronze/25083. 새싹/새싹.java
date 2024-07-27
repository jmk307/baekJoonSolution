import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        String s = "         ,r'\"7\n" + 	// \", \n 이 제어문자다.
                "r`-_   ,'  ,/\n" + 		// \n 이 제어문자다.
                " \\. \". L_r'\n" + 		// \\, \", \n 이 제어문자다.
                "   `~\\/\n" + 			// \\, \n 이 제어문자다.
                "      |\n" + 			// \n 이 제어문자다.
                "      |";

        System.out.print(s);
    }
}