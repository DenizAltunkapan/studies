package firstSemester.pse.functionalsAndCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface MyFunction<T,R>{
    R apply(T a);
}

class Main{
    public static void main(String[] args){
        MyFunction<Integer,Integer> fkt = new MyFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer a) {
                return a*a;
            }
        };
        
        System.out.println(fkt.apply(3));
        List<Integer> myList= new ArrayList<>();
        myList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}