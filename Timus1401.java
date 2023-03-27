import java.util.Scanner;

public class Timus1401 {
    static int [][] A = new int [512][512];
    static int m = 3;
    static void init(int n, int x, int y, int hx, int hy){
        if(n==2){
            for(int i = 0; i < 2; i++)
                for(int j = 0; j < 2; j++)
                    if(x+i != hx || y+j != hy)
                        A[x+i][y+j] = m++/3;
            return;
        }
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                if(x + i*n/2 > hx || hx >= x + i*n/2+n/2 || y + j*n/2 > hy || hy >= y + j*n/2+n/2)
                    A[x+n/2-1+i][y+n/2-1+j] = m++/3;
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                if(x + i*n/2 <= hx && hx < x + i*n/2+n/2 && y + j*n/2 <= hy && hy < y + j*n/2+n/2)
                    init(n/2, x + i*n/2, y + j*n/2, hx, hy);
                else
                    init(n/2, x + i*n/2, y + j*n/2, x + n/2 - 1 + i, y + n/2 - 1 + j);
    }
    static int foo(int n){
        int i = 1;
        while (n>0) {
            i*=2;
            n--;
        }
        return i;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        int px =  in.nextInt();
        int py =  in.nextInt();
        in.close();
        int s = foo(n);
        init(s, 0, 0, px-1, py-1);
        for(int i = 0; i < s; i++)
        {
            for(int j = 0; j < s; j++)
                System.out.print(A[i][j] + " ");
            System.out.println();
        }

    }
}
