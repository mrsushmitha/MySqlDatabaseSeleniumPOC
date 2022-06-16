package mysqldatadriven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTestEx2 {
	public static void main(String[] args) throws Exception {
		String baseUrl="https://www.facebook.com/";
		WebDriver driver;
		String port="3306";
		String host="localhost";
		String name = null;
		String passd = null;
	
		
		

		System.setProperty("webdriver.chrome.driver", "//Users//supreeth//Downloads//chromedriver");
		driver=new ChromeDriver();
		driver.get(baseUrl);	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Qadbt", "root", "root");
		Statement s=conn.createStatement();
	ResultSet rs=s.executeQuery("select * from logIn where scenario='scenario1'");
	
		while(rs.next()) {
			 name=rs.getString("uname");
			passd=rs.getString("password");
		}
	driver.findElement(By.id("email")).sendKeys(name);	
	driver.findElement(By.id("pass")).sendKeys(passd);
	driver.findElement(By.cssSelector("[name='login']")).click();
	Thread.sleep(5000);
	driver.quit();
		
	}
	}


