package vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int limit = 2;
	int count = 0;
	public boolean retry(ITestResult result) {

		if(count<limit) {
			count ++;
			return true;
		}
		
		return false;
	}

}
