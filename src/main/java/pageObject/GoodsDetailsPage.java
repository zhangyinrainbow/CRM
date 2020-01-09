package pageObject;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoodsDetailsPage extends BasePage{
    //商品详情页，价格对比，下单入口操作
    @FindBy(xpath = "//*/span[@class='p-price']/span[2]")
    WebElement goods_price;
    @FindBy(id = "InitCartUrl")
    WebElement addToCart_Btn;
    public GoodsDetailsPage(WebDriver driver){
        super(driver);
    }
    public String getPriceDetailsPage(){
        return goods_price.getText();
    }
    public void addGoodsToCart(){
        click(addToCart_Btn);
    }
}
