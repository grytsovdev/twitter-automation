package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(xpath ="//div[@data-testid='SideNav_AccountSwitcher_Button']" )
    private WebElement AccountMenu;
    private static final String MAIN_PAGE_URL = "https://twitter.com";

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public String getAccountMenuText() {
        waitForElementVisible(AccountMenu);
        return AccountMenu.getText();
    }

}

