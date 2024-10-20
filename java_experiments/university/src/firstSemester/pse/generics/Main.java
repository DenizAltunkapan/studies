package firstSemester.pse.generics;

public class Main {

	public static void main(String[] args) {
		GenericList<Integer> mylist = new GenericList<>(1,2);
		System.out.println(mylist.getList());
		GenericOperation g = new GenericOperation();
		g.shout("Ahhh", "BBB");
	}

}
