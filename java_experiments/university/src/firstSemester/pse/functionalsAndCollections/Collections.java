package firstSemester.pse.functionalsAndCollections;

import java.util.*;


import firstSemester.pse.immutability.Address;
import firstSemester.pse.immutability.Person;


public class Collections {

	public static void main(String[] args) {
		queue();
		//stack();

		Set<Person> persons = new HashSet<>() ;

		Person deniz = new Person(new Address("Ludwigsburg", "Reichertshalde", 8),"Deniz",18);
		Person markus = deniz;
		Person sven = new Person(new Address("Ludwigsburg", "Reichertshalde", 8),"Deniz",17);
		
		System.out.println(deniz.equals(sven));
	}

	private static void stack() {
		System.out.println("---------------");
		Stack<Integer> stack = new Stack<>();
		stack.add(3);
		stack.add(1);
		stack.add(4);
		stack.add(2);
		stack.add(5);


		stack.forEach(t-> System.out.println(t));

		System.out.println("---------------");
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(1);
		set.add(4);
		set.add(2);
		set.add(5);
		set.forEach(t-> System.out.println(t));
	}

	private static void queue() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(3);
		queue.add(1);
		queue.add(4);
		queue.add(2);
		queue.add(5);
		System.out.println(queue.element());
		System.out.println(queue.stream().map(t->t+2).toList());

		//queue.forEach(t-> System.out.println(t));
	}


}


