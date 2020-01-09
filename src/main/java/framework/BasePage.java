package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import java.util.Iterator;
import java.util.Set;

public class BasePage {
    public static WebDriver driver;
    public static String pageTitle;
    public static String pageUrl;
    //构造方法
    protected  BasePage(WebDriver driver){
        BasePage.driver=driver;
    }
    //在文本中输入字符
    protected  void type(WebElement element,String text){
        try{
            if(element.isEnabled()){
                element.clear();
                Reporter.log("Clean the value if any in"+element.toString()+".");
                element.sendKeys(text);
                Reporter.log("Type value is: "+text+".");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //点击元素，这里指的是鼠标左击
    protected void  click(WebElement element){
        try{
            if(element.isEnabled()){
                element.click();
                Reporter.log("Element:"+element.toString()+"was clicked.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //在文本输入框执行清楚操作
    protected void clean(WebElement element){
        try{
            if (element.isEnabled()){
                element.click();
                Reporter.log("Element "+element.toString()+"was cleaned.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //判断一个元素是否在当前页面
    protected  void verifyElementIsPresent(WebElement element){
        try{
            if(element.isDisplayed()){
                Reporter.log("this Element "+element.toString().trim()+"is present");
            }else{
                Reporter.log("this Element "+element.toString().trim()+"is not present");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //获取页面的标题
    protected  String getCurrentPageTitle(){
        pageTitle=driver.getTitle();
        Reporter.log("Current page title is "+pageTitle);
        return  pageTitle;
    }
    //获取页面的URL
    protected  String getCurrentPageUrl(){
        pageUrl=driver.getCurrentUrl();
        Reporter.log("Current page url is "+pageUrl);
        return pageUrl;
    }
    //窗口之间的切换
    public void  switchWindow(){
        String currentWindow=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        Reporter.log("current windows size:"+handles.size());
        Iterator<String> it=handles.iterator();
        while(it.hasNext()){
            if(currentWindow==it.next()){
                continue;
            }
            try{
                driver.close();
                WebDriver window=driver.switchTo().window(it.next());
                Reporter.log("new page title:"+window.getTitle());
            }catch(Exception e){
                Reporter.log("can not switch new window"+e.getMessage());
            }
        }
    }
    //切换动态frame

}
