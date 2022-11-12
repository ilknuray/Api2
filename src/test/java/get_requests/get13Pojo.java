package get_requests;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.MetaData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get13Pojo extends GorestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
       {
    "meta": null,
    "data": {
        "id": 2508,
        "name": "Vasundhara Nayar Ret.",
        "email": "ret_vasundhara_nayar@renner.co",
        "gender": "female",
        "status": "inactive"
    }
}
    */
    @Test
    public void get13Pojo(){
        spec.pathParams("first","users","second",2508);
        //set the expected data
        GoRestDataPojo goRestDataPojo=new GoRestDataPojo(2508,"Vasundhara Nayar Ret.","ret_vasundhara_nayar@renner.co","female","inactive");
        MetaData expectedData=new MetaData(null,goRestDataPojo);
        System.out.println(expectedData.toString());

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        MetaData actualData=response.as(MetaData.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(goRestDataPojo.getId(),actualData.getData().getId());
        assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
        //assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());


    }
}
