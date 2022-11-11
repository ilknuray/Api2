package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post01(){
        //set the url
        spec.pathParam("1","todos");
        //set the expected data
        JsonPlaceHolderTestData expectedData=new JsonPlaceHolderTestData();
        Map<String,Object>expected=expectedData.expectedData(55,"Tidy your room",false);

        //send request and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().post("/{1}");
        response.prettyPrint();

        //do assertion
        response.then().statusCode(201);
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(expected.get("userId"),actualData.get("userId"));
        assertEquals(expected.get("title"),actualData.get("title"));
        assertEquals(expected.get("completed"),actualData.get("completed"));
    }

}
