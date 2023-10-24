package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Checkout {
    WebDriver driver;

    @Given("user is logged in and select a product")
    public void userIsLoggedInAndSelectAProduct() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

    @Then("click add to cart")
    public void clickAddToCart() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("click cart icon")
    public void clickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("cart page displayed")
    public void cartPageDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
    }

    @Then("click checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.name("checkout")).click();
    }

    @Then("input first name {string}")
    public void inputFirstName(String first_name) {
        driver.findElement(By.name("firstName")).sendKeys(first_name);
    }

    @And("input last name {string}")
    public void inputLastName(String last_name) {
        driver.findElement(By.name("lastName")).sendKeys(last_name);
    }

    @And("input postal code {string}")
    public void inputPostalCode(String postal) {
        driver.findElement(By.name("postalCode")).sendKeys(postal);
    }

    @Then("click continue")
    public void clickContinue() {
        driver.findElement(By.name("continue")).click();
    }

    @Then("checkout overview displayed")
    public void checkoutOverviewDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
    }

    @Then("click finish")
    public void clickFinish() {
        driver.findElement(By.name("finish")).click();
    }

    @Then("checkout complete displayed")
    public void checkoutCompleteDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).isDisplayed();
        driver.close();
        driver.quit();
    }

    @Then("error message displayed")
    public void errorMessageDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")).isDisplayed();
        driver.close();
        driver.quit();
    }
}
