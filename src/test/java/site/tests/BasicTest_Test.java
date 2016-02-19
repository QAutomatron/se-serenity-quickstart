package site.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import site.requirements.Application;
import site.step.MainPageSteps;

/**
 * Test Case Name
 */
@Story(Application.MainPage.BasicTest.class)
@RunWith(SerenityRunner.class)
public class BasicTest_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    @ManagedPages
    public Pages pages;

    @Steps
    public MainPageSteps mainPageSteps;

    @Test
    @Issue("TESTCASE-002")
    @Title("Test case name")
    public void basic_test_case() {

        // Open Main Page
        mainPageSteps.open();
        mainPageSteps.pageShouldBeOpened();
    }
}
