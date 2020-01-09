package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDaiHuaiZhang {
    WebDriver driver;
    @BeforeClass
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://cstest.crm.bmcc.com.cn:8777/web-sso/?referer=http%3A%2F%2Fcstest.crm.bmcc.com.cn%3A8777%2Fweb-ngboss%2F%3Fservice%3Dpage%2Fngboss.frame.pc.common.Main%26listener%3Dinit");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void checkDaiHuaiZhang() throws InterruptedException{
        CRMLogin crmLogin= PageFactory.initElements(driver,CRMLogin.class);
        crmLogin.crmHomePage("C8000","password1");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //进入homepage
        CRMHomePage crmHomePage=PageFactory.initElements(driver,CRMHomePage.class);
        crmHomePage.daiHuaiZhang("呆坏账缴费");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name, 'navframeName')]")));
        //进入呆坏账界面
        CRMDaiHuaiZhang crmDaiHuaiZhang=PageFactory.initElements(driver,CRMDaiHuaiZhang.class);
        crmDaiHuaiZhang.searchList("17810015695");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            Reporter.log(e.getMessage());
        }
        String test1=crmDaiHuaiZhang.getQueryList();
        String test2="21100002381077";
        if (test1==test2){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }




    }
    @AfterClass
    public void tearDown() throws InterruptedException{

        try{
            Thread.sleep(3000);
        }catch(Exception e){
            Reporter.log(e.getMessage());
        }
    }
}
