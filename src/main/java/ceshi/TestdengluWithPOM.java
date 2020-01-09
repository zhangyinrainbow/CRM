package ceshi;
import ceshi.denglu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestdengluWithPOM {
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
    public void testlogin() {
        denglu DL= PageFactory.initElements(driver,denglu.class);
        DL.login("C8000","password1");
    }
}
