package site.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import site.element.SomeElement;

import static org.junit.Assert.assertTrue;

/**
 * Steps for some element
 */
public class SomeElementSteps extends ScenarioSteps {

    private SomeElement getSomeElement(){
        return getPages().onSamePage().get(SomeElement.class);
    }

    /**
     * Check for Some element present
     */
    @Step(callNestedMethods = false)
    public void elementShouldBePresent() {
        assertTrue("Some Element Should be Present",
                getSomeElement().isElementPresent());
    }
}
