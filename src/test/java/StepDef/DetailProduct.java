package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DetailProduct {
    WebDriver driver;

    @Given("user is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.className("title")).isDisplayed();
        Thread.sleep(1000);
    }

    @Then("click a product")
    public void clickAProduct() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

    @Then("detail product displayed")
    public void detailProductDisplayed() {
        driver.findElement(By.name("back-to-products")).isDisplayed();
        driver.close();
        driver.quit();
    }



}
