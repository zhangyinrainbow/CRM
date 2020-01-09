package TestSuit;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.GoodsDetailsPage;
import pageObject.SearchResultListPage;
import pageObject.HomePage;

public class TestCheckGoodsPrice  {
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
    public void checkPrice() throws InterruptedException{
        HomePage homepage= PageFactory.initElements(driver,HomePage.class);
        homepage.searchWithKeyWord("iphone");
        //进入搜索结果页面
        SearchResultListPage srlp=PageFactory.initElements(driver,SearchResultListPage.class);
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            Reporter.log(e.getMessage());
        }
        String price1=srlp.getGoodsPriceOnListPage();
        System.out.println(price1);
        srlp.clickItemImg();
        srlp.switchWindow();
        //进入商品详情页面
        GoodsDetailsPage gdp=PageFactory.initElements(driver,GoodsDetailsPage.class);
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            Reporter.log(e.getMessage());
        }
        String price2=gdp.getPriceDetailsPage();
        System.out.println(price2);
        //Assert.assertEquals(price1,price2);
        if(price1==price2){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        gdp.addGoodsToCart();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
