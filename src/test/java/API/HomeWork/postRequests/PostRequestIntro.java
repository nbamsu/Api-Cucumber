package API.HomeWork.postRequests;

import API.HomeWork.Serialization.CreateSevenPrivateFields;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PostRequestIntro {
    public void createPet() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder()
                .setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet");
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");

            // we create an object
        CreateSevenPrivateFields create = new CreateSevenPrivateFields("Dudu",
                "dodo", 18, 'M', 9379992, "single");
        ObjectMapper objectMapper=new ObjectMapper();

        // serialize object to json
        String json=objectMapper.writeValueAsString(create);

        //constructed post request body
        StringEntity entity=new StringEntity(json);

        // set post request body
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);

    }
}
