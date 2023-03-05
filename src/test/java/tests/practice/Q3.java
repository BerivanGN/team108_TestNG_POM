package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {

    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high (Fiyatı düşükten yükseğe seçin)
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     * (Soft Assert ile ürün fiyatlarının düşükten yükseğe doğru sıralandığını doğrulayın)
     */

    SoftAssert softAssert = new SoftAssert();
    WebElement dropdown ;


    @BeforeTest
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemo"));

        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.id("login-button")).click();

    }

    @Test
    public void saucedemoTest1(){
        dropdown = Driver.getDriver().findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Price (low to high)");


        String exp = "Price (low to high)";
        String act = Driver.getDriver().findElement(By.className("active_option")).getText();


        softAssert.assertEquals(act,exp,"Aktif seçenekteki yazı expected datadan farklı");
        softAssert.assertAll();
    }

    @Test
    public void saucedemoTest2(){
        dropdown = Driver.getDriver().findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Price (low to high)");

        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.className("inventory_item_price"));
        ArrayList<Double> fiyatlarDouble = new ArrayList<>();

        for (WebElement fiyat:fiyatlar
             ) {
            String fiyatStr = fiyat.getText().replaceAll("^\\D","");
            fiyatlarDouble.add(Double.valueOf(fiyatStr));
        }
        System.out.println(fiyatlarDouble);
        ArrayList<Double> kontrolList= new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolList);

        softAssert.assertEquals(fiyatlarDouble,kontrolList,"Sıralama gerçeleşmemiştir");
        softAssert.assertAll();
    }


}
