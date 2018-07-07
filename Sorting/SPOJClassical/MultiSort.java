package Algos.Sorting.SPOJClassical;
/**
 * Problem Statement Code: https://www.spoj.com/problems/MULSORT/
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chaks on 7/6/18.
 */
public class MultiSort {

    public static void main(String[] args) throws Exception {
//        test();
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader scan= new BufferedReader(isr);
        getArrayFromInput(scan);
    }

    private static void getArrayFromInput(BufferedReader scan) throws IOException {
        int testCasesCount = Integer.parseInt(scan.readLine());
        for (int i=0; i<testCasesCount; i++){
            int members = Integer.parseInt(scan.readLine());
            int problems = Integer.parseInt(scan.readLine());

            float[][] arrayToSort = new float[members*problems][3];

            // Creating the array to be sorted.
            for (int j=0; j<members; j++){
                String scores = scan.readLine();
                String[] scoresArray = scores.split(" ");
                float[] scoresFloatArray = new float[scoresArray.length];
                for (int k=0; k<scoresFloatArray.length; k++){
                    arrayToSort[j*problems + k][1] = Float.parseFloat(scoresArray[k]);
                    arrayToSort[j*problems + k][0] = j+1;
                    arrayToSort[j*problems + k][2] = k+1;
                }
            }

            // Sorting array
            Arrays.sort(arrayToSort, new Comparator<float[]>() {
                @Override
                public int compare(float[] o1, float[] o2) {
                    Float itemIdOne = o1[1];
                    Float itemIdTwo = o2[1];
                    return itemIdTwo.compareTo(itemIdOne);
                }
            });

            // Printing result.
            for (int j=0; j<members*problems; j++){
                System.out.print((int) arrayToSort[j][0] + "," + (int) arrayToSort[j][2] + " ");
            }
            System.out.println();
        }
    }

    public static void test() throws IOException {
        String test_string = "2\n" +
                "3\n" +
                "4\n" +
                "9.195 4.17 2.532 0.03\n" +
                "8.28 5.5 4 2.69\n" +
                "8.8320 7.9 2.18 0\n" +
                "3\n" +
                "4\n" +
                "9.195 4.17 2.532 0.03\n" +
                "8.28 5.5 4 2.69\n" +
                "8.8320 7.9 2.18 0";

        InputStream stream = new ByteArrayInputStream(test_string.getBytes(StandardCharsets.UTF_8));
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader scan = new BufferedReader(isr);
        getArrayFromInput(scan);
    }
}
