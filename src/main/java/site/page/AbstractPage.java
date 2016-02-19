package site.page;

import app.InvisibilityOfElement;
import app.InvisibilityOfElementLocated;
import app.VisibilityOfElement;
import app.VisibilityOfElementLocated;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.scheduling.ThucydidesFluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AbstractPage extends PageObject {

    private static final int DEFAULT_IMPLICITLY_WAIT = 15000;
    private final int implicitWait = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait", Integer.toString(DEFAULT_IMPLICITLY_WAIT)));

    public AbstractPage(WebDriver driver) {
        super(driver, DEFAULT_IMPLICITLY_WAIT);
    }

    protected int getImplicitWait() {
        return implicitWait;
    }

    /**
     * Wait for element in DOM (without checking visibility)
     * @param locator element locator
     * @return boolean
     */
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = getDriver().findElements(locator);
        return elements.size() > 0;
    }

    /**
     * Wait for element in DOM (without checking visibility)
     * @param locator element locator
     * @param timeout timeout
     * @return boolean
     */
    protected boolean isElementPresent(By locator, int timeout) {
        boolean result = false;
        setImplicitTimeout(timeout, TimeUnit.MILLISECONDS);
        List<WebElementFacade> elements = findAll(locator);
        if (elements.size() > 0) {
            result = true;
        }
        resetImplicitTimeout();
        return result;
    }

    /**
     * Wait for element is NOT in DOM (without checking visibility)
     * @param locator element locator
     * @return boolean
     */
    protected boolean isElementNotPresent(By locator) {
        List<WebElementFacade> elements = findAll(locator);
        return elements.size() <= 0;
    }

    /**
     * Wait for element is NOT in DOM (without checking visibility)
     * @param locator element locator
     * @param timeout timeout
     * @return boolean
     */
    protected boolean isElementNotPresent(By locator, int timeout) {
        boolean result = true;
        setImplicitTimeout(timeout, TimeUnit.MILLISECONDS);
        List<WebElementFacade> elements = findAll(locator);
        if (elements.size() > 0) {
            result = false;
        }
        resetImplicitTimeout();
        return result;
    }

    /**
     * Wait for element visibility
     * @param locator element locator
     * @return boolean
     */
    protected boolean waitForElementPresent(By locator) {
        return waitForElementPresent(locator, implicitWait);
    }

    /**
     * Wait for element visibility
     * @param locator element locator
     * @param timeout timeout
     * @return boolean
     */
    protected boolean waitForElementPresent(By locator, int timeout) {
        setImplicitTimeout(0, TimeUnit.MILLISECONDS);
        Boolean result = true;
        ThucydidesFluentWait<WebDriver> wait = waitForCondition()
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        try {
            wait.until(new VisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait for element visibility
     * @param element web element
     * @return boolean
     */
    protected boolean waitForElementPresent(WebElement element) {
        return waitForElementPresent(element, implicitWait);
    }

    /**
     * Wait for element visibility
     * @param element web element
     * @param timeout timeout
     * @return boolean
     */
    protected boolean waitForElementPresent(WebElement element, int timeout) {
        setImplicitTimeout(0, TimeUnit.MILLISECONDS);
        Boolean result = true;
        ThucydidesFluentWait<WebDriver> wait = waitForCondition()
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        WebElement wef = $(element).withTimeoutOf(100, TimeUnit.MILLISECONDS);
        try {
            wait.until(new VisibilityOfElement(wef));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait for element invisibility
     * @param locator element locator
     * @return boolean
     */
    protected boolean waitForElementNotPresent(By locator) {
        return waitForElementNotPresent(locator, implicitWait);
    }

    /**
     * Wait for element invisibility
     * @param locator element locator
     * @param timeout timeout
     * @return boolean
     */
    protected boolean waitForElementNotPresent(By locator, int timeout) {
        setImplicitTimeout(0, TimeUnit.MILLISECONDS);
        Boolean result = true;
        ThucydidesFluentWait<WebDriver> wait = waitForCondition()
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        try {
            wait.until(new InvisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait for element invisibility
     * @param element WebElement
     * @return boolean
     */
    protected boolean waitForElementNotPresent(WebElement element) {
        return waitForElementNotPresent(element, implicitWait);
    }

    /**
     * Wait for element invisibility
     * @param element WebElement
     * @param timeout timeout
     * @return boolean
     */
    protected boolean waitForElementNotPresent(WebElement element, int timeout) {
        setImplicitTimeout(0, TimeUnit.MILLISECONDS);
        Boolean result = true;
        ThucydidesFluentWait<WebDriver> wait = waitForCondition()
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        WebElement wef = $(element).withTimeoutOf(100, TimeUnit.MILLISECONDS);
        try {
            wait.until(new InvisibilityOfElement(wef));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }
}
