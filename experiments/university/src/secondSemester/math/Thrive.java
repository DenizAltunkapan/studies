package secondSemester.math;

import java.util.Scanner;

public class Thrive {

    public static void main(String[] args){
    	System.out.println("Bitte gib eine Zahl ein, die als Linearkombination von 3 und 5 dargestellt werden soll");
    	Scanner scanner = new Scanner(System.in);
    	int value= scanner.nextInt();
        Tuple<Integer,Integer> result = compute(value);
        
        System.out.println(value +"= "+result.getX()+ "*3 + "+ result.getY()+ "*5 !");
    }
    
    
    public static Tuple compute(int n){
        if(n<8){
            throw new IllegalArgumentException("n must be at least 8");
        }
        Tuple<Integer,Integer> pair= new Tuple<>();
        if(n==8){
            pair.set(1,1);
        }else if(n%3==0){
            pair.set(n/3,0);
        }else if(n%5==0){
            pair.set(0,n/5);
        }else if(n%3==1){
            pair = compute(n-1);
            pair.set(pair.getX()-3, pair.getY()+2);
        }else if(n%3==2){
            pair = compute(n-1);
            pair.set(pair.getX()+2, pair.getY()-1);
        }
        return pair;
    }
}

class Tuple<X, Y> {
    private X x;
    private Y y;

    public Tuple() {
        this.x = null;
        this.y = null;
    }
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
    public void set(X x, Y y){
        this.x =x;
        this.y = y;
    }

}
