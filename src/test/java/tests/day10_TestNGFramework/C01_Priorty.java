package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priorty {
    /*
       TestNG test metodlarını çalıştırırken standart olarak harf sıralamasına bakar
       ancak TestNG sıralamayı bizim kontrol etmemize olanak tanır

       istediğimiz test method'una istediğimiz önceliği priority ile tanımlayabiliriz
       selenium test ethodlarını priorty'si küçükten büyüğe olacak şekilde çalıştırır

       priority değeri aynı olan test methodları harf sırasına göre çalışır

       priority değeri yazılmazsa default olarak priority=0 kabul edilir.
     */
    @Test(priority = 50)
    public void amazonTesti(){
        // amazon anasayfaya gidip amazona gittiğimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");

        // url amazon içeriyor mu test edelim
        String expectedIcerik = "amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }

    @Test(priority = 30)
    public void wiseTesti(){
        // wisequarter'a gidip wisequarter'a gittiğimizi test edelim
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }

    @Test(priority = 20)
    public void youtubeTesti(){
        // youtube ana sayfaya gidip youtube'a gittiğimizi test edelim
        Driver.getDriver().get("https://www.youtube.com");

        String expectedIcerik = "youtube";
        String actualUrl = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
}
