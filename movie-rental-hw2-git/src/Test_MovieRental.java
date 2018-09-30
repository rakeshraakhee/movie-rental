
public class Test_MovieRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
				Movie m1=new Movie("Incredibles",2);
				Movie m2=new Movie("Titanic",0);
				Movie m3=new Movie("MI3",1);
				
				Rental r1=new Rental(m1,10);
				Rental r2=new Rental(m2,3);
				Rental r3=new Rental(m3,4);
				
				
				
				
				Customer c1=new Customer("Rakesh");
				c1.addRental(r1);
				c1.addRental(r2);
				c1.addRental(r3);
				
				String s=c1.statement();
				System.out.println(s);
				
				

			}

	}


