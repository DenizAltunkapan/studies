package secondSemester;

import java.util.Random;

public class MonteCarlo{
    public static double mci(int n){
        Random random = new Random();
        int count = 0;
        double x;
        double y;

        for(int i= 0; i< n; i++){
            x = random.nextDouble();
            y = random.nextDouble();
            if((x*x + y*y) <= 1){
                count ++;
            }
        }
        return 4.0 * count/n;
    }
}
class testCarlo{
    public static void main(String[] args){
        System.out.println(MonteCarlo.mci(50000000));
    }
}
