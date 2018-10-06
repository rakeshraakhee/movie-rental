import java.util.ArrayList;

import java.util.List;


public class Customer {
	private String _name;
	private List <Rental> myRentals=new ArrayList<Rental>();//data type change from vector to ArrayList

	public Customer (String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		myRentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {

		//Enumeration rentals  = _rentals.elements();
		//String name = getName();
		String result = header(getName());
		for(Rental each : myRentals) {//data type change with iterator instead of enumeration
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() +
					"\t" + String.valueOf(each.amountOf()) + "\n";
		}
		double totalAmount=totalAmount(this.myRentals);
		int frequentRenterPoints=frequentRenterPoints(this.myRentals);
		// add footer lines
		result += footer(totalAmount, frequentRenterPoints);
		return result;
	}

	/*to add a new method to print the statement for a customer in XML
	format, e.g., <name> John Smith </name>, <movie> Independent Day </movie>, etc.*/

	public String xmlStatement() {
		//Enumeration rentals = _rentals.elements();
		String name=getName();
		String result = "<statement> \n" + 
				"\t"+"<name> "+ name + " </name>" + "\n";
		for(Rental each : myRentals) {
			// show figures for this rental
			result += "\t" + "\t" +"<movie>" + each.getMovie().getTitle()+" </movie>" +"\n" +
					"\t" + "\t" + "\t"+ "<price>" + String.valueOf(each.amountOf()) + "</price>" + "\n";
		}

		//double totalAmount=totalAmount(this.myRentals);

		//int frequentRenterPoints=frequentRenterPoints(this.myRentals);
		//add footer lines
		result +=  "\t" +"<amountOwed>" + totalAmount(this.myRentals) + "</amountOwed>"+ "\n";
		result += "\t" +"<frequentRenterPoints>" + frequentRenterPoints(this.myRentals) + "</frequentRenterPoints>"+ "\n"+"</statement>";
		return result;

	}


	private String header(String aname) {
		String      result = "Rental Record for " + getName() + "\n";
		return result;
	}
	/**
	 * @param totalAmount
	 * @param frequentRenterPoints
	 * @return
	 */
	private String footer(double atotalAmount, int afrequentRenterPoints) {
		String footer1="Amount owed is " + String.valueOf(atotalAmount) + "\n";
		String footer2= "You earned " + String.valueOf(afrequentRenterPoints) +
				        " frequent renter points";
		String footer=footer1+footer2;
		return footer;
	}

	private int frequentRenterPoints(List <Rental> rentals) {
		int         frequentRenterPoints = 0;
		for(Rental each : rentals) {//data type change with iterator instead of enumeration
			// add frequent renter points
			frequentRenterPoints+=each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private double totalAmount(List <Rental> rentals) {
		double      totalAmount          = 0;
		for(Rental each : rentals) {//data type change with iterator instead of enumeration
			// determine amounts for each line
			totalAmount += each.amountOf();
		}
		return totalAmount;
	}

}
