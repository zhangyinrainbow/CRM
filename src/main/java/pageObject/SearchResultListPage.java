package pageObject;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultListPage extends BasePage{
    //第一个商品
    @FindBy(xpath = "//*[@id='J_goodsList']/ul/li[1]/div/div[1]/a/img")
    WebElement searchResult_firstItem_img;
    //第二个商品
    @FindBy(xpath="//*[@id='J_goodsList']/ul/li[2]/div/div[1]/a/img")
    WebElement SearchResult_secondItem_img;
    //第一个商品的价格
    @FindBy(xpath = "//*[@id='J_goodsList']/ul/li[1]/div/div[3]/strong/i")
    WebElement searchResult_firstItem_price;
    public SearchResultListPage(WebDriver driver){
        super(driver);
    }
    //点击商品，进入商品详情页
    public GoodsDetailsPage clickItemImg() throws InterruptedException{
        click(searchResult_firstItem_img);
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.getMessage();
        }
        return new GoodsDetailsPage(driver);
    }
    //获取产品价格，好和详情页面做对比
    public String getGoodsPriceOnListPage(){
        return searchResult_firstItem_price.getText();
    }
}
