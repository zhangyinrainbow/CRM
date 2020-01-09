package CRM;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMHomePage extends BasePage{
    public CRMHomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"menu_search\"]")
    WebElement search_list;
    @FindBy(xpath = "//*[@id=\"menu_search_list\"]/li[2]/div[1]/div")
    WebElement search_submit;
    public CRMDaiHuaiZhang daiHuaiZhang(String keyword){
        type(search_list,keyword);
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        click(search_submit);
        return  new CRMDaiHuaiZhang(driver);
    }
}
