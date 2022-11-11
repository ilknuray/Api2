package patch_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonplaceholderBaseUrl {
     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */
    @Test
    public void patch01(){
        spec.pathParams("first","todos","second",198);
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();

        Map<String,Object>expectedData=obj.expectedData(null,"Wash the dishes",null);
        System.out.println(expectedData);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));
    }
}
