import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class APITest {
    String basePath = "https://reqres.in";

    @Test
    void test1() {
        Response responseFromService = RestAssured.get(basePath + "/api/users?page=2");
        System.out.println("The response is: " + responseFromService.asString());
        System.out.println("The status code is: " + responseFromService.getStatusCode());
        System.out.println("The body is: " + responseFromService.getBody());

        int statusCodeFromService = responseFromService.getStatusCode();
        Assert.assertEquals(statusCodeFromService, 200);
    }

    @Test
    void test2(){
        given().
                get(basePath + "/api/users?page=2").
                then().
                statusCode(200);
    }
}
