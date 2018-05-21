package pages;

import elements.CreateUserFormElement;
import elements.UsersTableElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class UsersPage {

    private final WebDriver webDriver;

    private final UsersTableElement usersTableElement;

    public UsersPage(final WebDriver webDriver) {
        webDriver.get("http://localhost:8080/users");
        this.webDriver = webDriver;
        usersTableElement = new UsersTableElement(webDriver);
    }

    public void goToUsers() throws InterruptedException {
        webDriver.findElement(By.linkText("Users")).click();
    }

    public CreateUserFormElement createUser() throws InterruptedException {
        webDriver.findElement(By.id("id_l.U.createNewUser")).click();
        return new CreateUserFormElement(webDriver);
    }

    public UsersTableElement getUsersTable() {
        return usersTableElement;
    }

    public WebElement getErrorPopup() throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (webDriver.findElement(By.xpath("//*[@id=\"__popup__1\"]/table/tbody/tr/td[2]/ul/li[2]")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        return webDriver.findElement(By.xpath("//*[@id=\"__popup__1\"]/table/tbody/tr/td[2]/ul/li[2]"));
    }
}
