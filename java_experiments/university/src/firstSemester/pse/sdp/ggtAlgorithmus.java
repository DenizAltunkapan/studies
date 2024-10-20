package firstSemester.pse.sdp;

public class ggtAlgorithmus implements Algorithmus{

	
	public int rechnen(int a, int b) {
		if (a > b) {
			return rechnen(a-b, b);
		}else if (a < b) {
			return rechnen(a, b-a);
		}else {
			return a;
		}
	}
	
}
