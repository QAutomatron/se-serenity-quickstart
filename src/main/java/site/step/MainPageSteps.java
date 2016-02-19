package site.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import site.page.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageSteps extends ScenarioSteps {

    private MainPage getMainPage() {
        return getPages().onSamePage().getAt(MainPage.class);
    }

    /**
     * Check is Main Page opened
     */
    @Step(callNestedMethods = false)
    public void pageShouldBeOpened() {
        assertTrue("Main Page should be opened",
                getMainPage().isPageOpened());
    }

    /**
     * Open Main Page
     */
    @Step(callNestedMethods = false)
    public void open() {
        getMainPage().open();
    }
}
