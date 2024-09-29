package firstSemester.pse.functionalsAndCollections;


import java.util.List;
import java.util.stream.Collectors;

public class LambdasÜbung{

	public static void main(String[] args) {
		List<Integer> myList = List.of(0,12,23,5,3,2,6,84,3);
		myList.stream().filter(t-> t%2==1).forEach(System.out::println);
		System.out.println(myList.stream().filter(t-> t%2==0).sorted().collect(Collectors.toList()));	
		
	}

	public static void rechenOperation(Rechner rechner, int zahl1, int zahl2) {
		rechner.rechnen(zahl1, zahl2);
	}


}



