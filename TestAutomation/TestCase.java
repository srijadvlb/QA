package TestAutomation;

import DataValues.TestConstant;
import ObjectRepo.FindWWStudiosPage;
import ObjectRepo.WWWeightWatchersPage;
import ObjectRepo.MeetingLocationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase {

    public WebDriver driver = null;

    @Test(priority = 1)
    public void Test1() throws InterruptedException {

        //Step 1 Navigate to URL
        System.setProperty("webdriver.chrome.driver", TestConstant.chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestConstant.url);
        WWWeightWatchersPage _WWWeightWatchers = new WWWeightWatchersPage(driver);

        //Step 2 Validate title of page
        Assert.assertEquals(TestConstant.title1, _WWWeightWatchers.titleOfWebPage());

        //Step 3 Click on Find a Studio
        FindWWStudiosPage _findWWStudios = _WWWeightWatchers.clickFindStudio();

        //Step 4 Validate title of page
        Assert.assertEquals(TestConstant.title2, _findWWStudios.titleOfWebPage());

        //Step 5 Enter Zipcode
        _findWWStudios.findStudio(TestConstant.zipCode);

        //Step 6 Print first studio and distance
        System.out.println("The title of first returned result is " + _findWWStudios.firstStudioDisplayed());
        System.out.println("The distance is " + _findWWStudios.distanceStudio());

        //Step 7 Click on first studio
        String titleFirstElement = _findWWStudios.firstStudioDisplayed();
        MeetingLocationPage meetingLocation = _findWWStudios.clickFirstStudioDisplayed();
        Assert.assertEquals(titleFirstElement, meetingLocation.firstSearchResultText());  //Verify name

        //Step 8 Print today's hours
        meetingLocation.printTodayHours();

        //Step 9 Print meetings
        meetingLocation.printMeetings(TestConstant.nameOfDay);

        driver.quit();
    }

}
