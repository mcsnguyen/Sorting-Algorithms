import Sort.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.lang.*;

public class Driver {
    public static void main(String args[]) throws IOException {

        double start = System.nanoTime();

        int size = 50000000;
        int[] test = {1, size/4, size/2, 3*size/4, size};
        for(int j = 0; j < test.length; j++) {
            int kth = test[j];
            Integer[] a = new Integer[size];
            Integer[] temp = new Integer[a.length];
            Random gen = new Random();

            for (int i = 0; i < size; i++) {
                a[i] = gen.nextInt(size) + 1;
                //System.out.print(a[i] + "\t");
            }

            System.out.println();
            SortArray.mergeSort(a, temp, 0, temp.length - 1);
            //SortArray.quickSort(a,0,a.length-1);
            //SortArray.quickSortIt(a, 0, a.length-1);
            //System.out.println("kth Term: " + SortArray.MM(a,0 , a.length-1, kth));
        /*
        for(int i = 0; i < size; i++){
            System.out.print(a[i]+"\t");
        }*/
            System.out.println("kth Term: " + a[kth]);


            double end = System.nanoTime();
            System.out.println("\nRun Time (ns):\t" + (end - start));

            /*
             * WRITES TIMES TO TEXT FILE FOR CALCULATION PURPOSES
             */
            File testData = new File("testData.txt");
            FileWriter writeTo = new FileWriter(testData, true);
            BufferedWriter writeThis = new BufferedWriter(writeTo);
            writeThis.append("\n" + Double.toString(end - start));
            writeThis.close();
        }
    }
}
