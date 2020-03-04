package API.HomeWork.postRequests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserTest {
    @Test
    public void createUser() throws IOException, URISyntaxException {
        UserCon user=new UserCon();
        user.setJob("SDET");
        user.setName("John");

        ObjectMapper objectMapper=new ObjectMapper();
        String userJson=objectMapper.writeValueAsString(user);

        StringEntity userEntyti=new StringEntity(userJson);
        HttpClient httpClient= HttpClientBuilder.create().build();

        //constructing URL
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");

        httpPost.setEntity(userEntyti);
        HttpResponse response=httpClient.execute(httpPost);

        UserCon createdUser=objectMapper.readValue(response.getEntity().getContent(),UserCon.class);

        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());
        Assert.assertEquals(user.getName(),createdUser.getName());
        Assert.assertEquals(user.getJob(),createdUser.getJob());

    }
}
