package vtiger.genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mysql.cj.jdbc.Driver;

import vtiger.pomRepository.HomePage;
import vtiger.pomRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;

	public FileUtility fUtils = new FileUtility();
	public JavaUtility jUtils = new JavaUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public Connection connection;
	@BeforeSuite(groups = { "smoke", "regression" })
	public void bsConfig() throws SQLException {

		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");

		System.out.println("Database connection is established");
	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smoke", "regression" })
	public void bcConfig() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		wUtils.maximizeTheWindow(driver);
		wUtils.waitForElement(driver);
		System.out.println("Launch the Browser");
		driver.get(url);
		System.out.println("Navigate to the URL");

	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void bmConfig() throws IOException {

		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);

		System.out.println("Login to the Application");

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void amConfig() throws IOException {

		HomePage home = new HomePage(driver);
		home.signOutAction();
		System.out.println("Logout from the Application");

	}

	@AfterClass(groups = { "smoke", "regression" })
	public void acConfig() {
		driver.quit();
		System.out.println("Browser is closed");
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void as() throws SQLException {
		connection.close();
		System.out.println("The Data base is closed");
	}

}
