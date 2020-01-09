package ceshi;

import java.util.List;
        import java.util.concurrent.TimeUnit;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.*;


        public class testngceshi {
        WebDriver driver;
        @BeforeClass
        public void  beforeClass(){
            System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

            //初始化一个chrome浏览器实例，实例名称叫driver
            driver = new ChromeDriver();
            //最大化窗口
            driver.manage().window().maximize();
            //设置隐性等待时间
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
       @Test   //(dependsOnMethods = {""})   (enabled=false)
        public void Open(){
           // get()打开一个站点
           driver.get("http://cstest.crm.bmcc.com.cn:8777/web-sso/?referer=http%3A%2F%2Fcstest.crm.bmcc.com.cn%3A8777%2Fweb-ngboss%2F%3Fservice%3Dpage%2Fngboss.frame.pc.common.Main%26listener%3Dinit");
           //getTitle()获取当前页面title的值
           System.out.println("当前打开页面的标题是： "+ driver.getTitle());
           driver.findElement(By.id("UserAccount")).sendKeys("C8000");
           driver.findElement(By.id("UserPwd")).sendKeys("password1");
           driver.findElement(By.xpath("//*[@id=\"fm_locallogin\"]/ul/li[3]/button")).click();
           driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);

           try{
               Thread.sleep(10000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }

           driver.findElement(By.xpath("//*[@id=\"menu_search\"]")).sendKeys("呆坏账缴费");
           driver.findElement(By.xpath("//*[@id=\"menu_search_list\"]/li[2]/div[1]/div")).click();

           try{
               Thread.sleep(10000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }


           //知识点：动态iframe
           driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name, 'navframeName')]")));
           Reporter.log("come on baby");
           //点击手机号下拉框
           driver.findElement(By.xpath("//*[@id=\"queryFlag_span\"]")).click();
           List<WebElement> list=driver.findElements(By.id("queryFlag_float"));
           System.out.println("到底有没有选中这个元素呢");
           for (WebElement ele:list){
               System.out.println("三个选取元素+"+ele.getText());
           }

           try{
               Thread.sleep(5000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
           //这里是为了验证能不能点击中对应元素的
           //driver.findElement(By.xpath("//*[@id=\"queryFlag_float\"]/div[2]/div/div/ul/li[3]/div")).click();
           //System.out.println("看到这里就是选中了");
           driver.findElement(By.id("phone_id")).sendKeys("17810015695");
           driver.findElement(By.id("queryLoss")).click();
           try{
               Thread.sleep(5000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
           //知识点来了，双击操作
           WebElement wb=driver.findElement(By.xpath("//*[@id=\"custInfoTable\"]/div[1]/div/table/tbody/tr[1]"));
           Actions RightClick =new Actions(driver);
           RightClick.doubleClick(wb).perform();
           System.out.println("到底能不能双击呀");
           try{
               Thread.sleep(2000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
           driver.findElement(By.xpath("//*[@id=\"wade_messagebox-2_btns\"]/button[1]")).click();
       }
       @AfterClass
       public void afterClass(){
            driver.quit();
       }


}
