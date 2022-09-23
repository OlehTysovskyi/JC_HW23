package First_Task;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VerhovnaRada {
	
	VerhovnaRada(){
		
	}
	
	List <Fraction> fractions = new ArrayList<>();
	Scanner scn = new Scanner(System.in);	
	ListIterator <Fraction> frlitr = fractions.listIterator();
	
	public void addFraction() {
		System.out.print("-Enter fraction's name: ");
		String fractionName = scn.next();
		
		fractions.add(new Fraction(fractionName));
		System.out.println("-Fraction was added successfully" + "\n" + fractions);	
	}
	
	public void removeFraction() {
		System.out.println(fractions.toString());
		System.out.print("-To remove fraction enter it's name: ");
		String fractionName = scn.next();	
		
		List <Fraction> f = fractions.stream().filter(fraction -> fraction.getFractionName().equals(fractionName)).collect(Collectors.toList());
		fractions.removeAll(f);
		System.out.println("-Fraction was removed successfully" + "\n" + fractions);
	}
	
	public void showAllFractions() {
		System.out.println(fractions);
	}
	
	public void showConcretteFraction() {
		System.out.println(fractions.toString());
		System.out.print("-Enter the index to see the fraction: ");
		int index = scn.nextInt();
		
		try{
			if(index >= fractions.size()) throw new ArrayIndexOutOfBoundsException();
			else System.out.println(fractions.get(index));	
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("#Such index doesn't exist!");		
		}
	}
	
	public void addDeputyToFraction() {
		System.out.println(fractions.toString());
		System.out.print("-Enter the name of fraction in which you want to add deputy: ");
		String fractionName = scn.next();
		
		fractions.forEach(f -> {
			if(f.getFractionName().equals(fractionName)) f.addDeputy();
		});
	}
	
	public void removeDeputyFromFraction() {
		System.out.println(fractions.toString());
		System.out.print("-Enter the name of fraction from which you want to remove deputy: ");
		String fractionName = scn.next();
	
		fractions.forEach(f -> {
			if(f.getFractionName().equals(fractionName)) f.removeDeputy();
		});	
	}
	
	public void showAllBribers() {		
		fractions.forEach(f -> f.showAllBribers());
		System.out.println();
	}
	
	public void removeAllDeputiesFromFraction() {
		System.out.println(fractions.toString());
		System.out.print("-Enter the name of fraction from which you want to remove deputies: ");
		String fractionName = scn.next();
		
		fractions.forEach(f -> {
			if(f.getFractionName().equals(fractionName)) f.removeAllDeputies();
		});
	}
	
	public void showTheBiggestBriber() {
		int max = 0;
		Deputy de = null;
		for(Fraction f : fractions){
			for(Deputy d : f.deputies) {	
				if(d.isBribe()) {
					if(d.getBribeSize() > max) {
						max = d.getBribeSize();
						de = d;
					}			
				}
			}
		}
		System.out.println(de);
	}
}
