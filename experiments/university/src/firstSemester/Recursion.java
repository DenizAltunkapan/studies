package firstSemester;

public class Recursion {

	public static int power(int x, int y) {
		if(y<0) {
			throw new IllegalArgumentException("Hochzahl darf nicht negativ sein!");
		}
		if(y==0) {
			return 1;
		}
		return x * power(x,y-1);
	}

	public static int sum(int n){
		if(n<0){
			throw new IllegalArgumentException("number can not be less than zero!");
		}
		if(n==0){
			return 0;
		}
		return n+sum(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(power(3,2));
	}
}



