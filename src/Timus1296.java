//https://acm.timus.ru/problem.aspx?space=1&num=1296 - task 

import java.util.ArrayList;
import java.util.Scanner;

public class Timus1296 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        System.out.println(MaxSubAr(count, in));

}
static int MaxSubAr(int count, Scanner in){
        ArrayList<Integer> MaxSub = new ArrayList<>();
        MaxSub.add(0);
        int MaxOfSub = 0;
        for(int i = 0; i < count; i ++){
            int tmp = MaxSub.get(MaxSub.size() - 1) + in.nextInt();;
            if(tmp < 0){tmp = 0;}
            MaxSub.add(tmp);
            if(tmp > MaxOfSub){MaxOfSub = tmp;}
        }
        return MaxOfSub;
    }
}
