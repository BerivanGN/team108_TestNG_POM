package tests.day11_POM_assertions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {
    // qd anasayfaya gidin
    // geçerli kullanıcı adı ve password ile giriş yapın
    // başarılı bir şekilde giriş yapıldıgını test edin

    @Test (groups = "smoke")
    public void pozitifLoginTesti(){
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();

        //login linkine tıklayın
        QdPage qdPage = new QdPage();
        qdPage.loginLinki.click();

        // geçerli kullanıcı adı ve password ile giriş yapın
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        // başarılı bir şekilde giriş yapıldıgını test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        Driver.closeDriver();
    }
}
