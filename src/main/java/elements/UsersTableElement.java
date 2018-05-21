package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTableElement {

    private final WebDriver webDriver;

    private WebElement table;

    public UsersTableElement(final WebDriver webDriver) {
        this.webDriver = webDriver;
        table = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.usersList.usersList\"]/table"));
    }

    public boolean containsByLoginColumn(final String value) {
        table = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.usersList.usersList\"]/table"));
        List<WebElement> rowElements = table.findElements(By.xpath(".//tr"));
        for (WebElement row : rowElements) {
            List<WebElement> cellElements = row.findElements(By.xpath(".//td"));
            if (cellElements != null && !cellElements.isEmpty() && cellElements.get(0).getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void deleteByLoginColumn(final String value) {
        table = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.usersList.usersList\"]/table"));
        List<WebElement> rowElements = table.findElements(By.xpath(".//tr"));
        for (WebElement row : rowElements) {
            List<WebElement> cellElements = row.findElements(By.xpath(".//td"));
            if (cellElements != null && !cellElements.isEmpty() && cellElements.get(0).getText().equals(value)) {
                cellElements.get(5).findElements(By.xpath(".//a")).get(0).click();
                webDriver.switchTo().alert().accept();
                break;
            }
        }
    }
}
