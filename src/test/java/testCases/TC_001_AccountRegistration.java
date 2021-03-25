package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
@Test(groups= {"regression","master"})
public void test_account_Registration()
{
	logger.info(" Starting TC_001_AccountRegistration ");
	
	try
	{
		
	driver.get(rb.getString("appURL"));
	driver.manage().window().maximize();
	
	 HomePage hp=new HomePage(driver);
	 logger.info("HomePage is displaed");
	 
	 hp.clickMyAccount();
	 logger.info("Clicked on My Account");
	 
	 hp.clickRegister();
	 logger.info("Clicked on Register ");
	 
	 AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	 
	 regpage.setFirstName("Smith");
	 logger.info("Provided First Name");
	 
	 regpage.setLastName("Keny");
	 logger.info("Provided Last Name ");
	 
	 regpage.setEmail(randomestring()+"@gmail.com");
	 logger.info("Provided Email ");
	 
	 regpage.setTelephone("65656765");
	 logger.info("Provided Telephone ");
	 
	 regpage.setPassword("abcxrz");
	 logger.info("Provided Password ");
	 
	 regpage.setConfirmPassword("abcxrz");
	 logger.info("Provided Confrmed Password ");
	 
	 regpage.setPrivacyPolicy();
	 logger.info("Set Privacy Policy ");
	 
	 regpage.clickContinue();
	 logger.info("Clicked on Continue ");
	 
	 String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
			//if(confmsg.equals("Your Account Has Been Createdd!!"))	//test fail
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "test_account_Registration");  //Capturing screenshot
			logger.error("Account Registration Failed ");
			Assert.assertTrue(false);
		}
}
       catch(Exception e)
       {
    	   logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration ");
}



}
