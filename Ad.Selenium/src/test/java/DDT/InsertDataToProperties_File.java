package DDT;

import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToProperties_File {
	public static void main(String[] args) throws Throwable {
		
		Properties pro = new Properties();
		pro.setProperty("URL", "https://www.saucedemo.com/v1/");
		pro.setProperty("USERNAME", "standard_user");
		pro.setProperty("PASSWORD", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\data2.properties");
		pro.store(fos, "data2");
	}
}
