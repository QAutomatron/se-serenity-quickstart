package site.page;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("/")
public class MainPage extends AbstractPage {

    @FindBy(id = "id")
    private WebElement mainPageBlock;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check for Main Page opened by presence of main block
     * @return boolean
     */
    public boolean isPageOpened() {
        return waitForElementPresent(mainPageBlock);
    }
}
