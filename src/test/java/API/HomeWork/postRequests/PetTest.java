package API.HomeWork.postRequests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PetTest {
    @Test
    public void create() throws IOException, URISyntaxException {
        //Create an object
        Category category = new Category(111, "paw port");
        // create photo URLs
        List<String> photoUrls = new ArrayList();
        photoUrls.add("www.google.com");
        //create list of object
        Tags tags = new Tags();
        tags.setName("tags name");
        tags.setId(999);
        //create list og tag
        List<Tags> tagsList = new ArrayList();
        tagsList.add(tags);
        //create pet object
        Pet pet = new Pet(2233, category, "Pro", photoUrls, tagsList, "sold");
        ObjectMapper objectMapper = new ObjectMapper();

        //set object mapper pretty print property
        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

        //serialize pet object to json format
        objectMapper.writeValue(new File("src\\test\\java\\API\\HomeWork\\postRequests\\Pet.json"), pet);

        //Http client is like Postman
        HttpClient httpClient = HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");

        // serialize object to json
        String json = objectMapper.writeValueAsString(pet);

        //constructed post request body
        StringEntity entity = new StringEntity(json);

        // set post request body
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        Pet createdPet=objectMapper.readValue(response.getEntity().getContent(),Pet.class);

        Assert.assertEquals(pet.getName(),createdPet.getName());
        Assert.assertEquals(pet.getId(),createdPet.getId());

    }
}
