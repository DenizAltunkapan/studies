package firstSemester.pse.sdp;

public class Benutzer{
	private Algorithmus algo;
	private String name;
	
	public Benutzer() {
		this.algo = new ggtAlgorithmus(); 
	}
	
	public int benutzeAlgorithmus(int a, int b) {
		return algo.rechnen(a, b);
	}
	
	public void setAlgorithm(Algorithmus a) {
		this.algo = a;
	}
}
