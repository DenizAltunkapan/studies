package firstSemester.pse.functionalsAndCollections;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
	
	public static String getName() {
		return "julian";
	}
	
	public static void main(String[] args) {
		//Function
		Function<Integer, Integer> function = l -> (l-1)/2;
		System.out.println(function.apply(3));
		
		//Predicate
		Predicate<Integer> isEven = n -> n%2 == 0;
		System.out.println(isEven.test(4));
		
		//Supplier
		Supplier<String> saySomething = ()->"I am a Goat";
		System.out.println(saySomething.get());
		
		//Consumer
		Consumer<Double> sentence = s -> System.out.println("your number is " + s);
		sentence.accept(3.0);
		
		//BiFunction
		BiFunction<Integer, Integer, Double> mittelwert= (x,y) -> (double) (x+y)/2;
		System.out.println(mittelwert.apply(3, 10));
		
		//BiConsumer
		BiConsumer<String, String> concat = (s1,s2) -> System.out.println(s1+s2);
		concat.accept("Hallooo", "Weltt");
		
		//Double Colon Operator
		Supplier<String> julian = FunctionalInterfaces::getName;
		System.out.println(julian.get());
		
		Predicate<Integer> p = i -> {
			for(int i1=0;i1<3;i1++) {
				return i1==2;
			}
			return false;
		};
		
	}

}
