package tests.day13_crossBrowserTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DataProviderNegatifLoginTesti {

    /*
        Verilen 5 farklı username ve password'u kullanarak
        qalitydemy uygulamasın girilemediğini test edin

     */
    @DataProvider
    public static Object[][] kullanicilar() {
        String[][] kullaniciList={{"Berivan","12345"},
                                  {"Mehmet","34567"},
                                  {"Sevilay","67890"},
                                  {"Enver","56789"},
                                  {"Deniz","54321"}};

        return kullaniciList;
    }

    @Test(dataProvider = "kullanicilar")
    public void negatifLogin2(String Username, String Password){
        QdPage qdPage = new QdPage();
        ReusableMethods.bekle(4);
        qdPage = new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        qdPage.loginLinki.click();
        qdPage.emailKutusu.sendKeys(Username);
        qdPage.passwordKutusu.sendKeys(Password);
        ReusableMethods.bekle(3);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }
}
