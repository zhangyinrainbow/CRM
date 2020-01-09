package ceshi;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiFenTiaoZheng {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        //初始化一个chrome浏览器实例，实例名称叫driver
        WebDriver driver = new ChromeDriver();
        //最大化窗口
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

        driver.findElement(By.xpath("//*[@id=\"menu_search\"]")).sendKeys("积分调整");
        driver.findElement(By.xpath("//*[@id=\"menu_search_list\"]/li[2]/div[1]/div")).click();
        /*div盒子弹窗,解决方式：获取句柄，切换句柄，不行呀*/
        //String handle = driver.getWindowHandle();
       // System.out.println(handle);
        //System.out.println(driver.getWindowHandles());
/*
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
 */

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        //知识点：动态iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name, 'navframeName')]")));
        driver.findElement(By.id("MSISDN")).sendKeys("17810015695");
        driver.findElement(By.xpath("//*[@id=\"123\"]/div[1]/div[2]/ul/li[2]/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"NOTE\"]")).click();
        //点击查询按钮
        driver.findElement(By.xpath("//*[@id=\"queryScroPart\"]/div[1]/div[2]/div/button")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //driver.switchTo().defaultContent();








        //关闭并退出浏览器
        //driver.quit();
    }

}
