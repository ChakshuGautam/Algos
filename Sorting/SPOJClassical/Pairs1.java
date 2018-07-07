package Algos.Sorting.SPOJClassical;

import Algos.FasterReader;

import java.io.*;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Same as Hacking the random number generator but the inputs are on different line and same line in questions so that
// might be a problem. Had to change to make a generic input.

/**
 * Created by chaks on 7/7/18.
 */
public class Pairs1 {

    private static FasterReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FasterReader();
        out = new PrintWriter(System.out, true);
        solution(in, out);
    }

    private static void solution(FasterReader in, PrintWriter out) throws IOException {
        int M = in.nextInt();
        int N = in.nextInt();

        Map<Integer, Integer> dataMap = new HashMap<>();

        int i =0;
        int counter = 0;
        while(i<M) {
            int key = in.nextInt();
            dataMap.put(key, 0);
            if(dataMap.containsKey(key - N)) counter++;
            if(dataMap.containsKey(key + N)) counter++;
            i++;
        }
        out.println(counter);
    }
}
