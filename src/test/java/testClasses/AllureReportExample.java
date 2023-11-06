package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class AllureReportExamle {
    WebDriver driver;
    HomePage homePage;
    SoftAssert softAssert;
    @Test
    public void setUp (){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void  selectDateInOtherMonth(){
        homePage.ClickOnCheckInDate("Cairo Governorate, Egypt");
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInDifferentMonths(7);
        homePage.AddGuests();
        softAssert.assertTrue(homePage.getGovernorateHeader());
        softAssert.assertTrue(homePage.getDateHeader("nov 6 – 13"));
        softAssert.assertTrue(homePage.getResults());

        softAssert.assertAll();
    }

    @Test
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
