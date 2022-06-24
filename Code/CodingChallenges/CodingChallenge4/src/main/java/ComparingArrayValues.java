import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class ComparingArrayValues {
    public static int smallInteger(int N, int X, int A[]) {
        //this is default OUTPUT. You can change it
        int result=-404;

        //WRITE YOUR LOGIC HERE:
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                int temp;
                if(A[i] > A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }

        for (int j : A) {
            if (j > X) {
                result = j;
                break;
            }
        }


        return result;
    }
    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int A [] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        System.out.print(smallInteger(N, X, A));
        sc.close();
    }
}