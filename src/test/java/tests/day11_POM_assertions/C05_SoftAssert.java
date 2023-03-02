package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {

    // Genel olarak
    // test edin denirse ===>>> hardAssert
    // doğrulayın denirse ===>>> softAssert kastedilir.

    // Amazon anasayfaya gidip doğru sayfaya gittiğimizi DOĞRULAYIN(verify)
    // Nutella için arama yapıp sonuçların nutella içerdiğini DOĞRULAYIN
    // ilk ürüne tıklsyıp ürün isminde Nutella geçtiğini DOĞRULAYIN


    @Test (groups = "smoke")
    public void amazonTesti(){

        // Amazon anasayfaya gidip doğru sayfaya gittiğimizi DOĞRULAYIN(verify)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik));

        // Nutella için arama yapıp sonuçların nutella içerdiğini DOĞRULAYIN
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        expectedIcerik="Nutella";
        String actualAramaSonucYazisi = amazonPage.aramaSonucElementi.getText();

        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        // ilk ürüne tıklsyıp ürün isminde Nutella geçtiğini DOĞRULAYIN
        amazonPage.ilkUrun.click();
        expectedIcerik="Nutella";
        String actualIlkUrunIsim = amazonPage.ilkUrunIsimElementi.getText();

        softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik));

        softAssert.assertAll();
        Driver.closeDriver();


    }
}
