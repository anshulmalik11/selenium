package testNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderEx2 {
	
	@Test(dataProvider = "dataProvider_BookTicket")
	public void bookTickets(String src, String dest, int NoOfPpl) {
		System.out.println("Book ticket from "+src+" to "+dest+" no of ppl are "+NoOfPpl+".");
	}
@DataProvider
	public Object[][] dataProvider_BookTicket(){
		Object[][] objArr = new Object[2][3];
		
		objArr[0][0] = "Banglore";
		objArr[0][1] = "Goa";
		objArr[0][2] = 5;
		
		objArr[1][0] = "Banglore";
		objArr[1][1] = "Mysore";
		objArr[1][2] = 3;
		
		return objArr;
		
	}
}
