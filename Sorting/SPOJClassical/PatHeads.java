package Algos.Sorting.SPOJClassical;

import Algos.FasterReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chaks on 7/7/18.
 */
public class PatHeads {

    private static FasterReader in;
    private static PrintWriter out;
    private final String className = this.getClass().getSimpleName();

    public static void main(String[] args) throws Exception {
        in = new FasterReader();
        out = new PrintWriter(System.out, true);
        solution(in, out);
    }

    private static void solution(FasterReader in, PrintWriter out) throws IOException {

        int n = in.nextInt();
        int[] cow = new int[n];
        int[] sort = new int[1000001];
        int[] pat = new int[1000001];
        int i, a, j;
        for(i = 0; i < n; i++)
        {
            a = in.nextInt();
            cow[i] = a;
            sort[a]++;
        }
        for(i = 0; i <= 1000000; i++)
            if(sort[i] > 0)
                for(j = i; j <= 1000000; j+=i)
                    pat[j] += sort[i];
        for(i = 0; i < n; i++)
            out.println(pat[cow[i]]-1);
        System.exit(0);
    }

    public void test() throws IOException {
        String test_string = "5\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4";

        in = new FasterReader(createTestFile(test_string));
        out = new PrintWriter(System.out, true);
        solution(in, out);

    }

    private String createTestFile(String test_string) throws FileNotFoundException {
        String filename = className + "-tests.txt";
        PrintWriter file = new PrintWriter(filename);
        file.println(test_string);
        file.close();
        return filename;
    }

}
