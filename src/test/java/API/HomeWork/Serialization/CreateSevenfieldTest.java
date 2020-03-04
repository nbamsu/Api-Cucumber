package API.HomeWork.Serialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CreateSevenfieldTest {
    @Test
    public void serialize() throws IOException {
        CreateSevenPrivateFields create = new CreateSevenPrivateFields("Dudu",
                "dodo", 18, 'M', 9379992, "single");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src\\test\\java\\API\\HomeWork\\CreateSevenfieldTest.json"), create);
        String createJson=objectMapper.writeValueAsString(create);
        System.out.println(createJson);

    }
}