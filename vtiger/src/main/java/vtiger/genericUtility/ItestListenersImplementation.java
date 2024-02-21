package vtiger.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());

	}

	public void onTestFailure(ITestResult result) {

		String testCaseName = result.getMethod().getMethodName();

		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		try {
			WebDriverUtility.takeAScreenShot(BaseClass.sDriver, testCaseName);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/vtigerReport.html");

		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Vtiger Extent Report");
		spark.config().setDocumentTitle("Vtiger Report");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Akash");
		report.setSystemInfo("ReviwedBy", "Deepak");
		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("ServerName", "ApacheTomcat");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
