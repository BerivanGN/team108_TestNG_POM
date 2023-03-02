package tests.day12_xmlFiles;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    // qd anasayfaya gidin
    // geçerli kullanıcı adı ve password ile giriş yapın
    // başarılı bir şekilde giriş yapıldıgını test edin

    @Test
    public void pozitifLoginTesti(){
        extentTest = extentReports.createTest("pozitifLoginTesti","gecerli bilgilerle giris yapilabilmeli");

        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        extentTest.info("Qalitydemy anasayfaya gidildi");

        //login linkine tıklayın
        QdPage qdPage = new QdPage();
        qdPage.loginLinki.click();
        extentTest.info("Ilk login linkine tıklandı");

        // geçerli kullanıcı adı ve password ile giriş yapın
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("Geçerli email yazıldı");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("Geçerli password yazıldı");
        qdPage.loginButonu.click();
        extentTest.info("Login butonuna basıldı");


        // başarılı bir şekilde giriş yapıldıgını test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("Başarılı şekilde giriş yapıldığı test edildi");

    }
}
