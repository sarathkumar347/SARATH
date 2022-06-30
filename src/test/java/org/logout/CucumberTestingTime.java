package org.logout;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CucumberTestingTime {
	
	
	WebDriver driver;
	
	
	@Given("Open the Facebook Application")
	public void open_the_Facebook_Application() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	
		
		
	}
	    

	@When("Enter the Username")
	public void enter_the_Username() {
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("sarath");
		
		
	}

	@And("Enter the Password")
	public void enter_the_Password() {
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("1234");
	   
	}

	@And("Click the Login button")
	public void click_the_Login_button() {
		WebElement buttonLogin = driver.findElement(By.name("login"));
		buttonLogin.click();
	    
	}

	@Then("User validates the Facebook Successfull Login")
	public void user_validates_the_Facebook_Successfull_Login() {
		String title = driver.getTitle();
		boolean contains = title.contains("Facebook");
		Assert.assertTrue(contains);
		System.out.println("passed the facebook");
		
	    
	}

	



}
