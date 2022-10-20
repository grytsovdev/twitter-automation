package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private static final String LOGIN_PAGE_URL = "https://twitter.com/login";

    @FindBy(xpath = "//input[@class = \"r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//div[@class=\"css-18t94o4 css-1dbjc4n r-sdzlij r-1phboty r-rs99b7 r-ywje51 r-usiww2 r-2yi16 r-1qi8awa r-1ny4l3l r-ymttw5 r-o7ynqc r-6416eg r-lrvibr r-13qz1uu\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@class = \"r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@data-testid = \"LoginForm_Login_Button\"]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_PAGE_URL);
        return this;
    }

    public MainPage login(User user) throws InterruptedException {
        waitForElementVisible(usernameField);
        usernameField.sendKeys(user.getUsername());
        nextButton.click();
        waitForElementVisible(passwordField);
        passwordField.sendKeys(user.getPassword());
        loginButton.click();


        return new MainPage(driver);
    }
}

