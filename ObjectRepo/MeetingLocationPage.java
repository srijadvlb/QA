package ObjectRepo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author srija
 */
public class MeetingLocationPage {

    private WebDriver driver;

    public MeetingLocationPage() {
    }

    public MeetingLocationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Date now = new Date();
    SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
    JavascriptExecutor jse;

    @FindBy(xpath = "//span[@ng-if='!linkName']")
    WebElement firstSearchResult;

    @FindBy(xpath = "//li[@class='hours-list-item']/div/div[@class='hours-list-item-day']")
    List<WebElement> todayDay;

    @FindBy(xpath = "//li[@class='hours-list-item']/div/div[@class='hours-list-item-hours']")
    List<WebElement> todayHours;

    @FindBy(xpath = "//div[@class='schedule-detailed-day-meetings']")
    List<WebElement> instructorSchedule;

    @FindBy(xpath = "//div[@class='schedule-detailed-day-label']")
    List<WebElement> day;

    public String firstSearchResultText() throws InterruptedException {
        Thread.sleep(1000);
        return firstSearchResult.getText();
    }

    public void printTodayHours() {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,750)", "");

        for (int i = 0; i < todayDay.size(); i++) {
            if (todayDay.get(i).getText().equals(simpleDateformat.format(now).toUpperCase())) {
                System.out.println("The working hours of today would be \n " + todayHours.get(i).getText());
            }
        }

    }

    public void printMeetings(String nameOfDay) {
        HashMap<String, Integer> instructor = new HashMap<String, Integer>();
        String data = null;
        for (int i = 0; i < day.size(); i++) {
            if (day.get(i).getText().equals(nameOfDay)) {
                data = instructorSchedule.get(i).getText();
            }
        }
        String[] instructorList = data.split("\n");
        for (int i = 0; i < instructorList.length; i++) {
            if (i % 2 != 0) {
                if (instructor.get(instructorList[i]) == null) {
                    instructor.put(instructorList[i], 1);
                } else {
                    instructor.put(instructorList[i], instructor.get(instructorList[i]) + 1);
                }
            }
        }

        for (String person : instructor.keySet()) {
            System.out.println("Person :" + person + ":" + instructor.get(person));
        }

    }

}
