package serenitylabs.tutorials.seleniumeasy.serenity;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class WithSerenity extends UIInteractionSteps {

    private final String SELENIUM_EASY_DEMO_SITE = "https://www.seleniumeasy.com/test/";

    protected void openDemoPage(String page) {
        this.openUrl(SELENIUM_EASY_DEMO_SITE + page);
    }

}
