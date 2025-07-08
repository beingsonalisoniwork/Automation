package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseApiTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class GetUsersTest extends BaseApiTest {

    @Test
    public void testGetUsers() {
        Response response = get("/api/users?page=2");
        
        // Overwrite baseURI and Alertnative
        // RestAssured.baseURI = "url";
        // Response response = RestAssured.get("/api/users?page=2");

        Assert.assertEquals(response.statusCode(), 200);
        // Assert.assertTrue(response.getBody().toString().contains("Janet"));
        // API data keeps on changing, hence no Janet found
        Assert.assertTrue(response.getBody().asString().contains("data"));

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }
}
