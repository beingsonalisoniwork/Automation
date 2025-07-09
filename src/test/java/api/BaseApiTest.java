package api;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseApiTest {

    @BeforeClass
    public void setUpApi() {
        RestAssured.baseURI = "https://reqres.in";
    }

    // Environment Setup
    // @BeforeClass
    // @Parameters("env")
    // public void setUpApi(String env) {
    //     if (env.equals("staging")) {
    //         RestAssured.baseURI = "https://staging.reqres.in";
    //     } else {
    //         RestAssured.baseURI = "https://reqres.in";
    // }
}