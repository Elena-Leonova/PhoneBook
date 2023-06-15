package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

//        @Test
//        public void registrationPositiveTest() {
//           int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//            // open login form
//            wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//            // fill login form
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//            emailInput.click();
//            emailInput.clear();
//            emailInput.sendKeys("lena.postrash" + i + "@gmail.com");
//            WebElement passwInput = wd.findElement(By.xpath("//input[2]"));
//            passwInput.click();
//            passwInput.clear();
//            passwInput.sendKeys("Mynameislena1!");
//            // click on login button
//            wd.findElement(By.xpath("//button[2]")).click();
//
//            // Assert
//            Assert.assertTrue(wd.findElements(By.xpath("//a[@class='active']")).size() > 0);
//
//
//        }


    @Test
    public void registrationNegativeTestWrongEmail() {
         int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "lena.leonova_" + i + "gmail.com", password = "Mynameislena1!";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

    }

    @Test
    public void registrationNegativeTestWrongPassword(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
          String email = "lena.postrash" + i + "@gmail.com" , password = "lena" ;
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
    }



}