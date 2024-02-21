package vtiger.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Akash Deb
 *
 */
public class WebDriverUtility {
	/**
	 * 
	 * @param driver
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT_DURATION));
	}

	/**
	 * 
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForButtonToClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT_DURATION));
		wait.until((ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * 
	 * @param driver
	 * @param titleOfPageToSwitch
	 */
	public void switchToWindow(WebDriver driver, String titleOfPageToSwitch) {

		Set<String> allIDS = driver.getWindowHandles();

		for (String id : allIDS) {
			driver.switchTo().window(id);

			String currentWindowTitle = driver.getTitle();

			if (currentWindowTitle.contains(titleOfPageToSwitch)) {

				break;
			}
		}
	}

	/**
	 * 
	 * @param driver
	 * @return 
	 * @throws WebDriverException
	 * @throws IOException
	 */
	public static void takeAScreenShot(WebDriver driver, String fileName) throws WebDriverException, IOException {
		JavaUtility jUtils = new JavaUtility();
		String dateTime = jUtils.generateSystemDateAndTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		Files.copy(ts.getScreenshotAs(OutputType.FILE), new File("./src/test/resources/screenshots/"+fileName+dateTime+".png"));
	}

	/**
	 * 
	 * @param driver
	 */
	public void selectOKInAlertPopUp(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	/**
	 * 
	 * @param driver
	 */
	public void selectCancelInAlertPopUp(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

}
