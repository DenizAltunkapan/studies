package firstSemester;


import java.util.*;

import java.util.stream.Collectors;

import firstSemester.pse.immutability.Address;
import firstSemester.pse.immutability.Person;


public class training {
	
	/*
	 * dieser javadoc kommentar ist zu sehen, wenn du Shift + F2 drücst
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Person> persons = new HashSet<>();
		Address lb = new Address("Ludwigsburg", "Reichertshalde", 8);
		Person deniz = new Person(lb, "Deniz", 19);
		persons.add(deniz);
		Address fb = new Address("Freiberg", "Carl-Mauch-Weg", 7);
		Person maxi = new Person(lb, "Maxi", 19);
		persons.add(maxi);
		Person berin = new Person(lb, "Berin", 11);
		persons.add(berin);
		Address stuttgart = new Address("Stuttgart", "Bismarck-Straße", 2);
		Person ethan = new Person(lb, "Ethan", 17);
		persons.add(ethan);

/*
		System.out.println(persons.size());
		Consumer<Person> s = p-> System.out.println(p.getName());
		persons.forEach(s);


		System.out.println("-----------------");
		getSortedSet(persons).forEach(t-> System.out.println(t));

		System.out.println("------------------------");
		isAdult(persons).forEach(t-> System.out.println(t));
	*/
		sortByName(persons).forEach(t-> System.out.println(t.getName()));
		
	}
	public static List<Integer> getSortedSet(Collection<Person> persons){

		return persons.stream().map(t-> t.getAge()).sorted().collect(Collectors.toList());
	}

	public static List<String> isAdult(Collection<Person> persons){
		return persons.stream().filter(t-> t.getAge() > 17).map(t->t.getName()).toList();
	}

	public static Collection<Person> sortByName(Collection<Person> persons){
		return persons.stream().sorted(Comparator.comparing(t-> t.getName())).toList();
	}
	

}
