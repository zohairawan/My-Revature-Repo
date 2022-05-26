import java.util.Scanner;

public class FavNum {

    public static void main(String[] args) {
        int num[] = {61, 20, 72, 53};
        System.out.println(FavNum.favorite(20, 72, 4, num));
    }

    public static int favorite(int L, int R, int N, int A[]) {
        Scanner sc = new Scanner(System.in);
//        L = sc.nextInt();
//        R = sc.nextInt();
//        N = sc.nextInt();
//        A = new int[N];
        int count = 0;
        for(int i=0; i<N; i++) {
            //A[i] = sc.nextInt();
            if(A[i] >= L && A[i] <= R) {
                count++;
            }
        }
        return count;
    }
}
