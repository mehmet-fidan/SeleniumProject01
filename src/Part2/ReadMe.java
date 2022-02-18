package Part2;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticClass;

public class ReadMe extends BaseStaticClass {

    /*
        1) Bu siteye gidin. -> https://demo.applitools.com/

        2) Username kısmına "krafttechno@gmail.com" girin.

        3) Password kısmına "techno123." girin.

        4) "Sign in" buttonunan tıklayınız.

        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.(Assert kullanın )

        6) URL'in bu olduğunu doğrulayın. -> https://demo.applitools.com/app.html   (Assert kullanın )
     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demo.applitools.com/");

        WebElement userName = driver.findElement(By.cssSelector("#username"));
        userName.sendKeys("krafttechno@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("techno123.");
        Thread.sleep(2000);
        WebElement sign_In = driver.findElement(By.id("log-in"));
        sign_In.click();

        WebElement text_Control = driver.findElement(By.id("time"));

        String text_Actual = text_Control.getText();
        String expected_Text = "Your nearest branch closes in: 30m 5s";

        Assert.assertEquals("Texts are not same", expected_Text, text_Actual);

        if (text_Actual.equals(expected_Text)) {
            System.out.println("Text are same");
        }

        String current_Url = driver.getCurrentUrl();
        String expected_Url = "https://demo.applitools.com/app.html";

        Assert.assertEquals("Url adresses are not rigt",expected_Url,current_Url);

        if (current_Url.equals(expected_Url)) {
            System.out.println("Url adresses are same.....");
        }

        driver.quit();

    }
}
