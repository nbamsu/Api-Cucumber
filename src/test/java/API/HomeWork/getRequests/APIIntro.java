package API.HomeWork.getRequests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class APIIntro {

    @Test
    public void firstApiCall() throws URISyntaxException, IOException {
        // Construct our http CLint
        HttpClient httpClient = HttpClientBuilder.create().build();
        // build endpoint
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/112233");

        //Construct our Request
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        //execute a get request
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println("Status cod check " + response.getStatusLine().getStatusCode());
        System.out.println("status " + response.getEntity().getContentType().getValue());
        //Status code verification
        Assert.assertEquals("", HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        //content type header verification
        Assert.assertEquals("Invalid code ", "application/json", response.getEntity().getContentType().getValue());

    }
    @Test
    public void SecondCallApi() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users?")
                .setCustomQuery("page=2");
                    //notapplication/json; charset=utf-8
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpGet);
        System.out.println("valid"+response.getStatusLine().getStatusCode());
        System.out.println("not"+response.getEntity().getContentType().getValue());
        Assert.assertEquals("",HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

    }
}
