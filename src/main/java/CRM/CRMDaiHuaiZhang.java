package CRM;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMDaiHuaiZhang extends BasePage{
    public CRMDaiHuaiZhang(WebDriver driver){
        super(driver);
    }
    @FindBy(id="phone_id")
    WebElement phone_id;
    @FindBy(id="queryLoss")
    WebElement query_submit;
    @FindBy(xpath = "//*[@id=\"custInfoTable\"]/div[1]/div/table/tbody/tr[1]/td[1]")
    WebElement query_list;
    public void searchList(String phoneId){
        type(phone_id,phoneId);
        click(query_submit);
    }
    public String getQueryList(){
        return  query_list.getText();
    }

}
