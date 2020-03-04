package API;


import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

public class CatFact {
    ObjectMapper objectMapper=new ObjectMapper();
    HttpClient httpClient=  HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();




}
