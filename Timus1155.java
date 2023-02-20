import java.util.Scanner;

public class Timus1155 {
    static int[] stack = new int[10];
    static int s1, s2;
    static void Alg(int x, int y, int tmp){
        while(stack[x] != 0){
            if(stack[tmp] == 0){
                stack[tmp] ++;
                stack[y] ++;
            System.out.printf("%c%c+\n", 'A' + y, 'A' + tmp);
            }
            stack[tmp]--;
            stack[x]--;
            System.out.printf("%c%c-\n", 'A'+x, 'A'+tmp);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        while(n < 8){
            stack[n] = in.nextInt();
            n ++;
        }
        s1 = stack[0] + stack[2] + stack[5] + stack[7];
        s2 = stack[1] + stack[3] + stack[4] + stack[6];
        if(s1 != s2){
            System.out.println("IMPOSSIBLE");
        }else{
            Alg(2, 0, 1);
            Alg(5, 0, 4);
            Alg(7, 0, 4);
            Alg(6, 4, 5);
            Alg(1, 4, 0);
            Alg(3, 4, 0);
            while(stack[0] != 0){
                System.out.printf("AE-\n");
                stack[0] --;
            }
        }

    }
}