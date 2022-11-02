package get_requests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Practise {

    @Test
    public void test01(){
        /*
        Given
               https://jsonplaceholder.typicode.com/posts/44
        When
              get request
       then
        status code should be 200
       And
          content type should be JSON
       And
          userId=5
          title="optio dolor molestias sit"

         */

        //Set the url
        String url="https://jsonplaceholder.typicode.com/posts/44";

        //expected data
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",5);
        expectedData.put("title","optio dolor molestias sit");

        //send the request and get the response

        Response response=given().when().get(url);
        response.prettyPrint();

        //do assertion

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        JsonPath actualData=response.jsonPath();
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
    }
    @Test
    public void test02(){
        /* "https://jsonplaceholder.typicode.com/posts"
        get the url
        when
           title=API
           "body"=Api ogrenmek ne guzel
           userId=10
           status code=200
           content type=application/json
           response body
           title=API
           body=api ogrenmek ne guzel
           userid=10 oldugunu test edin


         */

        //set the url
        String url="https://jsonplaceholder.typicode.com/posts";
        //set the body
        JSONObject requestBody=new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","Api ogrenmek ne guzel");
        requestBody.put("userId","10");
        //set the expectedData
        JSONObject expectedBody=new JSONObject();
        expectedBody.put("title","API");
        expectedBody.put("body","Api ogrenmek ne guzel");
        expectedBody.put("userId","10");

        //send request and get the response

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post(url);

        JsonPath actualBody=response.jsonPath();

        response.prettyPrint();

        //do assertion
        response.
                then().
                assertThat().
                statusCode(201).
                contentType(ContentType.JSON);

      assertEquals(expectedBody.get("title"),actualBody.get("title"));
      assertEquals(expectedBody.get("body"),actualBody.get("body"));
      assertEquals(expectedBody.get("userId"),actualBody.get("userId"));
    }
}
