package get_requests;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get10 extends GorestBaseUrl {
    /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like

   {
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Navin Talwar",
        "email": "navin_talwar@mclaughlin.name",
        "gender": "male",
        "status": "inactive"
    }
}
     }
*/
    @Test
    public void test01(){
        //set the url
        spec.pathParams("first","users","second",2986);
        GoRestTestData obj=new GoRestTestData();
        Map<String,String>dataKeyMap=obj.dataKeyMap("Navin Talwar","navin_talwar@mclaughlin.name","male","inactive");
        Map<String,Object>expectedData=obj.expectedDataMethod(null,dataKeyMap);
        System.out.println(expectedData);


        //set the expected data
       /* Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("id", 2986);
        expectedData.put("name","Navin Talwar");
        expectedData.put("email","navin_talwar@mclaughlin.name");
        expectedData.put("gender","male");
        expectedData.put("status","inactive");
        System.out.println(expectedData);

        Map<String,Object>expectedMeta=null;
        System.out.println(expectedMeta);*/

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //do assertion
        response.then().assertThat().statusCode(200);

        //assertEquals();

    }

}
