package API;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class APIIntro {


    @Test
    public void firstGetCall() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        //creating a client (like Postman)
        HttpClient httpClient = HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/789456");
        //defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        //executing the API call
        HttpResponse response = httpClient.execute(httpGet);
        Map<String, Object> firstDeserialization = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {

                });
        System.out.println(firstDeserialization.get("id"));
        System.out.println(firstDeserialization.get("status"));
        Map<String, Object> categoryMap = (Map<String, Object>) firstDeserialization.get("category");
        String name = categoryMap.get("name").toString();
        int id = (Integer) categoryMap.get("id");
        System.out.println(id);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void secondCall() throws URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/9216678377732792007");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
    }

    @Test
    public void getIDName() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //create a client (likePostman) --> its come from apache library
        HttpClient httpClient = HttpClientBuilder.create().build();
        //constructor URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");
        //defining a Get method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        //executing A Get Method
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response.getStatusLine().getStatusCode());
        Map<String, Object> secondDeser = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        Map<String, Object> category = (Map<String, Object>) secondDeser.get("category");
        int id = (Integer) category.get("id");
        System.out.println(id);
        String name = (String) category.get("name");
        System.out.println("My dog id: " + id + " \nMy dog's name: " + name);
    }

    @Test
    public void printFirstName() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users")
                .setCustomQuery("page=2"); //query
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> allUsers = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        List<Map<String, Object>> usersDataList = (List<Map<String, Object>>) allUsers.get("data");
        for (int i = 0; i < usersDataList.size(); i++) {
            String firstName = (String) usersDataList.get(i).get("first_name");
            System.out.println(firstName);
        }

    }
}
