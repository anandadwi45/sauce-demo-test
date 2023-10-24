package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Logout {
    WebDriver driver;

    @Given("user is logged in to homepage")
    public void userIsLoggedInToHomepage() throws InterruptedException {
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

    @Then("click burger menu icon")
    public void clickBurgerMenuIcon() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
    }

    @Then("click logout")
    public void clickLogout() {
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    }

    @Then("login page displayed")
    public void loginPageDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).isDisplayed();
        driver.close();
        driver.quit();
    }
}
