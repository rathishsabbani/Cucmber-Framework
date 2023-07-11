package GenericLibraries;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectModel.AddCustomerPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchCustomerPage;


import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;


public class BaseClass
{
     public WebDriver driver;
     public LoginPage lp;
     public AddCustomerPage AdCuP;
     public SearchCustomerPage searchcustomer;
     public   Logger logger;

    public Properties configprop;
     //created for generating string for unique email id
     public static String randomstring()
     {
    	 
          String generatedString1= RandomStringUtils.randomAlphabetic(5);
         return(generatedString1);
     }
     public void Executor(WebElement element)
     {
    	 JavascriptExecutor jse= (JavascriptExecutor)driver;
    	 
    	 jse.executeScript("arguments[0].scrollIntoView();" , element);
     }

}
