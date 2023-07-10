package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage
{
    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
      //Clicking on customer dropdown - text is not inspecting dont know
    By Customerdropdown=By.xpath("//a[@href='#']//i[@class='nav-icon far fa-user']");
    //clicking on customer
    By Customer=By.xpath("//a[@href='/Admin/Customer/List']//p[text()=' Customers']");

   //clicking on Add new user
   By Addnewbtn=By.xpath("//a[@class='btn btn-primary']");
    By Email=By.id("Email");
    By Password=By.id("Password");
    By Firstname=By.id("FirstName");
    By Lastname=By.id("LastName");
    By GMale=By.id("Gender_Male");
   By GFemale=By.id("Gender_Female");
    By Calendar=By.xpath("//span[@class='k-icon k-i-calendar']");
    By selectingdate=By.xpath("//tr//td//a[@title='Saturday, October 29, 2022']");
    By Manualdate=By.xpath("//label[contains(text(),\"Date of birth\")]//following::input[1]");
    By companyname=By.name("Company");
    By taxexempt=By.id("IsTaxExempt");
    By Deleting_Customerroles=By.xpath("//span[@class='k-select' and @title='delete']");
    By Clicking_Customerroles=By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']");
    By Guests_Customerroles=By.xpath("//li[text()='Guests']");
    By Administrator_Customerroles=By.xpath("//li[text()='Administrators']");
    By vendorDropdown=By.id("VendorId");
    By Savebtn=By.xpath("//button[@name='save']");


    public String getPageTitle()
    {
        return ldriver.getTitle();
    }
    //Action methods
     public void clickonCustomersMenu()
     {
         ldriver.findElement(Customerdropdown).click();
     }

    public void clickonCustomersMenuItem()
    {
        ldriver.findElement(Customer).click();
    }

   public void clickonAddnew()
   {
       ldriver.findElement(Addnewbtn).click();
   }

  public void setEmail(String email)
  {
      ldriver.findElement(Email).sendKeys(email);
  }

  public void setPassword(String password)
  {
      ldriver.findElement(Password).sendKeys(password);
  }

  public void setFirstName(String firstname)
  {
      ldriver.findElement(Firstname).sendKeys(firstname);
  }

  public void setLastName(String lastname)
  {
     ldriver.findElement(Lastname).sendKeys(lastname);
  }

    public void setGender(String gender) {
        if (gender.equals("Male"))
        {
            ldriver.findElement(GMale).click();
        }
        else if(gender.equals("Female"))
        {
            ldriver.findElement(GFemale).click();
        }

    }

   public void calendar()
   {
       ldriver.findElement(Calendar).click();
   }

   public void selectingdate() throws InterruptedException {
       Thread.sleep(3000);
       ldriver.findElement(selectingdate).click();
   }

   public void manualdate()
   {
	   ldriver.findElement(Manualdate).sendKeys("08/05/195");
   }
   
   public void companyname(String name)
   {
       ldriver.findElement(companyname).sendKeys(name);
   }

 public void taxexempt()
 {
     ldriver.findElement(taxexempt).click();
 }

 public void delete_customerroles()
 {
     ldriver.findElement(Deleting_Customerroles).click();
 }

 public void clicking_customerroles()
 {
     ldriver.findElement(Clicking_Customerroles).click();
 }

public void setCustomerRoles(String role) throws InterruptedException {
    WebElement listitem ;
    Thread.sleep(3000);
    if(role.equals("Administrators"))
    {
        listitem=ldriver.findElement(Administrator_Customerroles);
       listitem.click();

    } else if (role.equals("Guests"))
    {
        listitem= ldriver.findElement(Guests_Customerroles);
       listitem.click();
    }
    /*
     JavascriptExecutor js= (JavascriptExecutor)ldriver;
    js.executeScript("arguments[0].click();",listitem);
   */
}


 public void setManagerOfVendor(String value)
 {
     Select drp= new Select(ldriver.findElement(vendorDropdown));
     drp.selectByVisibleText(value);
 }

 public void clickOnSave()
 {
     ldriver.findElement(Savebtn).click();
 }










}
