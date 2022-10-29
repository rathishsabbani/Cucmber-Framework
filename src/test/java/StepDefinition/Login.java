package StepDefinition;

import PageObjectModel.AddCustomerPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Login extends BaseClass {

    @Before
    public void setup() throws IOException, InterruptedException {

        //For getting logs adding log properties class to our class
        logger= Logger.getLogger("nopCommerce");
        PropertyConfigurator.configure("Log4j.properties");

        //Reading properties
        configprop=new Properties();
        FileInputStream configpropfile= new FileInputStream("config.properties");
        configprop.load(configpropfile);

        //Getting the properties from config.properties

        Thread.sleep(5000);
        String browser=configprop.getProperty("browser");
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
           System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxpath"));
            driver= new FirefoxDriver();
        }
        logger.info("-------------- Launching Browser----------------");

    }
    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() throws  IOException {

        System.setProperty("webdriver.chrome.driver","E:\\CucumberFromScratch\\chromedriver.exe");
        driver=new ChromeDriver();
    lp = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void userOpensURL(String url)
    {

        logger.info("-------------- Entering URL----------------");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @And("User enters Email as {string} and Password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String password) {
        logger.info("-------------- providing login details----------------");
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {

        logger.info("-------------- clicking on login button----------------");
        lp.clickLogin();
    }

    @Then("Home Page Title should be {string}")
    public void home_page_title_should_be(String string) {
        String title = driver.getTitle();
        System.out.println(title);
        String newtitle = "Dashboard / nopCommerce administration";
        if (title.equals(newtitle)) {
            Assert.assertEquals(title, newtitle);
            System.out.println("yes title is true");
        } else {
            Assert.assertTrue(false);
            System.out.println("Fake Title");
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {

        logger.info("-------------- Logging out ----------------");
        lp.clickLogout();
    }

    @When("Page Title should be {string}")
    public void page_title_should_be(String title) {
        driver.getTitle();
    }

    @Then("close browser")
    public void close_browser() throws InterruptedException {
        driver.close();
        Thread.sleep(3000);
    }


    //Adding customer stepdefinitions here only


    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        AdCuP = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", AdCuP.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        AdCuP.clickonCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        AdCuP.clickonCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        AdCuP.clickonAddnew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("Add a new customer / nopCommerce administration", AdCuP.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomstring() + "@gmail.com";
        AdCuP.setEmail(email);
        AdCuP.setPassword("abc123");
        AdCuP.setGender("Male");
        AdCuP.setFirstName("Mukesh");
        AdCuP.setLastName("Smart");
        AdCuP.calendar();
        AdCuP.selectingdate();
        AdCuP.companyname("BusyQA");
        AdCuP.taxexempt();
        // AdCuP.delete_customerroles();
        //  AdCuP.clicking_customerroles();
        // AdCuP.setCustomerRoles("Guest");
        Thread.sleep(3000);
        AdCuP.setManagerOfVendor("Vendor 2");


    }

    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        AdCuP.clickOnSave();
        Thread.sleep(3000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }

    //verifying with customer mail id and name-------------------------------


    @When("Enter customer Email")
    public void enter_customer_email() {
        searchcustomer = new SearchCustomerPage(driver);
      //  searchcustomer.Iconbutton();
        searchcustomer.setEmail("victoria_victoria@nopCommerce.com");

    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchcustomer.Searchbutton();
        Thread.sleep(3000);
    }

    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        //searching by using search customer method
        boolean status = searchcustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

        Assert.assertEquals(true, status);
    }

//----------------------Entering First and Last Name--------
    @And("Enter customer FirstName")
    public void enterCustomerFirstName()
    {
        searchcustomer = new SearchCustomerPage(driver);
        searchcustomer.FirstName("Victoria");
    }


    @And("Enter customer LastName")
    public void enterCustomerLastName()
    {
        searchcustomer = new SearchCustomerPage(driver);
        searchcustomer.LastName("Terces");
    }





}