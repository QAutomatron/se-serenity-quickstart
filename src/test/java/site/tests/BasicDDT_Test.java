package site.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import site.requirements.Application;
import site.step.MainPageSteps;

import java.util.Arrays;
import java.util.Collection;

/**
 * Test Case Title
 */
@Story(Application.MainPage.TestFeature.class)
@RunWith(SerenityParameterizedRunner.class)
public class BasicDDT_Test {

    private final String testString;

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"input0"},
                {"input1"}
        });
    }

    public BasicDDT_Test(String testString) {
        this.testString = testString;
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    @ManagedPages
    public Pages pages;

    @Steps
    public MainPageSteps mainPageSteps;

    @Test
    @Issue("TESTCASE-001")
    @Title("Test Case Title")
    public void test_case_name() {

        // Open Main Page
        mainPageSteps.open();
        mainPageSteps.pageShouldBeOpened();
    }
}
