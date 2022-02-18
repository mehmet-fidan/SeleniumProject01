package Part3;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticClass;

public class ReadMe extends BaseStaticClass {

    /*

        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 918 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

        4) Snepdeal logosuna tıklayınız.

        5) URL'in bu olduğunu doğrulayın. (https://www.snapdeal.com/)

     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.snapdeal.com/");

        WebElement keyWord = driver.findElement(By.cssSelector("input[id='inputValEnter']"));
        keyWord.sendKeys("teddy bear");

        WebElement search = driver.findElement(By.cssSelector("i[class='sd-icon sd-icon-search-under-catagory lfloat']"));
        search.click();

        WebElement text_Link = driver.findElement(By.cssSelector("span[style='color: #212121; font-weight: normal'"));
        text_Link.getText();
        System.out.println(text_Link.getText());

        WebElement snapdeal = driver.findElement(By.cssSelector("img[class='notIeLogoHeader aspectRatioEqual sdLogo cur-pointer']"));
        snapdeal.click();

        String current_Url = driver.getCurrentUrl();
        String expected_Url = "https://www.snapdeal.com/";

        Assert.assertEquals("URLs are not same",expected_Url,current_Url);

        if (expected_Url.equals(current_Url)){
            System.out.println("URLs are same");
        }

        driver.quit();


    }
}
