import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTest extends TestBase {
//    WebDriver wd;

    @BeforeMethod
    public void precondition() {
     if(isLogged()){
         logout();
     }
    }
//        public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Test
    public void loginPositiveTest() {
        // open login form
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("lena.postrash@gmail.com");
        WebElement passwInput = wd.findElement(By.xpath("//input[2]"));
        passwInput.click();
        passwInput.clear();
        passwInput.sendKeys("Mynameislena1!");
        // click on login button
        wd.findElement(By.xpath("//button[1]")).click();

        // Assert
       // Assert.assertTrue(wd.findElements(By.xpath("//a[@class='active']")).size() > 0);
       // pause(3000);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @Test
    public void loginNegativeTestWrongEmail() {
        String email = "lena.postrashgmail.com", password = "Mynameislena1!";
        // int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        // open login form
        //wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        //click(By.xpath("//*[text()='LOGIN']"));
        openLoginRegistrationForm();
        // fill login form
        fillLoginRegistrationForm(email, password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("lena.postrashgmail.com");

//        WebElement passwInput = wd.findElement(By.xpath("//input[2]"));
//        passwInput.click();
//        passwInput.clear();
//        passwInput.sendKeys("Mynameislena1!");
        // click on login button
        submitLogin();
        //wd.findElement(By.xpath("//button[1]")).click();

        // Assert
    }

    @AfterMethod
    public void tearDown() {
        //  wd.quit();
    }

}
