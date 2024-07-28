import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;

    static List<Integer> list = new ArrayList<>();
    static List<Integer> matrix = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        System.out.println(average());
        System.out.println(mid());
        System.out.println(most());
        System.out.println(MaxMinusMin());
    }

    static int average() {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        double average = (double) sum / (double) list.size();
        return (int) Math.round(average);
    }

    static int mid() {
        int start = 0;
        int end = list.size();

        return list.get((start + end) / 2);
    }

    static void binarySearch() {
        int startIndex;
        int lastIndex;
        for (int i = 0; i < N; i++) {
            int target = list.get(i);
            int start = 0;
            int end = list.size() - 1;
            while (start <= end) {
                int midi = (start + end) / 2;
                int midv = list.get(midi);

                if (midv < target) {
                    start = midi + 1;
                } else {
                    end = midi - 1;
                }
            }

            startIndex = start;

            start = 0;
            end = list.size() - 1;
            while (start <= end) {
                int midi = (start + end) / 2;
                int midv = list.get(midi);

                if (midv <= target) {
                    start = midi + 1;
                } else {
                    end = midi - 1;
                }
            }

            lastIndex = end;

            matrix.add(lastIndex - startIndex + 1);
        }
    }

    static int most() {
        binarySearch();

        int max = Collections.max(matrix);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            int count = matrix.get(i);
            int current = list.get(i);

            if (count == max) {
                if (result.isEmpty()) {
                    result.add(current);
                } else if (result.get(0) != current) {
                    result.add(current);
                }
            }
        }

        if (result.size() == 1) {
            return result.get(0);
        } else {
            return result.get(1);
        }
    }

    static int MaxMinusMin() {
        int max = Collections.max(list);
        int min = Collections.min(list);

        return max - min;
    }
}