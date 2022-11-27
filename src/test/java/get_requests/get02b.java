package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get02b extends ReqresBaseUrl {
        /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
    @Test
    public void test01(){

        //set the url
        spec.pathParams("first","api","second","users","third",23);


        //set the expected data

        //set the request data and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}/");
        response.prettyPrint();

        //do assertion
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());

        assertEquals("cloudflare",response.header("Server"));
        assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());

        assertEquals(2,response.asString().replaceAll("\\s","").length());

    }
}
