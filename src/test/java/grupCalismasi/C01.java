package grupCalismasi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01 {

    @Test
    public void sayfaBasligi(){


        String expected="YouTube";
        String actual=Driver.getDriver().getTitle();
        Assert.assertTrue(actual.equals(expected));

    }

    @Test
    public void imgTest(){
        Driver.getDriver().get("https://www.youtube.com");
        WebElement imgResim= Driver.getDriver().findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(imgResim.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        WebElement searcBox=Driver.getDriver().findElement(By.xpath("(//input[@id='search'])"));
        Assert.assertTrue(searcBox.isEnabled());
    }
    @Test
    public void wrongTest(){
        String expected="youtube";
        String actual=Driver.getDriver().getTitle();
        Assert.assertFalse(actual.equals(expected));
    }
}
