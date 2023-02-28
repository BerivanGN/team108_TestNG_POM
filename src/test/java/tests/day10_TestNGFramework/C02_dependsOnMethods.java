package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {
    /*
         Priority öncelik belirler ama testleri birbirine bağlamaz

         eğer bir test methodunun çalışması başka bir test methoduna bağlıysa
         bu durumda dependsOnMethods kullanmak daha güzel olur.

         dependsOnMethod ile başka bir method'a bağlı olan method'u bağımsız çalıştırmak istersek
         önce bağlı olduğu method'u çalıştırır sora kendisi çalışır.
         Ancak bu 2 method için geçerlidir, 3 method çalıştırmaz

         dependsOnMethods bir sıralama yöntemi DEĞİLDİR
         sıra bağlı olan bir method'a geldiğinde
         öncelikle bağlı olduğu method'un çalışmasını ve PASSED olmasını bekler.

         Eğer bağlı olunan method FAILED olursa
         bağlı olan method çalıştırılmaz IGNORE edilir.


       */

    // 3 test methodu oluşturun
    // 1. amazona gidip amazona gittiğimizi test edin
    // 2. Nutella aratıp sonucun Nutella içerdiğini test edin
    // 3. ilk ürüne click yapıp ürün isminin Nutella içerdiğini test edin

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }

    @Test(dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

    @Test(dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){
        amazonPage.ilkUrun.click();
        String expectedIcerik="Nutella";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.quitDriver();

    }
}
