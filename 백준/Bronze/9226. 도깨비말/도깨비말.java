import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input;
		while ((input = br.readLine()) != null) {
		    if (input.equals("#")) {
		        break;
		    }
		    
		    String[] arrays = input.split("");
		    Queue<String> que = new LinkedList<>();
		    for (String i : arrays) {
		        que.add(i);
		    }
		    
		    for (String i : arrays) {
		        if (que.peek().equals("a") 
		            || que.peek().equals("e") 
		            || que.peek().equals("i") 
		            || que.peek().equals("o") 
		            || que.peek().equals("u")) {
		                break;
		            }
		        
		        que.add(que.poll());
		    }
		    
		    String result = "";
		    for (String i : que) {
		        result += i;
		    }
		    
		    System.out.println(result + "ay");
		}
	}
}
