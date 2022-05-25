package api.cucumber.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PostSteps {
    WebDriver driver=null;
    @Given("^Open the browser$")
    public void open_the_browser()  {
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            System.out.println("Successfully opened chrome Browser");
        }
        else {
            System.out.println("Failed to open chrome Browser");
        }
    }

    @When("^I open Challenging Dom website$")
    public void i_open_challenging_dom_website()  {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        System.out.println(" Successfully open Challenging Dom website ");
    }

    @And("^Verify Web Page Title as Challenging DOM is displayed on UI$")
    public void verify_web_page_title_as_challenging_dom_is_displayed_on_ui()  {
        if(driver.findElement(By.xpath("//h3[normalize-space()='Challenging DOM']")).isDisplayed()) {
            System.out.println("Successfully verified Page Title as- Challenging DOM");
        } else {
            System.out.println("Challenging DOM is not displayed on UI");
        }

    }

    @Then("Verify table header on webPage")
    public void verifyTableHeaderOnWebPage() {
        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Lorem']")).getText(),"Lorem");
        System.out.println("Column Header - Lorem displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Ipsum']")).getText(),"Ipsum");
        System.out.println("Column Header - Ipsum displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Dolor']")).getText(),"Dolor");
        System.out.println("Column Header - Dolor displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Sit']")).getText(),"Sit");
        System.out.println("Column Header - Sit displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Amet']")).getText(),"Amet");
        System.out.println("Column Header - Amet displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Diceret']")).getText(),"Diceret");
        System.out.println("Column Header - Diceret displayed successfully.");

        Assert.assertEquals(driver.findElement(By.xpath("//th[normalize-space()='Action']")).getText(),"Action");
        System.out.println("Column Header - Action displayed successfully.");

    }

    @And("Verify edit  button in the Action column")
    public void verifyEditButtonInTheActionColumn() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]")).getText(),"edit");
        System.out.println("Successfully verified edit button on web Page");
    }

    @And("Verify delete  button in the Action column")
    public void verifyDeleteButtonInTheActionColumn() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]")).getText(),"delete");
        System.out.println("Successfully verified delete button on web Page");
    }

    @Then("Verify three buttons on UI in blue Red and Green")
    public void verifyButtons () {
        WebElement element_Button1 = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button']"));
        String button_ID_beforeClick = element_Button1.getAttribute("id");
        System.out.println("Successfully verified 1st button on web Page with Text as - " + element_Button1.getText() + "   and ID as " + element_Button1.getAttribute("id"));
        element_Button1.click();
        String button_ID_afterClick = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button']")).getAttribute("id");
        Assert.assertNotEquals(button_ID_beforeClick, button_ID_afterClick);
        System.out.println("After click on 1st button on web Page with displayed Text as - " + driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button']")).getText()+ "  and ID as " + button_ID_afterClick);

        WebElement element_Button2 = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button alert']"));
        button_ID_beforeClick = element_Button2.getAttribute("id");
        System.out.println("Successfully verified 2nd button on web Page with Text as - " + element_Button2.getText() + "   and ID as " + element_Button2.getAttribute("id"));
        element_Button2.click();
        button_ID_afterClick = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button alert']")).getAttribute("id");
        Assert.assertNotEquals(button_ID_beforeClick, button_ID_afterClick);
        System.out.println("After click on 2nd button on web Page with displayed Text as - " + driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button alert']")).getText()+ "  and ID as " + button_ID_afterClick);

        WebElement element_Button3 = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button success']"));
        button_ID_beforeClick = element_Button3.getAttribute("id");
        System.out.println("Successfully verified 2nd button on web Page with Text as - " + element_Button3.getText() + "   and ID as " + element_Button3.getAttribute("id"));
        element_Button3.click();
        button_ID_afterClick = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button success']")).getAttribute("id");
        Assert.assertNotEquals(button_ID_beforeClick, button_ID_afterClick);
        System.out.println("After click on 3rd button on web Page with displayed Text as - " + driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button success']")).getText()+ "  and ID as " + button_ID_afterClick);

    }

    @Then("^Close the browser$")
    public void close_the_browser()  {
        driver.quit();
    }

}
