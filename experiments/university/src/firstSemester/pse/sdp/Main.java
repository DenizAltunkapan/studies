package firstSemester.pse.sdp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Benutzer deniz = new Benutzer();
		//deniz.setAlgorithm(new MaxValue());
		Scanner s = new Scanner(System.in);
		System.out.println("gib 0 ein wenn du das Maximum berechnen willst, für ggt 1");
		int input = s.nextInt();
		if(input == 0) {
			deniz.setAlgorithm(new MaxValue());
		}
		if(input== 1) {
			deniz.setAlgorithm(new ggtAlgorithmus());
		}
		System.out.println("bitte gib deine Zahlen ein");
		int a =s.nextInt();
		int b =s.nextInt();
		
		int x = deniz.benutzeAlgorithmus(a,b);
		System.out.println(x);

	}

}
