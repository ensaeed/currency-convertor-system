package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import models.ConversionTestData;
import utils.ConversionValidator;
import utils.CurrencyApiClient;
import utils.JsonDataReader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CurrencyConversionSteps {

    private List<ConversionTestData> dataList;
    private final List<Double> actualAmounts = new ArrayList<>();

    @Given("I have currency conversion test data")
    public void i_have_currency_conversion_test_data() throws Exception {
        dataList = JsonDataReader.readData();
    }

    @When("I request converted amounts from the exchange rate API")
    public void i_request_converted_amounts_from_the_exchange_rate_api() throws Exception {
        for (ConversionTestData data : dataList) {
            double actual = CurrencyApiClient.getConvertedAmount(
                    data.getFromCurrency(),
                    data.getToCurrency(),
                    data.getAmount()
            );

            actualAmounts.add(actual);
        }
    }

    @Then("the API converted amounts should be within tolerance")
    public void the_api_converted_amounts_should_be_within_tolerance() {
        for (int i = 0; i < dataList.size(); i++) {

            ConversionTestData data = dataList.get(i);

            double expected = ConversionValidator.calculateExpected(
                    data.getAmount(),
                    data.getExpectedRate()
            );

            double actual = actualAmounts.get(i);

            System.out.println("====================================");
            System.out.println("From: " + data.getFromCurrency());
            System.out.println("To: " + data.getToCurrency());
            System.out.println("Amount: " + data.getAmount());
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            System.out.println("====================================");

            assertTrue(
                    "Validation failed for " + data.getFromCurrency() + " to " + data.getToCurrency(),
                    ConversionValidator.isWithinTolerance(expected, actual)
            );
        }
    }
}
