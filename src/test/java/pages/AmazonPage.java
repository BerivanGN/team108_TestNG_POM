package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
       Pages class'ları sürekli kullandığımız locate'leri
       tekrar tekrar locate etmek zorunda kalmaktan kurtulmak için kullanılır

       Her pages class'ı Driver class'ında oluşturulan Driver'ı kullanır

       @FindBy notasyonunun Driver class'ındaki webDriver'ı kullanabilmesi için
        bu class'a tanıtmamız gerekiyor

        Bunun için her pages sayfası ilk oluşturulduğunda
        başına parametresiz bir constructor oluşturup
        içerisinde driver'ı bu class'a tanıtıyoruz.
     */

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public  WebElement aramaSonucElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimElementi;


}

