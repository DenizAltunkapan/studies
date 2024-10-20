package firstSemester;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> hochzahlenl = new ArrayList<>();
		ArrayList<Integer> koeffizientenl = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		double value = 0;

		System.out.println("Bitte gib deine Hochzahlen des Polynoms an");
		String expon = s.nextLine();
		hochzahlen(expon, hochzahlenl);
		System.out.println(hochzahlenl);
		System.out.println("Bitte gib deine Koeffizienten in der gleichen Reihenfolge wie die Hochzahlen des Polynoms an");
		String koef = s.nextLine();
		koeffizient(koef, koeffizientenl);
		System.out.println(koeffizientenl);
		
		
		System.out.println("Ich berechne dir die Nullstellen:");
		for(int i=-2 ; i<5; i++) {
			value = 0;
			for(int k= 0; k < hochzahlenl.size(); k++) {
				if(hochzahlenl.get(k)==0) {
					value += koeffizientenl.get(k);
					//System.out.println(value);
					
				}else {
					value += koeffizientenl.get(k) * Math.pow(i,hochzahlenl.get(k));
					//System.out.println(value);
				}
				
			}
			if(value == 0) {
				System.out.println(i);
			}
		}
	}
	public static void hochzahlen(String text, ArrayList<Integer> zahlen ) {
		for(int i=0; i< text.length();i++) {
			if(text.charAt(i)== ',') {
				continue;
			}else {
				if(text.charAt(i)=='-') {
					int number = text.charAt(i+1) - '0';
					zahlen.add(-number);
					i++;
				}else {
				int number = text.charAt(i) - '0';
				zahlen.add(number);
				}
			}
		}
	}
	
	
	
	public static void koeffizient(String text, ArrayList<Integer> zahlen ) {
		for(int i=0; i< text.length();i++) {
			if(text.charAt(i)== ',') {
				continue;
			}else {
				if(text.charAt(i)=='-') {
					int number = text.charAt(i+1) - '0';
					zahlen.add(-number);
					i++;
				}else {
				int number = text.charAt(i) - '0';
				zahlen.add(number);
				}
			}
		}
	}
	
	
		
	
}	
	
