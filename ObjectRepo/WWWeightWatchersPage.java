/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author srija
 */
public class WWWeightWatchersPage {
    
    private WebDriver driver;
    
    public WWWeightWatchersPage() {
    }

    public WWWeightWatchersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(linkText="Find a Studio")
    WebElement studio;
    
    public String titleOfWebPage()
    {
        return driver.getTitle();
    }
    
    public FindWWStudiosPage clickFindStudio()
    {
        studio.click();
        return new FindWWStudiosPage(driver);
    }
}
