package firstSemester.pse.inheritance;

public class Main {

	public static void main(String[] args) {
		final SomeInterface entity1 = new SomeClass();
		/** Fehler
		 * final AnotherInterface entity2 = new AnAbstractClass();
		 */
		final AnAbstractClass entity3 = new OtherClass();
		final OtherClass entity4 = new OtherClass();
		final SomeClass entity5 = new SomeClass();


		/** Fehler
		 * final SomeInterface entity6 = entity4;
		 */
		final SomeInterface entity7 = entity5;
		/** Fehler
		 * final OtherClass entity8 = entity3;
		 */


		entity1.someOperation();
		//entity2.anotherOperation();
		/** Fehler
		 * entity3.anotherOperation(entity1);
		 */
		entity4.anotherOperation(entity5);
		/** Fehler
		 * entity4.anotherOperation(entity4);
		 */
		entity5.equals(entity7);


	}


}

interface SomeInterface{
	public void someOperation();
}

interface AnotherInterface{
	public void anotherOperation();
}

abstract class AnAbstractClass implements AnotherInterface{
	@Override
	public void anotherOperation(){
		System.out.println("anotherOperation");
	}
}

class OtherClass extends AnAbstractClass{
	@Override
	public void anotherOperation(){
		System.out.println("anotherOperation");
	}
	public void anotherOperation(final SomeInterface something){
		System.out.println("someInterfaceINanotherOperation");
	}
}

class SomeClass extends AnAbstractClass implements SomeInterface{

	@Override
	public void someOperation() {
		System.out.println("SomeOperation");
	}
}
