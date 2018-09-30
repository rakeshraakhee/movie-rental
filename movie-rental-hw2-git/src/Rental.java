public class Rental {
    private Movie _movie;
    private int   _daysRented;
    
    public Rental(Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }
    
    public double amountOf() {//*variable name Change---each to aRental
		double aRentalAmount = 0;//*variable name Change---thisAmount to aRentalAmount
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			aRentalAmount += 2;
			if (getDaysRented() > 2) {
				aRentalAmount += (getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			aRentalAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			aRentalAmount += 1.5;
			if (getDaysRented() > 3) {
				aRentalAmount += (getDaysRented() - 3) * 1.5;
			}
			break;
		}

		return aRentalAmount;
	}
}