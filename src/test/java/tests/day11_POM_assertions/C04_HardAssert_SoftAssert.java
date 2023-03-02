package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {

    @Test
    public void hardAssertionTesti(){
        Assert.assertTrue(15>8);
        Assert.assertFalse(7==8);
        Assert.assertEquals(5,5);
        Assert.assertNotEquals(4,6);
    }

    @Test
    public void SoftAssertionTesti(){
        /*
           JUnit'teki Assert class'ı TestNG'de de vardır
           Ancak bir test method'unda birden fazla failed varsa
           ilk failed olan assertion'da çalışmayı durdurup exception fırlattığından
           tüm hatayı bir defada görüp hepsini düzeltme şansımız olmaz.

           TestNG bunun için bir alternatif oluşturmuş
           Bu alternatifte Assert class'ındaki static method'ları kullanmak yerine
           SoftAssert class'ından bir obje oluşturup o obje üzerinden
           istediğimiz testleri yapıyoruz.

           SoftAssert objesi ile yapılan assertionlar failed olsa da testimiz
           çalışmaya devam eder

           Ancak testlerin sonucunu görmemiz gerekir, görmek istediğimizde
           softAssert.assertAll() ile tüm yaptığı testleri raporlamasını söyleyebiliriz.

           AssertAll() method'unun çalıştığı satırda exception olabilir.

         */
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(5>8,"true testi failed");
        softAssert.assertFalse(8==8,"false testi failed");
        softAssert.assertEquals(5,9,"Equals testi failed");
        softAssert.assertNotEquals(6,6,"NotEquals testi failed");

        softAssert.assertAll();

    }
}
