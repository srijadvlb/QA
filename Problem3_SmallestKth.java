
import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author srija
 */
public class Problem3_SmallestKth {

    public static void main(String args[]) throws Exception {
        int size = 500;
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter kth number:");
        int k = reader.nextInt();

        System.out.println(k + "th smallest number: " + smallestnumber(arr, k));
    }

    public static int smallestnumber(int arr[], int k) throws Exception {
        Arrays.sort(arr);

        if (k < 500 && k >= 0) {
            return arr[k];
        } else {
            throw new Exception("K is not valid range");
        }
    }
}
