package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	public String getPropertiesData(String key) throws Throwable {
		
//		this method is used to read data from properties file
//		@param key
//		@return
//		@throws Throwable
//		@Anshul
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\data2.properties");
		Properties pro = new Properties();
		pro.load(fis);	
		String value = pro.getProperty(key);
		
		return value;
		
	}
}
