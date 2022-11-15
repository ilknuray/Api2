package deleteRequest;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JasonPojo;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonplaceholderBaseUrl {
        /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */
    @Test
    public void delete01(){
        spec.pathParams("first","todos","second",198);
        //set the expected data
        Map<String,String>expectedData=new HashMap<>();

        //send the request
        Response response=given().spec(spec).delete("/{first}/{second}");
        response.prettyPrint();
        //do assertion
        Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        //1. Yol
        assertEquals(expectedData, actualData);

        //2. Yol
        assertTrue(actualData.isEmpty());

        //3. Yol
        assertEquals(0,actualData.size());

    }
}
