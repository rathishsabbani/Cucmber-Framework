package PageObjectModel;

import Utilities.WaitingHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public  class SearchCustomerPage
{
    public WebDriver ldriver;
    public WaitingHelper waitingHelper;

    public SearchCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        waitingHelper=new WaitingHelper(ldriver);

    }

      @FindBy(id="SearchEmail")
              @CacheLookup
       WebElement Email;


     @FindBy(id="SearchFirstName")
      @CacheLookup
    WebElement Firstname;

     @FindBy(id="SearchLastName")
    @CacheLookup
    WebElement Lastname;

     @FindBy(xpath ="//button[@id=\"search-customers\"]")
      @CacheLookup
    WebElement searchbtn;

     @FindBy(xpath = "//table[@id='customers-grid']")
@CacheLookup
    WebElement table;

     @FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
  @CacheLookup
     List<WebElement> tablerow;

     @FindBy(xpath = "//table[@id='customers-grid']//tbody//tr//td")
    @CacheLookup
   List<WebElement> tablecolumn;

     @FindBy(xpath = "//div[@class='icon-collapse']")
     @CacheLookup
     WebElement droplink;

     public void setEmail(String email)
     {   waitingHelper.WaitForElement(Email,10);
         Email.clear();
         Email.sendKeys(email);
     }

     public void FirstName(String firstname)
     {
         waitingHelper.WaitForElement(Firstname,10);
         Firstname.clear();
         Firstname.sendKeys(firstname);
     }

     public void LastName(String lastname)
     {
         waitingHelper.WaitForElement(Lastname,10);
         Lastname.clear();
         Lastname.sendKeys(lastname);
     }

     public void Searchbutton()
     {
         waitingHelper.WaitForElement(searchbtn,10);
         searchbtn.click();
     }

     public void Iconbutton()
     {
         waitingHelper.WaitForElement(searchbtn,10);
         droplink.click();
     }

    //Getting data from the table to filter them

    public int getNoOfRows()
    {
        return (tablerow.size());
    }

    public int getNoOfColumns()
    {
        return(tablecolumn.size());
    }

    public boolean searchCustomerByEmail(String email)
    {
        boolean flag=false;

        for(int i=1;i<=getNoOfRows();i++)
        {
            //taking hard coded value because we are checking table data from second column
            String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i+"]//td[2]")).getText();
            System.out.println(emailid);

            if(emailid.equals(email))
            {
                flag=true;
            }
            else
            {
                System.out.println("Alignment wrong");
            }
        }
        return  flag;
    }











}
