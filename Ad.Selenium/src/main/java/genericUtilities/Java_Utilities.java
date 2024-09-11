package genericUtilities;

import java.util.Random;

public class Java_Utilities {
	
//	this method is used to avoid duplicates
//	@return
//	@author Anshul
	
	public int getRanNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}
