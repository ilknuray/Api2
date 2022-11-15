package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JasonPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post050bjectMapper_Pojo extends JsonplaceholderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like  {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post05ObjectMapper(){
        spec.pathParam("first","todos");
        //set the expected dta
        JasonPojo expectedData=new JasonPojo(55,"Tidy your room",false);
        //Sen the request
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();
        //do assertion
        JasonPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), JasonPojo.class);
        System.out.println(actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }

}
