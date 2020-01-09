package CRM;
import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMLogin extends BasePage{
    public CRMLogin(WebDriver driver){
        super(driver);
    }
    //输入账户名
    @FindBy(id="UserAccount")
    WebElement login_withAccount;
    //输入密码
    @FindBy(id="UserPwd")
    WebElement inputBox_password;
    //点击登录
    @FindBy(xpath = "//*[@id=\"fm_locallogin\"]/ul/li[3]/button")
    WebElement login_submitBtn;
    public CRMHomePage crmHomePage (String username,String passwd){
        type(login_withAccount,username);
        type(inputBox_password,passwd);
        click(login_submitBtn);
        return new CRMHomePage(driver);
    }
}
