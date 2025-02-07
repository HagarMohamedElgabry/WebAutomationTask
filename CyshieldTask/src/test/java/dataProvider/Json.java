package dataProvider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.JsonHelper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class Json {

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() throws IOException {
        // Reading the JSON file
        File file = new File("src/test/java/data/testData.json");
        ObjectMapper objectMapper = new ObjectMapper();

        // Parsing the JSON file into JsonNode
        JsonNode rootNode = objectMapper.readTree(file);

        // Extracting the data for valid and invalid users
        JsonNode validUser = rootNode.get("validUser");
        JsonNode invalidUser = rootNode.get("invalidUser");

        return new Object[][] {
                {
                        validUser.get("username").asText(),
                        validUser.get("email").asText(),
                        validUser.get("password").asText(),
                        "valid"
                },
                {
                        invalidUser.get("username").asText(),
                        invalidUser.get("email").asText(),
                        invalidUser.get("password").asText(),
                        "invalid"
                }
        };
    }
}

