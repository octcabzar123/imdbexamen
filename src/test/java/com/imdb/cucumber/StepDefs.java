package com.imdb.cucumber;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imdb.tests.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs extends BaseTest {

//    @Test
//    public void testRegisterNewUser() {
//        home.navegar("https://imdb.com");
//        home.verificarPagina();
//        login.comenzarRegistro();
//        createAccount.crearUsuario("user", "email", "password");
//    }
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Before
	public void before() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:/Users/kzgk290/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().setSize(new Dimension(900, 550));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @Given("^I go to IMDB page$")
    public void i_go_to_imdb_page()  {
        driver.navigate().to("https://imdb.com");
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_img")));
        assertTrue(logo.isEnabled());
    }

    @Then("^I go to the Login page$")
    public void i_go_to_the_login_page()  {
    	driver.findElement(By.cssSelector("[href='/registration/signin?ref=nv_generic_lgin']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item.create-account"))).click();;
    }

    @When("My email is {word}, my pass is {word} y my username is {word}")
    public void my_email_is_equipo1testmailinatorcom_my_pass_is_1234test_y_my_username_is_equipo1test(String user, String pass, String equipo)  {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        WebElement username = driver.findElement(By.id("ap_customer_name"));
        WebElement password = driver.findElement(By.id("ap_password"));
        WebElement checkPass = driver.findElement(By.id("ap_password_check"));
        username.sendKeys(equipo);
        email.sendKeys(user);
        password.sendKeys(pass);
        checkPass.sendKeys(pass);
        driver.findElement(By.id("continue")).click();
    }

    @And("^I create a new user in IMDB$")
    public void i_create_a_new_user_in_imdb()  {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_img")));
    }

    @After
    public void tearDownTest() {
//        driver.quit();
    }
}
