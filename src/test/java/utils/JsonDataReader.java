package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ConversionTestData;

import java.io.File;
import java.util.List;

public class JsonDataReader {

    public static List<ConversionTestData> readData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                new File("src/test/resources/testdata/conversions.json"),
                new TypeReference<List<ConversionTestData>>() {}
        );
    }
}