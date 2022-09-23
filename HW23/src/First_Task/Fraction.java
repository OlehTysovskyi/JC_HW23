package First_Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fraction {
	
	private String fractionName;
	
	Fraction(String fractionName) {
		this.fractionName = fractionName;
	}
		
	List <Deputy> deputies = new ArrayList<>();
	Scanner scn = new Scanner(System.in);	

	public void addDeputy() {
		System.out.print("-Enter deputy's firstname: ");
		String firstname = scn.next();
		System.out.print("-Enter deputy's lastname: ");
		String lastname = scn.next();
		System.out.print("-Enter deputy's weight: ");
		double weight = scn.nextInt();
		System.out.print("-Enter deputy's height: ");
		double height = scn.nextInt();
		System.out.print("-Enter deputy's bribe status(true/false): ");
		boolean bribe = scn.nextBoolean();
		
		deputies.add(new Deputy(weight, height, firstname, lastname, bribe));
		System.out.println("-Deputy was added successfully" + "\n" + deputies);	
	}

	public void removeDeputy() {
		System.out.println(deputies.toString());
		System.out.print("-To remove deputy enter his firstname: ");
		String firstName = scn.next();
		
		List <Deputy> d = deputies.stream().filter(deputy -> deputy.getFirstname().equals(firstName)).collect(Collectors.toList());
		deputies.removeAll(d);
		System.out.println("-Deputy was removed successfully" + "\n" + deputies);
	}

	public void showAllBribers() {
		System.out.println("-There are all bribers from fraction " + this.fractionName + " :");
		System.out.println(deputies.stream().filter(deputy -> deputy.isBribe() == true).collect(Collectors.toList()));	
	}
	
	public void showAllDeputies() {
		System.out.println(deputies);
	}

	public void removeAllDeputies() {
		deputies.removeAll(deputies);
		System.out.println(deputies);
	}
	
	public String getFractionName() {
		return fractionName;
	}

	public void setFractionName(String fractionName) {
		this.fractionName = fractionName;
	}

	@Override
	public String toString() {
		return "Fraction [name=" + fractionName + ", deputies=" + deputies + "]";
	}

	
}
