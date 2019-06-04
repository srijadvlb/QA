package ObjectRepo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author srija
 */
public class FindWWStudiosPage {
    
    private WebDriver driver;
    
    @FindBy(id="meetingSearch")
    WebElement enterLocation;
    
    @FindBy(xpath="//span[@ng-if='!linkName']")
    List<WebElement> title;
    
    @FindBy(xpath="//div[@ng-if='showDistance']")
    List<WebElement> distance;
    
    public FindWWStudiosPage() 
    {
      
    }

    public FindWWStudiosPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String titleOfWebPage()
    {
        return driver.getTitle();
    }
    
     public void findStudio(String zipcode)
    {
        enterLocation.sendKeys(zipcode);
        enterLocation.sendKeys(Keys.ENTER);      
    }
     
     public String distanceStudio() throws InterruptedException
     {
         Thread.sleep(3000);
         return distance.get(0).getText();
     }
     
     public String firstStudioDisplayed() throws InterruptedException
     {
         Thread.sleep(3000);
         return title.get(0).getText();
     }
     
     public MeetingLocationPage clickFirstStudioDisplayed()
     {
         title.get(0).click();
         return  new MeetingLocationPage(driver);             
     }
}
