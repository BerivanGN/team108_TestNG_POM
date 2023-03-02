package tests.day12_xmlFiles;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverSingletonPattern {

    @Test
    public void test01(){
        /*
           POM webDriver olarak Driver class'ındaki
           getDriver() method'unun kullanılması üzerine kurgulanmıştır.

           Driver.getDriver();

           Driver class'ının obje oluşturularak kullanılmasını engellemek için
           POM tasarlayanlar bir önlem koymak istemişler

           Java'da bir class'tan obje oluşturulmasını engellemek isterseniz
           SINGLETON PATTERN kullanabilirsiniz

           Singleton Pattern : Bir class'tan obje oluşturulmasını engellemek/sınırlamak için
                               kullanılan bir yöntemdir
                               Temel fikir, obje oluşturmak için kullanılan default contructor
                               yerine görünür parametresiz bir constructor oluşturup
                               Bu constractor'un access modifier'ını private yapıp kullanılmasını
                               engellemektir
         */

        //Driver objeDriver = new Driver();
        //parametresiz constructor oluşturduğumuziçin burada obje oluşturamadık



    }
}
