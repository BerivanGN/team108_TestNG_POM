package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {
    /*
        Smoke Test
        Regression Test
        EndToEnd (E2E)

        Test Suite : Birden fazla Test'in biraraya getirilmesidir

        Test : Bir amaç için bir araya getirilmiş test method'ları class'ları
               ve/veya package'leri içerir


               Test Hiyerarşisi :
               -Suite
               -Test
               -groups, packages, classes, methods


               içinde 1 class ve class'in sahip olduğu
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }
    @BeforeClass
    public void beforClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }
    @Test
    public void test01(){System.out.println("test1");}
    @Test
    public void test02(){
        System.out.println("test2");
    }
    @Test
    public void test03(){
        System.out.println("test3");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("after suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterClass (groups = "smoke")
    public void afterClasses(){
        System.out.println("After classes");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
}
