package pageObject;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    //搜索输入框
    @FindBy(xpath = "//*[@id=\"menu_search\"]")
    WebElement search_inputbox;
    //搜索提交按钮
    @FindBy(xpath = "//*[@id='search']/div/div[2]/button")
    WebElement search_submitBtn;
    public HomePage(WebDriver driver){
        super(driver);
    }
    public SearchResultListPage searchWithKeyWord(String keyword){
        type(search_inputbox,keyword);
        click(search_submitBtn);
        return new SearchResultListPage(driver);
    }
}
