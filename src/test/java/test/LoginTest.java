package test;

import model.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import service.UserCreator;

public class loginTest extends CommonConditions {
    @Test
    public void test() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
        String text= new LoginPage(driver).openPage().login(testUser).getAccountMenuText();

        Assert.assertTrue(text.contains(testUser.getUsername()));


    }
}

