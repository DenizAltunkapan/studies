package firstSemester.pse.functionalsAndCollections;

import java.util.*;
import java.util.stream.Collectors;

public class Streams{
	
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Mark",21));
		persons.add(new Person("Markus",29));
		persons.add(new Person("Kerim",25));
		persons.add(new Person("Leon",23));
		persons.add(new Person("Steffen",30));
		persons.add(new Person("Maja",12));
		persons.add(new Person("Emily",17));
		persons.add(new Person("Sebastian",16));
		
		long x= persons.stream()
				.count();
		System.out.println(x);
		
		//Person p= persons.stream().min(Comparator.comparingInt(m-> m.getAge())).get();
		//System.out.println(p.getName());
		//List<Person> d= persons.stream().mapToDouble(t-> t.getName());
		persons.stream().map(l->l.getAge()).sorted(Comparator.reverseOrder()).forEach(t-> System.out.println(t));
		persons.stream().collect(Collectors.toSet());

		System.out.println("------------------------------------");
        Optional<Integer> i = Optional.empty();
										
	}


	static class Person{
		private final String name;
		private final int age;

		public Person(final String name, final int age) {
			 this.name = name;
			 this.age = age;
		}

		public String getName() {
			return this.name;
		}

		public int getAge() {
			return this.age;
		}

	}
}

