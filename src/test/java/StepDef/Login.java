package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    WebDriver driver;
    @Given("I open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("open sauce demo website")
    public void openSauceDemoWebsite() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @Then("user input a registered username {string}")
    public void userInputARegisteredUsername(String username) {
        driver.findElement(By.name("user-name")).sendKeys(username);
    }

    @And("user input registered password {string}")
    public void userInputRegisteredPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("user directed to home screen")
    public void userDirectedToHomeScreen() throws InterruptedException {
        driver.findElement(By.className("title")).isDisplayed();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }


}
