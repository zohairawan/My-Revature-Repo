import java.util.*;
import java.io.*;
import java.lang.Math;

public class Average
{
    public static double averageValue(double N,double [] A)
    {

        //this is default OUTPUT. You can change it.
        double result = 0;
        double sum = 0;

        for(int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        result = sum / N;
        return result;
    }
    public static void main (String[]args)
    {
        Scanner sc = new Scanner (System.in);

        //INPUT [uncomment & modify if required]
        double N = sc.nextDouble();

        double [] A = new double[N];
        for (int i = 0; i < N; i++)
        {
            A[i] = sc.nextDouble ();
        }

        sc.close ();

        //OUTPUT [uncomment & modify if required]
        System.out.print(averageValue(N,A));
    }
}
