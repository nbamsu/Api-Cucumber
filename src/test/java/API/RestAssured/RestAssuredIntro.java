package API.RestAssured;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import java.util.List;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredIntro {
    @Test
    public void introRestAssured() {
        given().header("Accept", "application/json")
                .when().get("https://reqres.in/api/users/1")
                .then().statusCode(200);

    }

    @Test
    public void restGetWithLogs() {
        given().header("Accept", "application/json")
                .get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void restGetWithLogsValidation() {
        given().header("Accept", "application/json")
                .get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails();

    }
    @Test
    public void restGetWithLogs3() {
        given().header("Accept", "application/json")
                .get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().all()
                .and().body("data.email", equalTo("george.bluth@reqres.in"));
    }
    @Test
    public void restWithLogsValidation(){
        given().header("Accept", "application/json")
                .get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data.email", equalTo("george.bluth@reqres.in"));
    }
    @Test
    public void restGetEmail(){
        given().header("Accept","application/json")
                .get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[1].email",equalTo("janet.weaver@reqres.in"));
    }
    @Test
    public void getName(){
        given().header("Accept","application/json")
                .get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[3].last_name",equalTo("Holt"));
    }

    @Test
    public void getAllId(){
        Response response=given().header("Accept","application/json").when()
                .get("https://reqres.in/api/users/");
        List<Integer> list=response.path("data.id");
        System.out.println(list);
    }

}
