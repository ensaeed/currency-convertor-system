package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.XeCurrencyPage;

import static org.junit.Assert.assertTrue;

public class XeCurrencySteps {

    Playwright playwright;
    Browser browser;
    Page page;
    XeCurrencyPage xeCurrencyPage;

    @Given("I open the XE currency converter page")
    public void i_open_the_xe_currency_converter_page() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );

        page = browser.newPage();
        xeCurrencyPage = new XeCurrencyPage(page);

        xeCurrencyPage.navigateToXeConverter();
    }

    @Then("the XE currency converter page should be displayed")
    public void the_xe_currency_converter_page_should_be_displayed() {
        String title = xeCurrencyPage.getPageTitle();

        assertTrue(
                "XE page was not displayed. Actual title: " + title,
                title.toLowerCase().contains("xe")
        );

        browser.close();
        playwright.close();
    }


    @When("I convert {double} from {word} to {word} using XE UI")
    public void i_convert_from_to_using_xe_ui(double amount, String fromCurrency, String toCurrency) {
        xeCurrencyPage.enterAmount(amount);
        xeCurrencyPage.selectFromCurrency(fromCurrency);
        xeCurrencyPage.selectToCurrency(toCurrency);
        xeCurrencyPage.clickConvert();
    }

    @Then("I should see a conversion result on XE UI")
    public void i_should_see_a_conversion_result_on_xe_ui() {
        String resultText = xeCurrencyPage.getConversionResultText();

        assertTrue(
                "Expected conversion result to be displayed, but result text was: " + resultText,
                resultText != null && !resultText.isBlank()
        );

        browser.close();
        playwright.close();
    }
}