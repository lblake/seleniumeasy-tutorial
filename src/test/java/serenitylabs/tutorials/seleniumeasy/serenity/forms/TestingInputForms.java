package serenitylabs.tutorials.seleniumeasy.serenity.forms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.seleniumeasy.serenity.WithSerenity;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class TestingInputForms extends WithSerenity {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void openPage() {
        openDemoPage("basic-first-form-demo.html");
    }

    @Test
    public void enteringASingleInputForm() {
        // Added if clause to check if the pop-up box appears if so close it so the test can continue
        if (driver.findElement(By.id("image-darkener")).isDisplayed()) {

            driver.findElement(By.cssSelector(("#at-cv-button at-cv-lightbox-yesno at-cm-no-button"))).click();

        } else {

            // TODO: Enter a message in the Single Input Field and check that it is shown
            driver.findElement(By.id("user-message")).sendKeys("Hello world");
            driver.findElement(By.cssSelector("#get-input button")).click();

            String displayedText = driver.findElement(By.id("display")).getText();

            assertThat(displayedText).isEqualTo("Hello world");
        }
    }

    @Test
    public void enterTwoValues() {

        // Added if clause to check if the pop-up box appears if so close it so the test can continue
        if (driver.findElement(By.id("image-darkener")).isDisplayed()) {

            driver.findElement(By.cssSelector(("#at-cv-button at-cv-lightbox-yesno at-cm-no-button"))).click();

        } else {
            // TODO: Enter a number in each input field and verify the calculated total
            // Enter value for A: 1
            driver.findElement(By.id("sum1")).sendKeys("1");
            // Enter value for B: 2
            driver.findElement(By.id("sum2")).sendKeys("2");


            // Click on the Get Total button
            driver.findElement(By.cssSelector("#gettotal button")).click();

            String displayedValue = driver.findElement(By.xpath("//span[@id = 'displayvalue']")).getText();

            // Check that the result is equal to 3
            assertThat(displayedValue).isEqualTo("3");
        }

    }

}
