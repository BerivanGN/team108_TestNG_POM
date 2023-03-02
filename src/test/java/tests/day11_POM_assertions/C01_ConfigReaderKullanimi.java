package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigReaderKullanimi {
    // amazon anasayfaya gidelim
    // Nutella için arama yapalım
    // arama sonuçlarının Nutella içerdiğini test edelim.

    @Test
    public void test01(){
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Test datası olarak verilen kelime(Nutella) için arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        // arama sonuçlarının aradığımız test datasını içerdiğini test edelim.
        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSoucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSoucYazisi.contains(expectedIcerik));
        Driver.closeDriver();

    }
}
