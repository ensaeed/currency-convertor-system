import models.ConversionTestData;
import org.junit.Test;
import utils.ConversionValidator;
import utils.JsonDataReader;
import utils.CurrencyApiClient;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SimpleTest {

    @Test
    public void testConversions() throws Exception {

        List<ConversionTestData> dataList = JsonDataReader.readData();

        for (ConversionTestData data : dataList) {

            double expected = ConversionValidator.calculateExpected(
                    data.getAmount(),
                    data.getExpectedRate()
            );

            // simulate actual (same as expected for now)
           double actual = CurrencyApiClient.getConvertedAmount(
                    data.getFromCurrency(),
                    data.getToCurrency(),
                    data.getAmount()
            );

            boolean result = ConversionValidator.isWithinTolerance(expected, actual);

            assertTrue("Validation failed for " + data.getFromCurrency(), result);
        }
    }
}