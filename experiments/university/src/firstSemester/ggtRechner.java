package firstSemester;

public class ggtRechner {
	/*@
	 * 
	 */
	/*
	 * ggT-Rechner berechnet größten gemeinsamen Teiler zweier Ganzzahlen ohne Rekursion
	 * @ param a Ganzzahl 1
	 * @ param b Ganzzahl 2
	 */
	public static int ggT(int a, int b) {
		int max;
		int min;
		int temp;
		int rest;
		if(a>b) {
			max= a;
			min = b;
			
		}else {
			max = b;
			min = a;
		}
		rest = max%min;
		while(rest > 0) {
			temp = min;
			min = rest;
			max = temp;
			rest = max % min;
		}
		
		return min;		
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ggT(5780,2340273);
	}

}
