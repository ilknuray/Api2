package put_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Put01 extends JsonplaceholderBaseUrl {
        /*
           Given
               1) https://jsonplaceholder.typicode.com/todos/198
               2) {
                    "userId": 21,
                    "title": s"Wash the dishes,
                    "completed": false
                  }
           When
                I send PUT Request to the Url
           Then
                 Status code is 200
                 And response body is like   {
                                           "userId": 21,
                                           "title": "Wash the dishes",
                                           "completed": false
                                           "id": 198
                                          }
        */
        @Test
        public void put01(){
            spec.pathParams("first","todos","second",198);


            //set the expected data
            JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
            Map<String,Object>expected=obj.expectedData(21,"Wash the dishes",false);
            System.out.println(expected);

            //send the request
            Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().put("/{first}/{second}");
            response.prettyPrint();

            //do assertion
            Map<String,Object>actual=response.as(HashMap.class);
            assertEquals(expected.get("completed"),actual.get("completed"));
            assertEquals(expected.get("userId"),actual.get("userId"));
            assertEquals(expected.get("title"),actual.get("title"));


        }

    }
