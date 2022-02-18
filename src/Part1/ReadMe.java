package Part1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseStaticClass;
import org.junit.Assert;

import java.util.Locale;

public class ReadMe extends BaseStaticClass {

    /*

        1) Bu siteye gidin. ->  http://demoqa.com/text-box

        2) Full Name kısmına "Automation" girin.

        3) Email kısmına "Testing" girin.

        4) Current Address kısmına "Testing Current Address" girin.

        5) Permanent Address kısmına "Testing Permanent Address" girin.

        6) Submit butonuna tıklayınız.

        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
		ve Ekrana "**** Name Onaylandi ****" yazdirin. 
		degilse "**** Name Yanlis Girildi ****"

        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
		ve Ekrana "**** Email Onaylandi ****" yazdirin. 
		degilse "**** Email Yanlis Girildi ****"

     */

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demoqa.com/text-box");

        WebElement name = driver.findElement(By.cssSelector("input[id='userName']"));
        name.sendKeys("Automation");

        WebElement e_Mail = driver.findElement(By.cssSelector("input[id='userEmail']"));
        e_Mail.sendKeys("Testing@gmail.com");

        WebElement current_Address = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        current_Address.sendKeys("Testing Current Address");
        Thread.sleep(3000);
        WebElement permanent_Address = driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", permanent_Address);
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);
        permanent_Address.sendKeys("Testing Permanent Address");

        WebElement submit = driver.findElement(By.cssSelector("button[id='submit']"));
        submit.click();

        WebElement controlName = driver.findElement(By.cssSelector("#name"));

        Assert.assertTrue("***Name onaylanmadi***", controlName.getText().contains("Automation"));

         if (controlName.getText().toLowerCase().contains("automation")){
            System.out.println("***Name onaylandi***");
        }

        WebElement control_Email = driver.findElement(By.cssSelector("p[id='email']"));

         Assert.assertTrue("***Email onaylanmadi***",control_Email.getText().contains("Testing"));
        if (control_Email.getText().toLowerCase().contains("testing")){
            System.out.println("***Email onaylandi***");
        }
      driver.close();

    }
}
