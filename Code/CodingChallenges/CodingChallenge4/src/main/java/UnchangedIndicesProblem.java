import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class UnchangedIndicesProblem {
        public static int unchangedIndex(int N, int A[]) {
            //this is default OUTPUT. You can change it
            int result=0;
            int newArr [] = new int[N];
            System.arraycopy(A, 0, newArr, 0, newArr.length);

            //WRITE YOUR LOGIC HERE:
            for(int i = 0; i < A.length; i++) {
                for(int j = i+1; j < A.length; j++) {
                    int temp;
                    if(newArr[i] > newArr[j]) {
                        temp = newArr[i];
                        newArr[i] = newArr[j];
                        newArr[j] = temp;
                    }
                }
            }

            for(int i = 0; i < newArr.length; i++) {
                if(newArr[i] == A[i]) {
                    result++;
                }
            }

            return result;
        }
        public static void main(String[] args) {
            // INPUT [uncomment & modify if required]
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int A [] = new int[N];
            for(int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }

            // OUTPUT [uncomment & modify if required]
            System.out.print(unchangedIndex(N,A));
            sc.close();
        }
}
