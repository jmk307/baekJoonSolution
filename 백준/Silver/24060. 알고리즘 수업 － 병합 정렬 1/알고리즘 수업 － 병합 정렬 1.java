import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;
    static int answer = 0;
    static int count = 0;
    
    static int[] matrix, tmp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        matrix = new int[N];
        tmp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(matrix, 0, matrix.length - 1);
        
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    
    static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }
    
    static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 1;
        
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t] = A[i];
                count++;
                if (count == K) {
                    answer = tmp[t];
                }
                
                t++;
                i++;
            } else {
                tmp[t] = A[j];
                count++;
                if (count == K) {
                    answer = tmp[t];
                }
                
                t++;
                j++;
            }
        }
        
        while (i <= q) {
            tmp[t] = A[i];
            count++;
            if (count == K) {
                answer = tmp[t];
            }
            
            t++;
            i++;
        }
        
        while (j <= r) {
            tmp[t] = A[j];
            count++;
            if (count == K) {
                answer = tmp[t];
            }
            
            t++;
            j++;
        }
        
        i = p;
        t = 1;
        
        while (i <= r) {
            A[i] = tmp[t];
            
            i++;
            t++;
        }
    }
}