package ceshi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class denglu {
    //输入账户名
    @FindBy(id="UserAccount")
    WebElement login_withAccount;
    //输入密码
    @FindBy(id="UserPwd")
    WebElement inputBox_password;
    //点击登录
    @FindBy(xpath = "//*[@id=\"fm_locallogin\"]/ul/li[3]/button")
    WebElement login_submitBtn;
    public void login(String username,String password){
        login_withAccount.sendKeys(username);
        inputBox_password.sendKeys(password);
        login_submitBtn.click();
    }
}
