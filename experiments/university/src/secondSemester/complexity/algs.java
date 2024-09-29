package secondSemester.complexity;

public class algs {

    //O(log_3(n))
    public static int alg1(int n){
        int result = 1;
        if(n>3){
            result= 1 +alg1(n/3);
        }
        return result;
    }

    //O(n^2 log(n))
    public static int alg2(int n){
        int result = n ;
        int temp = 0;
         for (int i = 4 * n ; i > 0; i = i / 2) {
             for (int j = 0; j < n ; j = j + 3) {
                 temp = temp + 1;
             }
         }
         for (int k = 6 * n ; k > 0; k --) {
             for (int l = 0; l < temp ; l ++) {
                 result = result + 1;
             }
         }
        return result ;
    }

    //O(n^2)
    public static int alg3(int n){
        int sum = 0;
        for (int i = 0; i < n / 2; i ++) {
            for (int j = 100; j > 0; j --) {
                for (int k = 0; k < n / 8; k ++) {
                    sum = sum + 1;
                }
            }
        }
        return sum ;

    }

    //O(n^2)
    public static int alg4(int n ) {
        int sum = 0;
        if ( n > 1) {
            sum = alg4( n - 1) + 1;
            }
        else {
            sum = 1;
            }
        for (int i = 0; i < n / 2; i ++) {
            sum = sum - 1;
        }
        return sum ;
    }

    //O(n^3)
    public static int alg5(int n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = n; j > 0; j -- ) {
                    for (int k = 0; k < n/2; k++) {
                        sum = sum+1;
                    }
                }
            }
            for (int l= 0; l < n; l++) {
                sum = sum - 1;
            }
            return sum;
    }

    public static int alg6(int n) {
        int summe = 0;
        for (int i = n; i >= 1; i = i / 2) {
            for (int j = 0; j < 100; j++) {
                summe++;

            }

        }
        return summe;
    }

    //Fibonacci (2^n)
    public static int alg7(int n){
        int sum=0;
        if(n>1){
            int a= alg7(n-1);
            int b= alg7(n-2);
            sum=a+b;
        }else{
            sum=n;
        }
        return sum;
    }

    //O(2^n)
    public static int alg8(int n){
        int p=1, r=0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= p ; j++) {
                r++;
            }
            p= p*2;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(alg8(10));
    }
}
