package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILE_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}

}
