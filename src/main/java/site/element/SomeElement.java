package site.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.page.MainPage;

/**
 * Some element
 */
public class SomeElement extends MainPage {

    private final String elementLocator = "//div[contains(@class,'js-paging')]";

    public SomeElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Check is Element Present on Page
     * @return boolean
     */
    public boolean isElementPresent() {
        return waitForElementPresent(By.xpath(elementLocator));
    }

    /**
     * Check is Element Not Present on Page
     * @return boolean
     */
    public boolean isElementNotPresent() {
        return waitForElementNotPresent(By.xpath(elementLocator));
    }
}
