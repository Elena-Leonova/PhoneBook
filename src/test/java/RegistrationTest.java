import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase{
        WebDriver wd;

//        @BeforeMethod
//        public void init() {
//            wd = new ChromeDriver();
//            wd.navigate().to("https://telranedu.web.app/home");
//            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }

        @Test
        public void registrationPositiveTest() {
           int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            // open login form
            wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
            // fill login form
            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys("lena.postras" + i + "h@gmail.com");
            WebElement passwInput = wd.findElement(By.xpath("//input[2]"));
            passwInput.click();
            passwInput.clear();
            passwInput.sendKeys("Mynameislena1!");
            // click on login button
            wd.findElement(By.xpath("//button[1]")).click();

            // Assert
            Assert.assertTrue(wd.findElements(By.xpath("//a[@class='active']")).size() > 0);


        }

    @Test
    public void registrationNegativeTestWrongEmail() {
        // int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "lena.leonovagmail.com", password = "Mynameislena1!";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();

    }

    @Test
    public void registrationNegativeTestWrongPassword(){
          String email = "lena.postrash@gmail.com" , password = "lena" ;
          openLoginRegistrationForm();
          fillLoginRegistrationForm(email,password);
          submitRegistration();
    }

}